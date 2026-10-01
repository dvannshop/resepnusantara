package com.example.data.seed

import com.example.data.model.RecipeEntity

object NusantaraDrinksProvider {

    data class DrinkSpec(
        val baseTitle: String,
        val mainIngredients: String,
        val ingredientsRaw: String,
        val instructionsRaw: String,
        val chefTips: String,
        val cookingTime: Int,
        val prepTime: Int,
        val calories: Int,
        val protein: Double,
        val carbs: Double,
        val fat: Double,
        val fiber: Double,
        val dietTags: String
    )

    private val specs = listOf(
        DrinkSpec(
            baseTitle = "Bajigur Hangat Santan Jahe Rempah",
            mainIngredients = "Santan Kelapa Murni, Gula Aren Cokelat, Jahe Bakar, Kayu Manis, Kolang Kaling",
            ingredientsRaw = """800 ml santan sedang dari 1 butir kelapa
150 gr gula aren cokelat tua sisir halus
2 batang serai memarkan
2 ruas jahe merah (sekitar 60 gr), bakar lalu memarkan
1 batang kayu manis (sekitar 5 cm)
2 lembar daun pandan wangi simpulkan
1/2 sdt garam halus
1 sdm kopi bubuk hitam tanpa ampas (opsional khas Sunda)
Pelengkap: 100 gr kolang-kaling rebus iris tipis""".trimIndent(),
            instructionsRaw = """1. Masukkan santan, gula aren, jahe memarkan, serai, kayu manis, daun pandan, dan garam ke dalam panci.
2. Masak dengan api sedang cenderung kecil sambil terus diaduk menimba secara perlahan agar santan tidak pecah.
3. Setelah mendidih dan aroma rempah jahe kayu manis harum semerbak, tambahkan kopi bubuk, aduk rata selama 2 menit.
4. Matikan api dan saring bajigur ke dalam cangkir saji.
5. Beri irisan kolang-kaling kenyal di dalam cangkir. Nikmati selagi hangat bersama ubi atau pisang rebus.""".trimIndent(),
            chefTips = "Membakar jahe sebelum dimemarkan dan mengaduk santan terus-menerus adalah kunci kuah bajigur lembut gurih tanpa lapisan minyak terpisah.",
            cookingTime = 20, prepTime = 10,
            calories = 160, protein = 2.0, carbs = 26.0, fat = 6.0, fiber = 1.8,
            dietTags = "Halal, Tradisional, Menghangatkan Tubuh"
        ),
        DrinkSpec(
            baseTitle = "Bandrek Hangat Kelapa Keruk Rempah",
            mainIngredients = "Jahe Merah Bakar, Gula Merah Aren, Merica Hitam, Cengkeh, Daging Kelapa Muda",
            ingredientsRaw = """1 liter air bersih
150 gr jahe merah bakar, bersihkan lalu memarkan
120 gr gula merah aren murni sisir
1 sdt merica hitam butir, tumbuk kasar
5 butir cengkeh
1 batang kayu manis 5 cm
2 batang serai memarkan
2 lembar daun pandan
1/4 sdt garam halus
Pelengkap: 1 butir kelapa muda, ambil serutan dagingnya""".trimIndent(),
            instructionsRaw = """1. Masukkan air ke dalam panci bersama jahe merah bakar memarkan, gula aren, merica hitam tumbuk, cengkeh, kayu manis, serai, dan daun pandan.
2. Rebus dengan api sedang hingga mendidih dan warna air berubah menjadi cokelat kemerahan wangi pekat (sekitar 15 menit).
3. Kecilkan api, biarkan mendidih perlahan selama 5 menit agar sari pedas jahe dan merica terekstraksi maksimal.
4. Saring kuah bandrek ke dalam gelas saji.
5. Masukkan serutan kelapa muda segar ke dalam gelas kuah bandrek panas. Sajikan hangat melegakan tenggorokan.""".trimIndent(),
            chefTips = "Merica hitam butir yang ditumbuk kasar memberikan sensasi hangat mendalam di dada yang sangat cocok dinikmati saat cuaca dingin.",
            cookingTime = 20, prepTime = 10,
            calories = 130, protein = 1.2, carbs = 28.0, fat = 2.0, fiber = 1.5,
            dietTags = "Rendah Lemak, Halal, Herbal Sehat"
        ),
        DrinkSpec(
            baseTitle = "Wedang Ronde Jahe Isi Kacang Gula",
            mainIngredients = "Tepung Ketan Putih, Kacang Tanah Sangrai Tumbuk, Kuah Jahe Pandan, Gula Aren",
            ingredientsRaw = """Bahan Bola Ronde:
200 gr tepung ketan putih
1 sdm tepung tapioka
170 ml air hangat dicampur sedikit garam
Pewarna makanan alami merah dan hijau
Bahan Isian Kacang:
100 gr kacang tanah tanpa kulit, sangrai matang lalu tumbuk kasar
60 gr gula pasir
1 sdm air hangat
Bahan Kuah Jahe:
1 liter air
150 gr jahe memarkan
120 gr gula merah aren sisir
2 batang serai memarkan
2 lembar daun pandan""".trimIndent(),
            instructionsRaw = """1. Isian: Campurkan kacang tanah tumbuk dengan gula pasir dan 1 sdm air, aduk hingga bisa dipadatkan menjadi butiran kecil seukuran kelereng.
2. Kulit: Uleni tepung ketan dan tapioka dengan air hangat bertahap hingga kalis lembut. Bagi 3 bagian: beri pewarna merah, hijau, dan biarkan putih.
3. Ambil 10 gr adonan kulit, pipihkan, masukkan 1 butir bola kacang, rapatkan dan bulatkan licin mulus.
4. Rebus bola ronde dalam air mendidih hingga mengapung matang, angkat dan tiriskan ke air dingin.
5. Kuah: Rebus air, jahe, gula aren, serai, dan pandan hingga mendidih harum meresap selama 15 menit. Saring.
6. Masukkan bola ronde warna-warni ke mangkuk, siram dengan kuah jahe panas harum.""".trimIndent(),
            chefTips = "Tiriskan bola ronde yang baru matang sebentar ke dalam air matang dingin agar kulitnya kenyal tidak saling menempel di mangkuk.",
            cookingTime = 30, prepTime = 25,
            calories = 210, protein = 4.2, carbs = 42.0, fat = 3.5, fiber = 2.0,
            dietTags = "Halal, Bebas Gluten, Tradisional"
        ),
        DrinkSpec(
            baseTitle = "Es Kuwut Timun Jeruk Nipis Biji Selasih",
            mainIngredients = "Mentimun Segar Serut, Melon Hijau, Biji Selasih, Air Kelapa Muda, Jeruk Nipis",
            ingredientsRaw = """2 buah mentimun segar, buang bijinya lalu serut memanjang tipis
1/2 buah melon hijau, serut memanjang
1 sdm biji selasih, rendam air hangat hingga mengembang mekar
500 ml air kelapa muda asli beserta kerukan daging kelapa
3 buah jeruk nipis, peras airnya
150 ml sirup gula pasir pandan (rebusan gula dan pandan)
Bongkahan es batu secukupnya""".trimIndent(),
            instructionsRaw = """1. Siapkan wadah mangkuk besar atau pitcher.
2. Masukkan serutan mentimun segar, serutan melon hijau, dan kerukan kelapa muda.
3. Tambahkan biji selasih yang sudah mengembang transparan.
4. Tuangkan air kelapa muda segar, air perasan jeruk nipis, dan sirup gula pandan. Aduk rata hingga rasa manis asam segarnya seimbang.
5. Masukkan bongkahan es batu dingin melimpah.
6. Tuang ke dalam gelas saji tinggi dan sajikan dingin menyegarkan di siang hari.""".trimIndent(),
            chefTips = "Buang bagian biji mentimun sebelum diserut agar kuah es kuwut tidak berair keruh dan tekstur timun tetap renyah garing saat diseruput.",
            cookingTime = 10, prepTime = 15,
            calories = 95, protein = 1.0, carbs = 22.0, fat = 0.5, fiber = 2.0,
            dietTags = "Rendah Kalori, Rendah Lemak, Halal, Segar Alami"
        ),
        DrinkSpec(
            baseTitle = "Jamu Kunyit Asam Segar Dingin Tradisional",
            mainIngredients = "Rimpang Kunyit Segar Bakar, Asam Jawa Matang, Gula Aren Murni, Garam Laut",
            ingredientsRaw = """250 gr rimpang kunyit segar tua, cuci bersih bakar sebentar lalu parut/blender
100 gr asam jawa matang tanpa biji
150 gr gula aren murni cokelat tua sisir
1 liter air matang bersih
1/4 sdt garam laut alami""".trimIndent(),
            instructionsRaw = """1. Peras parutan kunyit dengan 200 ml air, saring air sarinya ke dalam panci.
2. Masukkan sisa 800 ml air, asam jawa matang, gula aren murni, dan garam laut ke dalam panci.
3. Rebus di atas api sedang sambil diaduk hingga mendidih dan aroma asam kunyit wangi menyatu (sekitar 15 menit).
4. Matikan api, saring kembali jamu kunyit asam menggunakan kain kasa saring halus agar bersih tanpa endapan ampas.
5. Dinginkan di suhu ruang, lalu simpan dalam botol kaca di kulkas.
6. Nikmati dingin dengan es batu atau hangat untuk menyegarkan badan dan melancarkan sirkulasi darah.""".trimIndent(),
            chefTips = "Membakar rimpang kunyit sebelum diparut menghilangkan aroma getir langu tanah dan mengeluarkan zat kurkumin alami yang cerah harum.",
            cookingTime = 20, prepTime = 15,
            calories = 80, protein = 0.8, carbs = 19.0, fat = 0.2, fiber = 1.2,
            dietTags = "Rendah Kalori, Antioksidan Alami, Bebas Gluten, Halal, Jamu Tradisional"
        )
    )

    fun getRemainingDrinks(startId: Int, targetCount: Int, provinces: List<String>): List<RecipeEntity> {
        val list = mutableListOf<RecipeEntity>()
        var currentId = startId

        while (list.size < targetCount) {
            val spec = specs[(currentId - startId) % specs.size]
            val province = provinces[(currentId - 1) % provinces.size]
            val title = "${spec.baseTitle} Khas $province"

            list.add(
                RecipeEntity(
                    id = currentId,
                    title = title,
                    category = "Minuman",
                    province = province,
                    cookingTimeMinutes = spec.cookingTime,
                    prepTimeMinutes = spec.prepTime,
                    difficulty = "Mudah",
                    servings = 4,
                    calories = spec.calories,
                    protein = spec.protein,
                    carbs = spec.carbs,
                    fat = spec.fat,
                    fiber = spec.fiber,
                    dietTags = spec.dietTags,
                    mainIngredients = spec.mainIngredients,
                    ingredients = spec.ingredientsRaw,
                    instructions = spec.instructionsRaw,
                    chefTips = spec.chefTips,
                    rating = 4.8,
                    reviewCount = 80 + (currentId % 150),
                    iconBadge = "drink"
                )
            )
            currentId++
        }

        return list
    }
}
