package com.example.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.data.db.AppDatabase
import com.example.data.model.MealLogEntity
import com.example.data.model.RecipeEntity
import com.example.data.model.ShoppingItemEntity
import com.example.data.seed.NusantaraRecipeDataProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RecipeRepository(context: Context) {
    private val database = AppDatabase.getDatabase(context)
    private val recipeDao = database.recipeDao()
    private val shoppingDao = database.shoppingDao()
    private val mealLogDao = database.mealLogDao()
    private val prefs: SharedPreferences = context.getSharedPreferences("user_nutrition_prefs", Context.MODE_PRIVATE)

    suspend fun ensureDatabaseSeeded() = withContext(Dispatchers.IO) {
        val currentVersion = prefs.getInt("recipe_data_version", 0)
        val count = recipeDao.getRecipeCount()
        if (count < 500 || currentVersion < 2) {
            val favIds = recipeDao.getFavoriteIds().toSet()
            val freshRecipes = NusantaraRecipeDataProvider.getInitial500Recipes().map {
                if (favIds.contains(it.id)) it.copy(isFavorite = true) else it
            }
            recipeDao.upsertAll(freshRecipes)
            prefs.edit().putInt("recipe_data_version", 2).apply()
        }
    }

    fun getAllRecipes(): Flow<List<RecipeEntity>> = recipeDao.getAllRecipes()

    fun getRecipeById(id: Int): Flow<RecipeEntity?> = recipeDao.getRecipeById(id)

    fun getFavoriteRecipes(): Flow<List<RecipeEntity>> = recipeDao.getFavoriteRecipes()

    fun searchRecipes(query: String): Flow<List<RecipeEntity>> = recipeDao.searchRecipes(query)

    suspend fun toggleFavorite(recipeId: Int, isFav: Boolean) = withContext(Dispatchers.IO) {
        recipeDao.setFavorite(recipeId, isFav)
    }

    // Shopping List
    fun getShoppingItems(): Flow<List<ShoppingItemEntity>> = shoppingDao.getAllShoppingItems()

    suspend fun toggleShoppingItem(id: Long, isChecked: Boolean) = withContext(Dispatchers.IO) {
        shoppingDao.toggleChecked(id, isChecked)
    }

    suspend fun deleteShoppingItem(id: Long) = withContext(Dispatchers.IO) {
        shoppingDao.deleteItem(id)
    }

    suspend fun deleteCheckedShoppingItems() = withContext(Dispatchers.IO) {
        shoppingDao.deleteCheckedItems()
    }

    suspend fun clearShoppingList() = withContext(Dispatchers.IO) {
        shoppingDao.clearAll()
    }

    suspend fun addCustomShoppingItem(name: String, quantity: String, category: String) = withContext(Dispatchers.IO) {
        shoppingDao.insertItem(
            ShoppingItemEntity(
                ingredientName = name.trim(),
                quantity = quantity.trim(),
                category = category
            )
        )
    }

    suspend fun addRecipeIngredientsToShoppingList(
        recipe: RecipeEntity,
        targetServings: Int
    ) = withContext(Dispatchers.IO) {
        val ingredients = recipe.getScaledIngredientList(targetServings)
        val itemsToAdd = ingredients.map { line ->
            // Categorize by common Indonesian culinary ingredients
            val lower = line.lowercase(Locale.ROOT)
            val category = when {
                lower.contains("bawang") || lower.contains("kunyit") || lower.contains("jahe") ||
                        lower.contains("lengkuas") || lower.contains("serai") || lower.contains("cabai") ||
                        lower.contains("ketumbar") || lower.contains("merica") || lower.contains("pala") ||
                        lower.contains("cengkeh") || lower.contains("kayu manis") || lower.contains("garam") ||
                        lower.contains("terasi") || lower.contains("kemiri") || lower.contains("asam") -> "Bumbu & Rempah"

                lower.contains("daging") || lower.contains("ayam") || lower.contains("ikan") ||
                        lower.contains("udang") || lower.contains("bebek") || lower.contains("sapi") ||
                        lower.contains("babat") || lower.contains("telur") -> "Daging & Protein"

                lower.contains("kangkung") || lower.contains("bayam") || lower.contains("nangka") ||
                        lower.contains("tomat") || lower.contains("tauge") || lower.contains("labu") ||
                        lower.contains("daun") || lower.contains("jagung") || lower.contains("kol") ||
                        lower.contains("mentimun") || lower.contains("alpukat") || lower.contains("pisang") -> "Sayuran & Buah"

                lower.contains("tepung") || lower.contains("sagu") || lower.contains("gula") ||
                        lower.contains("ragi") || lower.contains("maizena") || lower.contains("mentega") -> "Bahan Kue & Tepung"

                lower.contains("santan") || lower.contains("minyak") || lower.contains("susu") -> "Santan & Minyak"

                else -> "Lainnya"
            }

            ShoppingItemEntity(
                recipeId = recipe.id,
                recipeTitle = recipe.title,
                ingredientName = line,
                quantity = "$targetServings Porsi",
                category = category,
                isChecked = false
            )
        }
        shoppingDao.insertItems(itemsToAdd)
    }

    // Meal Logs & Calorie tracking
    fun getTodayMealLogs(): Flow<List<MealLogEntity>> {
        val todayStr = getTodayDateString()
        return mealLogDao.getMealLogsByDate(todayStr)
    }

    suspend fun logMeal(
        recipe: RecipeEntity,
        servings: Double,
        mealType: String
    ) = withContext(Dispatchers.IO) {
        val scaledCalories = (recipe.calories * servings).toInt()
        val scaledProtein = recipe.protein * servings
        val scaledCarbs = recipe.carbs * servings
        val scaledFat = recipe.fat * servings

        mealLogDao.insertLog(
            MealLogEntity(
                recipeId = recipe.id,
                recipeTitle = recipe.title,
                servings = servings,
                calories = scaledCalories,
                protein = scaledProtein,
                carbs = scaledCarbs,
                fat = scaledFat,
                dateStr = getTodayDateString(),
                mealType = mealType
            )
        )
    }

    suspend fun deleteMealLog(id: Long) = withContext(Dispatchers.IO) {
        mealLogDao.deleteLog(id)
    }

    fun getDailyCalorieTarget(): Int {
        return prefs.getInt("daily_calorie_target", 2000)
    }

    fun setDailyCalorieTarget(target: Int) {
        prefs.edit().putInt("daily_calorie_target", target).apply()
    }

    fun getCalorieCalculatorData(): Pair<Int, String> {
        val target = prefs.getInt("daily_calorie_target", 2000)
        val goal = prefs.getString("user_goal", "Jaga Berat Badan") ?: "Jaga Berat Badan"
        return Pair(target, goal)
    }

    fun saveCalorieCalculatorData(target: Int, goal: String) {
        prefs.edit()
            .putInt("daily_calorie_target", target)
            .putString("user_goal", goal)
            .apply()
    }

    private fun getTodayDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}
