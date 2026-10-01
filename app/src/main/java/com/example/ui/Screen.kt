package com.example.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.RestaurantMenu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : Screen("home", "Eksplorasi", Icons.Filled.RestaurantMenu, Icons.Outlined.RestaurantMenu)
    object Favorites : Screen("favorites", "Favorit", Icons.Filled.Bookmark, Icons.Outlined.BookmarkBorder)
    object Nutrition : Screen("nutrition", "Nutrisi", Icons.Filled.Calculate, Icons.Outlined.Calculate)
    object Shopping : Screen("shopping", "Belanja", Icons.Filled.ShoppingCart, Icons.Outlined.ShoppingCart)
    object RecipeDetail : Screen("recipe_detail", "Detail Resep", Icons.Filled.RestaurantMenu, Icons.Outlined.RestaurantMenu)
    object CookingMode : Screen("cooking_mode", "Mode Dapur", Icons.Filled.RestaurantMenu, Icons.Outlined.RestaurantMenu)
}
