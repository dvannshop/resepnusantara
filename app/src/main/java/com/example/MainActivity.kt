package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.Screen
import com.example.ui.screens.CookingModeScreen
import com.example.ui.screens.FavoritesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.NutritionCalculatorScreen
import com.example.ui.screens.RecipeDetailScreen
import com.example.ui.screens.ShoppingListScreen
import com.example.ui.theme.ResepNusantaraTheme
import com.example.ui.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResepNusantaraTheme {
                MainAppContent(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainAppContent(viewModel: RecipeViewModel) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
    var previousScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    val snackbarHostState = remember { SnackbarHostState() }
    val snackMessage by viewModel.snackMessage.collectAsStateWithLifecycle()

    LaunchedEffect(snackMessage) {
        snackMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearSnackMessage()
        }
    }

    // State collections
    val filteredRecipes by viewModel.filteredRecipes.collectAsStateWithLifecycle()
    val favoriteRecipes by viewModel.favoriteRecipes.collectAsStateWithLifecycle()
    val shoppingItems by viewModel.shoppingItems.collectAsStateWithLifecycle()
    val todayMealLogs by viewModel.todayMealLogs.collectAsStateWithLifecycle()
    val dailyTarget by viewModel.dailyTarget.collectAsStateWithLifecycle()

    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val selectedProvince by viewModel.selectedProvince.collectAsStateWithLifecycle()
    val selectedDietTag by viewModel.selectedDietTag.collectAsStateWithLifecycle()
    val selectedIngredient by viewModel.selectedIngredient.collectAsStateWithLifecycle()
    val sortOrder by viewModel.sortOrder.collectAsStateWithLifecycle()

    val selectedRecipe by viewModel.selectedRecipe.collectAsStateWithLifecycle()
    val recipeServings by viewModel.recipeServings.collectAsStateWithLifecycle()

    val completedSteps by viewModel.completedSteps.collectAsStateWithLifecycle()
    val timerTotalSeconds by viewModel.timerTotalSeconds.collectAsStateWithLifecycle()
    val timerRemainingSeconds by viewModel.timerRemainingSeconds.collectAsStateWithLifecycle()
    val isTimerRunning by viewModel.isTimerRunning.collectAsStateWithLifecycle()

    val bottomNavScreens = listOf(
        Screen.Home,
        Screen.Favorites,
        Screen.Nutrition,
        Screen.Shopping
    )

    val showBottomBar = currentScreen in bottomNavScreens

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    windowInsets = WindowInsets.navigationBars,
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    bottomNavScreens.forEach { screen ->
                        val isSelected = currentScreen.route == screen.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                if (currentScreen != screen) {
                                    currentScreen = screen
                                }
                            },
                            icon = {
                                if (screen == Screen.Shopping && shoppingItems.isNotEmpty()) {
                                    BadgedBox(
                                        badge = {
                                            val unboughtCount = shoppingItems.count { !it.isChecked }
                                            if (unboughtCount > 0) {
                                                Badge { Text("$unboughtCount") }
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                            contentDescription = screen.title
                                        )
                                    }
                                } else if (screen == Screen.Favorites && favoriteRecipes.isNotEmpty()) {
                                    BadgedBox(
                                        badge = {
                                            Badge { Text("${favoriteRecipes.size}") }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                            contentDescription = screen.title
                                        )
                                    }
                                } else {
                                    Icon(
                                        imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                        contentDescription = screen.title
                                    )
                                }
                            },
                            label = {
                                Text(
                                    text = screen.title,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            modifier = Modifier.testTag("nav_tab_${screen.route}")
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        AnimatedContent(
            targetState = currentScreen,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "ScreenTransition",
            modifier = Modifier.padding(innerPadding)
        ) { targetScreen ->
            when (targetScreen) {
                Screen.Home -> {
                    HomeScreen(
                        viewModel = viewModel,
                        recipes = filteredRecipes,
                        searchQuery = searchQuery,
                        selectedCategory = selectedCategory,
                        selectedProvince = selectedProvince,
                        selectedDietTag = selectedDietTag,
                        selectedIngredient = selectedIngredient,
                        sortOrder = sortOrder,
                        onRecipeClick = { recipe ->
                            viewModel.selectRecipe(recipe)
                            previousScreen = Screen.Home
                            currentScreen = Screen.RecipeDetail
                        }
                    )
                }

                Screen.Favorites -> {
                    FavoritesScreen(
                        viewModel = viewModel,
                        favoriteRecipes = favoriteRecipes,
                        onRecipeClick = { recipe ->
                            viewModel.selectRecipe(recipe)
                            previousScreen = Screen.Favorites
                            currentScreen = Screen.RecipeDetail
                        }
                    )
                }

                Screen.Nutrition -> {
                    NutritionCalculatorScreen(
                        viewModel = viewModel,
                        dailyTarget = dailyTarget,
                        todayMealLogs = todayMealLogs
                    )
                }

                Screen.Shopping -> {
                    ShoppingListScreen(
                        viewModel = viewModel,
                        shoppingItems = shoppingItems
                    )
                }

                Screen.RecipeDetail -> {
                    val recipe = selectedRecipe
                    if (recipe != null) {
                        RecipeDetailScreen(
                            recipe = recipe,
                            viewModel = viewModel,
                            servings = recipeServings,
                            onBack = { currentScreen = previousScreen },
                            onStartCookingMode = { currentScreen = Screen.CookingMode }
                        )
                    } else {
                        currentScreen = Screen.Home
                    }
                }

                Screen.CookingMode -> {
                    val recipe = selectedRecipe
                    if (recipe != null) {
                        CookingModeScreen(
                            recipe = recipe,
                            viewModel = viewModel,
                            servings = recipeServings,
                            completedSteps = completedSteps,
                            timerTotalSeconds = timerTotalSeconds,
                            timerRemainingSeconds = timerRemainingSeconds,
                            isTimerRunning = isTimerRunning,
                            onBack = { currentScreen = Screen.RecipeDetail }
                        )
                    } else {
                        currentScreen = Screen.Home
                    }
                }
            }
        }
    }
}
