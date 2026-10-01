package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val category: String, // "Makanan Utama", "Cake & Kue", "Minuman", "Camilan Sehat"
    val province: String,
    val cookingTimeMinutes: Int,
    val prepTimeMinutes: Int,
    val difficulty: String, // "Mudah", "Sedang", "Mahir"
    val servings: Int,
    val calories: Int, // per porsi standard (kkal)
    val protein: Double, // g
    val carbs: Double, // g
    val fat: Double, // g
    val fiber: Double, // g
    val dietTags: String, // comma-separated e.g. "Tinggi Protein, Halal, Bebas Gluten"
    val mainIngredients: String, // comma-separated e.g. "Daging Sapi, Santan, Cabai"
    val ingredients: String, // multiline string of ingredients with measurements
    val instructions: String, // multiline string of steps
    val chefTips: String,
    val isFavorite: Boolean = false,
    val rating: Double = 4.8,
    val reviewCount: Int = 120,
    val iconBadge: String = "spicy" // "meat", "seafood", "poultry", "cake", "drink", "snack", "vegetable"
) {
    val totalTimeMinutes: Int
        get() = prepTimeMinutes + cookingTimeMinutes

    fun getIngredientList(): List<String> {
        return ingredients.split("\n").filter { it.isNotBlank() }
    }

    fun getScaledIngredientList(targetServings: Int): List<String> {
        return com.example.util.IngredientScaler.scaleIngredients(
            ingredientLines = getIngredientList(),
            originalServings = servings,
            targetServings = targetServings
        )
    }

    fun getInstructionList(): List<String> {
        return instructions.split("\n").filter { it.isNotBlank() }
    }

    fun getDietTagList(): List<String> {
        return dietTags.split(",").map { it.trim() }.filter { it.isNotEmpty() }
    }

    fun getMainIngredientList(): List<String> {
        return mainIngredients.split(",").map { it.trim() }.filter { it.isNotEmpty() }
    }
}

@Entity(tableName = "shopping_items")
data class ShoppingItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val recipeId: Int? = null,
    val recipeTitle: String = "Manual",
    val ingredientName: String,
    val quantity: String,
    val category: String = "Lainnya", // "Bumbu & Rempah", "Sayuran & Buah", "Daging & Seafood", "Bahan Kue", "Lainnya"
    val isChecked: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "meal_logs")
data class MealLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val recipeId: Int,
    val recipeTitle: String,
    val servings: Double,
    val calories: Int,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val dateStr: String, // YYYY-MM-DD
    val mealType: String, // "Sarapan", "Makan Siang", "Makan Malam", "Camilan"
    val timestamp: Long = System.currentTimeMillis()
)
