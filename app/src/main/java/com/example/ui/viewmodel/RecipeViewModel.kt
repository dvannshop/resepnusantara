package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.MealLogEntity
import com.example.data.model.RecipeEntity
import com.example.data.model.ShoppingItemEntity
import com.example.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Locale

enum class SortOrder(val label: String) {
    POPULAR("Terpopuler"),
    CALORIE_LOW("Kalori Terendah"),
    CALORIE_HIGH("Kalori Tertinggi"),
    TIME_FAST("Waktu Tercepat"),
    ALPHABETICAL("Nama A-Z")
}

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RecipeRepository(application)

    val allRecipes = repository.getAllRecipes().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val favoriteRecipes = repository.getFavoriteRecipes().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val shoppingItems = repository.getShoppingItems().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val todayMealLogs = repository.getTodayMealLogs().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    // Filter and search states
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("Semua")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    private val _selectedProvince = MutableStateFlow<String?>(null)
    val selectedProvince: StateFlow<String?> = _selectedProvince.asStateFlow()

    private val _selectedDietTag = MutableStateFlow<String?>(null)
    val selectedDietTag: StateFlow<String?> = _selectedDietTag.asStateFlow()

    private val _selectedIngredient = MutableStateFlow<String?>(null)
    val selectedIngredient: StateFlow<String?> = _selectedIngredient.asStateFlow()

    private val _sortOrder = MutableStateFlow(SortOrder.POPULAR)
    val sortOrder: StateFlow<SortOrder> = _sortOrder.asStateFlow()

    // Daily Calorie Target
    private val _dailyTarget = MutableStateFlow(repository.getDailyCalorieTarget())
    val dailyTarget: StateFlow<Int> = _dailyTarget.asStateFlow()

    // Detail Screen states
    private val _selectedRecipe = MutableStateFlow<RecipeEntity?>(null)
    val selectedRecipe: StateFlow<RecipeEntity?> = _selectedRecipe.asStateFlow()

    private val _recipeServings = MutableStateFlow(4)
    val recipeServings: StateFlow<Int> = _recipeServings.asStateFlow()

    // Notification toast / snackbar message
    private val _snackMessage = MutableStateFlow<String?>(null)
    val snackMessage: StateFlow<String?> = _snackMessage.asStateFlow()

    // Kitchen Cooking Mode
    private val _completedSteps = MutableStateFlow<Set<Int>>(emptySet())
    val completedSteps: StateFlow<Set<Int>> = _completedSteps.asStateFlow()

    // Cooking Timer
    private val _timerTotalSeconds = MutableStateFlow(0)
    val timerTotalSeconds: StateFlow<Int> = _timerTotalSeconds.asStateFlow()

    private val _timerRemainingSeconds = MutableStateFlow(0)
    val timerRemainingSeconds: StateFlow<Int> = _timerRemainingSeconds.asStateFlow()

    private val _isTimerRunning = MutableStateFlow(false)
    val isTimerRunning: StateFlow<Boolean> = _isTimerRunning.asStateFlow()

    data class FilterParams(
        val query: String,
        val category: String,
        val province: String?,
        val dietTag: String?,
        val ingredient: String?,
        val sort: SortOrder
    )

    private val filterParams = combine(
        _searchQuery,
        _selectedCategory,
        _selectedProvince,
        _selectedDietTag,
        _selectedIngredient
    ) { query, category, province, dietTag, ingredient ->
        FilterParams(query, category, province, dietTag, ingredient, _sortOrder.value)
    }.combine(_sortOrder) { params, sort ->
        params.copy(sort = sort)
    }

    // Filtered Recipes list
    val filteredRecipes: StateFlow<List<RecipeEntity>> = combine(
        allRecipes,
        filterParams
    ) { recipes, params ->
        var result = recipes

        // 1. Search Query
        if (params.query.isNotBlank()) {
            val q = params.query.trim().lowercase(Locale.ROOT)
            result = result.filter { recipe ->
                recipe.title.lowercase(Locale.ROOT).contains(q) ||
                        recipe.mainIngredients.lowercase(Locale.ROOT).contains(q) ||
                        recipe.province.lowercase(Locale.ROOT).contains(q) ||
                        recipe.category.lowercase(Locale.ROOT).contains(q) ||
                        recipe.dietTags.lowercase(Locale.ROOT).contains(q)
            }
        }

        // 2. Category filter
        if (params.category != "Semua") {
            result = result.filter { it.category == params.category }
        }

        // 3. Province filter
        if (!params.province.isNullOrBlank() && params.province != "Semua Provinsi") {
            result = result.filter { it.province == params.province }
        }

        // 4. Diet filter
        if (!params.dietTag.isNullOrBlank() && params.dietTag != "Semua Diet") {
            when (params.dietTag) {
                "Rendah Kalori (<300 kkal)" -> {
                    result = result.filter { it.calories < 300 }
                }
                else -> {
                    result = result.filter { it.dietTags.contains(params.dietTag, ignoreCase = true) }
                }
            }
        }

        // 5. Main Ingredient filter
        if (!params.ingredient.isNullOrBlank() && params.ingredient != "Semua Bahan") {
            result = result.filter { it.mainIngredients.contains(params.ingredient, ignoreCase = true) }
        }

        // 6. Sorting
        when (params.sort) {
            SortOrder.POPULAR -> result.sortedByDescending { it.rating * 1000 + it.reviewCount }
            SortOrder.CALORIE_LOW -> result.sortedBy { it.calories }
            SortOrder.CALORIE_HIGH -> result.sortedByDescending { it.calories }
            SortOrder.TIME_FAST -> result.sortedBy { it.totalTimeMinutes }
            SortOrder.ALPHABETICAL -> result.sortedBy { it.title }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    init {
        viewModelScope.launch {
            repository.ensureDatabaseSeeded()
        }
    }

    // Filter mutations
    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setCategory(category: String) {
        _selectedCategory.value = category
    }

    fun setProvince(province: String?) {
        _selectedProvince.value = province
    }

    fun setDietTag(tag: String?) {
        _selectedDietTag.value = tag
    }

    fun setIngredient(ingredient: String?) {
        _selectedIngredient.value = ingredient
    }

    fun setSortOrder(order: SortOrder) {
        _sortOrder.value = order
    }

    fun resetFilters() {
        _searchQuery.value = ""
        _selectedCategory.value = "Semua"
        _selectedProvince.value = null
        _selectedDietTag.value = null
        _selectedIngredient.value = null
        _sortOrder.value = SortOrder.POPULAR
    }

    // Recipe Details
    fun selectRecipe(recipe: RecipeEntity) {
        _selectedRecipe.value = recipe
        _recipeServings.value = recipe.servings
        _completedSteps.value = emptySet()
    }

    fun setRecipeServings(servings: Int) {
        if (servings in 1..24) {
            _recipeServings.value = servings
        }
    }

    fun toggleFavorite(recipe: RecipeEntity) {
        viewModelScope.launch {
            val newFav = !recipe.isFavorite
            repository.toggleFavorite(recipe.id, newFav)
            if (_selectedRecipe.value?.id == recipe.id) {
                _selectedRecipe.value = _selectedRecipe.value?.copy(isFavorite = newFav)
            }
            _snackMessage.value = if (newFav) "Ditambahkan ke Favorit" else "Dihapus dari Favorit"
        }
    }

    // Shopping List
    fun addRecipeToShoppingList(recipe: RecipeEntity, servings: Int) {
        viewModelScope.launch {
            repository.addRecipeIngredientsToShoppingList(recipe, servings)
            _snackMessage.value = "Bahan '${recipe.title}' untuk $servings porsi berhasil ditambahkan ke daftar belanja!"
        }
    }

    fun toggleShoppingItem(item: ShoppingItemEntity) {
        viewModelScope.launch {
            repository.toggleShoppingItem(item.id, !item.isChecked)
        }
    }

    fun deleteShoppingItem(item: ShoppingItemEntity) {
        viewModelScope.launch {
            repository.deleteShoppingItem(item.id)
        }
    }

    fun deleteCheckedShoppingItems() {
        viewModelScope.launch {
            repository.deleteCheckedShoppingItems()
            _snackMessage.value = "Bahan yang sudah dibeli telah dibersihkan"
        }
    }

    fun clearShoppingList() {
        viewModelScope.launch {
            repository.clearShoppingList()
            _snackMessage.value = "Daftar belanja telah dikosongkan"
        }
    }

    fun addCustomShoppingItem(name: String, quantity: String, category: String) {
        viewModelScope.launch {
            repository.addCustomShoppingItem(name, quantity, category)
            _snackMessage.value = "Bahan '$name' berhasil ditambahkan"
        }
    }

    // Daily Calorie & Nutrition Tracker
    fun logMeal(recipe: RecipeEntity, servings: Double, mealType: String) {
        viewModelScope.launch {
            repository.logMeal(recipe, servings, mealType)
            _snackMessage.value = "Berhasil dicatat ke asupan $mealType hari ini!"
        }
    }

    fun deleteMealLog(log: MealLogEntity) {
        viewModelScope.launch {
            repository.deleteMealLog(log.id)
            _snackMessage.value = "Catatan menu dihapus"
        }
    }

    fun updateDailyTarget(target: Int) {
        _dailyTarget.value = target
        repository.setDailyCalorieTarget(target)
        _snackMessage.value = "Target kalori harian diperbarui ke $target kkal"
    }

    fun clearSnackMessage() {
        _snackMessage.value = null
    }

    // Cooking Mode
    fun toggleStepCompleted(stepIndex: Int) {
        val current = _completedSteps.value.toMutableSet()
        if (current.contains(stepIndex)) {
            current.remove(stepIndex)
        } else {
            current.add(stepIndex)
        }
        _completedSteps.value = current
    }

    // Cooking Timer Controls
    fun startTimer(minutes: Int) {
        val totalSecs = minutes * 60
        _timerTotalSeconds.value = totalSecs
        _timerRemainingSeconds.value = totalSecs
        _isTimerRunning.value = true
    }

    fun pauseTimer() {
        _isTimerRunning.value = false
    }

    fun resumeTimer() {
        if (_timerRemainingSeconds.value > 0) {
            _isTimerRunning.value = true
        }
    }

    fun resetTimer() {
        _isTimerRunning.value = false
        _timerRemainingSeconds.value = _timerTotalSeconds.value
    }

    fun stopTimer() {
        _isTimerRunning.value = false
        _timerTotalSeconds.value = 0
        _timerRemainingSeconds.value = 0
    }

    fun decrementTimer() {
        if (_isTimerRunning.value && _timerRemainingSeconds.value > 0) {
            _timerRemainingSeconds.value -= 1
            if (_timerRemainingSeconds.value == 0) {
                _isTimerRunning.value = false
                _snackMessage.value = "Waktu memasak selesai!"
            }
        }
    }
}
