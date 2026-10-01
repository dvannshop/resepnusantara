package com.example

import com.example.data.seed.NusantaraRecipeDataProvider
import com.example.util.IngredientScaler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

  @Test
  fun test500RecipesCatalogTotalAndCategories() {
    val recipes = NusantaraRecipeDataProvider.getInitial500Recipes()
    assertEquals("Total resep harus tepat 500", 500, recipes.size)

    val mainDishes = recipes.filter { it.category == "Makanan Utama" }
    val cakes = recipes.filter { it.category == "Cake & Kue" }
    val drinks = recipes.filter { it.category == "Minuman" }
    val snacks = recipes.filter { it.category == "Camilan Sehat" }

    assertEquals("Jumlah Makanan Utama harus 200", 200, mainDishes.size)
    assertEquals("Jumlah Cake & Kue harus 100", 100, cakes.size)
    assertEquals("Jumlah Minuman harus 100", 100, drinks.size)
    assertEquals("Jumlah Camilan Sehat harus 100", 100, snacks.size)
  }

  @Test
  fun testRecipeNutritionAndCulinaryStandards() {
    val recipes = NusantaraRecipeDataProvider.getInitial500Recipes()
    for (recipe in recipes) {
      assertTrue("Judul resep tidak boleh kosong: ${recipe.id}", recipe.title.isNotBlank())
      assertTrue("Provinsi asal tidak boleh kosong: ${recipe.id}", recipe.province.isNotBlank())
      assertTrue("Bahan resep tidak boleh kosong: ${recipe.id}", recipe.ingredients.isNotBlank())
      assertTrue("Instruksi memasak tidak boleh kosong: ${recipe.id}", recipe.instructions.isNotBlank())
      assertTrue("Tips chef tidak boleh kosong: ${recipe.id}", recipe.chefTips.isNotBlank())
      assertTrue("Kalori harus bernilai positif: ${recipe.id}", recipe.calories > 0)
      assertTrue("Protein harus bernilai positif: ${recipe.id}", recipe.protein >= 0)
      assertTrue("Waktu memasak harus valid: ${recipe.id}", recipe.cookingTimeMinutes > 0)
      assertTrue("Porsi standar harus valid: ${recipe.id}", recipe.servings > 0)
    }
  }

  @Test
  fun testPortionAndMacroScaling() {
    val recipes = NusantaraRecipeDataProvider.getInitial500Recipes()
    val rendang = recipes.first { it.id == 1 }

    assertEquals(540, rendang.calories)
    assertEquals(42.0, rendang.protein, 0.01)

    // Test 2x scaling calculation
    val doublePortions = rendang.servings * 2
    val multiplier = doublePortions.toDouble() / rendang.servings.toDouble()
    val scaledCalories = (rendang.calories * multiplier).toInt()
    val scaledProtein = rendang.protein * multiplier

    assertEquals(1080, scaledCalories)
    assertEquals(84.0, scaledProtein, 0.01)
  }

  @Test
  fun testIngredientScalerLogic() {
    // 2x scaling tests
    val scaledBeef = IngredientScaler.scaleSingleLine("500 gr daging sapi sengkel", 2.0)
    assertTrue("Harus menjadi 1000 gr: $scaledBeef", scaledBeef.contains("1000 gr"))

    val scaledCoconut = IngredientScaler.scaleSingleLine("1.5 liter santan kental", 2.0)
    assertTrue("Harus menjadi 3 liter: $scaledCoconut", scaledCoconut.contains("3 liter"))

    val scaledLemongrass = IngredientScaler.scaleSingleLine("3 batang serai memarkan", 2.0)
    assertTrue("Harus menjadi 6 batang: $scaledLemongrass", scaledLemongrass.contains("6 batang"))

    val scaledPepper = IngredientScaler.scaleSingleLine("1/2 sdt merica butir", 2.0)
    assertTrue("Harus menjadi 1 sdt: $scaledPepper", scaledPepper.contains("1 sdt"))

    val scaledEgg = IngredientScaler.scaleSingleLine("4 butir telur bebek", 2.0)
    assertTrue("Harus menjadi 8 butir: $scaledEgg", scaledEgg.contains("8 butir"))

    // Secukupnya test
    val secukupnya = IngredientScaler.scaleSingleLine("Garam dan gula secukupnya", 2.0)
    assertEquals("Garam dan gula secukupnya", secukupnya)

    // Recipe level scaling
    val recipes = NusantaraRecipeDataProvider.getInitial500Recipes()
    val rawon = recipes.first { it.id == 2 } // 5 servings originally
    val scaledList = rawon.getScaledIngredientList(10) // 2x servings (10 servings)

    // Original has "500 gr daging sapi sandung lamur"
    val beefLine = scaledList.first { it.contains("daging sapi") }
    assertTrue("Harus berskala 1000 gr saat porsi 2x: $beefLine", beefLine.contains("1000 gr"))
  }

  @Test
  fun testMultiItemAndComplexLinesScaling() {
    // Multi item line scaling
    val multiLine = "Bumbu halus: 8 siung bawang merah, 4 siung bawang putih, 4 kemiri, 2 cm jahe, 1 sdt ketumbar"
    val scaledMulti = IngredientScaler.scaleSingleLine(multiLine, 2.0)

    assertTrue("16 siung bawang merah: $scaledMulti", scaledMulti.contains("16 siung bawang merah"))
    assertTrue("8 siung bawang putih: $scaledMulti", scaledMulti.contains("8 siung bawang putih"))
    assertTrue("8 kemiri: $scaledMulti", scaledMulti.contains("8 kemiri"))
    assertTrue("4 cm jahe: $scaledMulti", scaledMulti.contains("4 cm jahe"))
    assertTrue("2 sdt ketumbar: $scaledMulti", scaledMulti.contains("2 sdt ketumbar"))

    // Cooking dimension preservation test (potong dadu 4 cm should NOT scale)
    val meatLine = "1 kg daging sapi bagian paha/sengkel, potong dadu 4 cm"
    val scaledMeat = IngredientScaler.scaleSingleLine(meatLine, 2.0)
    assertTrue("Daging harus 2 kg: $scaledMeat", scaledMeat.contains("2 kg"))
    assertTrue("Ukuran potongan dadu 4 cm harus tetap 4 cm: $scaledMeat", scaledMeat.contains("potong dadu 4 cm"))

    // Fraction scaling
    val fractionLine = "1/4 sdt garam halus"
    val scaledFraction = IngredientScaler.scaleSingleLine(fractionLine, 2.0)
    assertTrue("1/4 sdt * 2 harus menjadi 1/2 sdt: $scaledFraction", scaledFraction.contains("1/2 sdt"))

    // Mixed fraction scaling
    val mixedFractionLine = "1 1/2 sdm kecap manis"
    val scaledMixed = IngredientScaler.scaleSingleLine(mixedFractionLine, 2.0)
    assertTrue("1 1/2 sdm * 2 harus 3 sdm: $scaledMixed", scaledMixed.contains("3 sdm"))
  }
}
