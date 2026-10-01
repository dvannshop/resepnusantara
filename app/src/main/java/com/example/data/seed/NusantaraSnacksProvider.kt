package com.example.data.seed

import com.example.data.model.RecipeEntity

object NusantaraSnacksProvider {

    data class SnackSpec(
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
        SnackSpec(
            baseTitle = "Tahu Kukus Isi Sayuran Dada Ayam Cincang",
            mainIngredients = "Tahu Putih Sutra, Daging Dada Ayam Cincang, Wortel Parut, Jamur Kuping, Daun Bawang",
            ingredientsRaw = """6 buah tahu putih sutra kotak ukuran 5x5 cm, belah dua segitiga, keruk sedikit tengahnya
Bahan Isian Sehat:
200 gr daging dada ayam fillet tanpa lemak, cincang halus
1 buah wortel ukuran kecil, serut halus
2 lembar jamur kuping hitam basah, cincang halus
2 batang daun bawang, iris tipis
1 butir putih telur ayam
1 sdm tepung tapioka
Bumbu Halus:
3 siung bawang putih haluskan
1/2 sdt merica bubuk
1 sdt garam laut
1/2 sdt minyak wijen harum""".trimIndent(),
            instructionsRaw = """1. Campurkan daging dada ayam cincang, wortel serut, jamur kuping, daun bawang, putih telur, dan tepung tapioka dalam mangkuk.
2. Tambahkan bumbu halus dan minyak wijen, aduk menggunakan sendok hingga adonan isian tercampur rata kalis.
3. Keruk sedikit bagian tengah tahu segitiga, masukkan 1 sendok makan adonan ayam ke dalam rongga tahu sambil diratakan permukaannya.
4. Panaskan kukusan dengan api sedang hingga beruap banyak.
5. Tata tahu isi di atas wadah tahan panas beralas daun pisang.
6. Kukus selama 20-25 menit hingga adonan ayam matang padat kenyal dan mengeluarkan sari kaldu gurih alami.
7. Angkat dan sajikan hangat bersama cocolan sambal kecap rawit atau saus cabai alami.""".trimIndent(),
            chefTips = "Mengukus tahu isi daripada menggorengnya memangkas kalori minyak hingga 70% sambil menjaga nutrisi protein ayam dan serat sayur tetap utuh.",
            cookingTime = 25, prepTime = 15,
            calories = 135, protein = 14.0, carbs = 6.0, fat = 4.0, fiber = 2.5,
            dietTags = "Tinggi Protein, Rendah Kalori, Rendah Lemak, Halal"
        ),
        SnackSpec(
            baseTitle = "Pisang Rai Kukus Tabur Kelapa Parut Khas Bali",
            mainIngredients = "Pisang Kepok Kuning Matang, Tepung Beras, Daun Pandan Suji, Kelapa Parut Gurih",
            ingredientsRaw = """5 buah pisang kepok kuning matang tua, kupas kulitnya
Bahan Baluran Hijau:
100 gr tepung beras
2 sdm tepung tapioka
100 ml air hangat endapan jus pandan suji
1/4 sdt garam halus
Bahan Taburan Kelapa Gurih:
150 gr kelapa parut setengah tua
1/2 sdt garam halus
1 lembar daun pandan simpulkan""".trimIndent(),
            instructionsRaw = """1. Kukus kelapa parut bersama garam dan daun pandan selama 15 menit agar gurih dan tidak mudah basi. Sisihkan di piring datar.
2. Campurkan tepung beras, tapioka, garam, dan air pandan suji hingga menjadi adonan kental yang bisa membalut pisang.
3. Celupkan pisang kepok utuh ke dalam adonan tepung hingga seluruh permukaannya terbalut adonan hijau tebal merata.
4. Masukkan pisang berbalut adonan ke dalam panci berisi air mendidih.
5. Rebus dengan api sedang selama 10 menit hingga pisang mengapung dan lapisan tepung luar berubah warna hijau transparan matang kenyal.
6. Angkat pisang rai menggunakan sendok berlubang, tiriskan sebentar, lalu langsung gulingkan di atas kelapa parut gurih hingga terselimuti rata.
7. Potong-potong melintang setebal 2 cm dan sajikan selagi hangat lembut manis alami.""".trimIndent(),
            chefTips = "Pilihlah pisang kepok kuning yang matang manis alami agar tidak memerlukan tambahan gula pasir berlebih.",
            cookingTime = 20, prepTime = 15,
            calories = 145, protein = 2.5, carbs = 28.0, fat = 3.5, fiber = 3.0,
            dietTags = "Rendah Lemak, Bebas Gluten, Vegan, Halal, Kaya Serat"
        ),
        SnackSpec(
            baseTitle = "Pepes Tahu Jamur Tiram Kemangi Daun Pisang",
            mainIngredients = "Tahu Putih Halus, Jamur Tiram Suwir, Daun Kemangi Segar, Cabai Merah, Telur Ayam",
            ingredientsRaw = """400 gr tahu putih, hancurkan lumat dengan garpu
150 gr jamur tiram segar, cuci peras airnya lalu suwir-suwir
2 ikat daun kemangi segar, petik daunnya
1 butir telur ayam, kocok lepas
2 batang serai, iris serong tipis
5 lembar daun salam
10 buah cabai rawit merah utuh
Daun pisang dan lidi secukupnya untuk membungkus
Bumbu Halus:
6 butir bawang merah
3 siung bawang putih
4 butir kemiri sangrai
3 cm kunyit bakar
1 sdt garam laut dan 1/2 sdt gula aren""".trimIndent(),
            instructionsRaw = """1. Campurkan tahu putih yang sudah dilumatkan bersama jamur tiram suwir, daun kemangi, telur kocok, dan bumbu halus dalam mangkuk besar. Aduk rata.
2. Siapkan selembar daun pisang, letakkan 1 lembar daun salam dan irisan serai di dasarnya.
3. Taruh 3 sendok makan adonan tahu jamur di atasnya, beri 2 buah cabai rawit utuh.
4. Bungkus bentuk lontong atau tum rapat, semat ujungnya dengan lidi tusuk gigi.
5. Panaskan kukusan, kukus pepes tahu jamur selama 25 menit hingga matang padat harum.
6. Panggang sebentar bungkusan pepes di atas teflon tanpa minyak selama 5 menit per sisi agar aroma bakaran daun pisang meresap ke dalam tahu.
7. Buka bungkusan dan nikmati harum rempah kemangi yang gurih segar bergizi.""".trimIndent(),
            chefTips = "Memanggang sebentar bungkusan pepes kukus di atas wajan kering mengeringkan sisa air tahu dan mengunci aroma daun pisang bakar yang khas sedap.",
            cookingTime = 30, prepTime = 15,
            calories = 125, protein = 9.0, carbs = 7.0, fat = 4.5, fiber = 2.8,
            dietTags = "Tinggi Protein, Rendah Kalori, Vegetarian, Bebas Gluten, Halal"
        ),
        SnackSpec(
            baseTitle = "Gado-Gado Roll Sehat Saus Kacang Mede",
            mainIngredients = "Selada Hijau Segar, Tauge Rebus, Mentimun, Tahu Tempe Kukus, Saus Kacang Mede",
            ingredientsRaw = """8 lembar daun selada segar renyah
100 gr tauge panjang, rebus sebentar 30 detik
1 buah mentimun jepang, potong memanjang tipis korek api
1 buah wortel manis, potong korek api rebus sebentar
100 gr tempe kedelai, potong dadu panjang kukus
100 gr tahu putih, potong dadu panjang kukus
Bahan Saus Kacang Mede Sehat:
100 gr kacang mede sangrai matang tanpa minyak, haluskan
2 siung bawang putih rebus
3 buah cabai merah rebus
1 sdm gula merah aren murni
1 sdm air perasan jeruk limau
150 ml air hangat
1/2 sdt garam laut""".trimIndent(),
            instructionsRaw = """1. Saus: Haluskan kacang mede sangrai bersama bawang putih rebus, cabai rebus, gula aren, dan garam. Tambahkan air hangat sedikit demi sedikit hingga menjadi saus kacang yang kental creamy licin. Beri perasan jeruk limau segar, aduk rata.
2. Siapkan selembar selada segar di atas talenan bersih.
3. Tata potongan mentimun, wortel, tauge, tempe kukus, dan tahu kukus di atas selada.
4. Gulung rapat menyerupai salad roll atau spring roll segar.
5. Potong gulungan menjadi dua bagian serong yang rapi.
6. Tata di piring saji bersama mangkok kecil saus kacang mede gurih segar.""".trimIndent(),
            chefTips = "Menggunakan kacang mede sangrai menghasilkan tekstur saus kacang yang gurih alami tinggi lemak baik omega-9 tanpa perlu digoreng minyak banyak.",
            cookingTime = 15, prepTime = 20,
            calories = 155, protein = 7.5, carbs = 14.0, fat = 7.0, fiber = 3.5,
            dietTags = "Rendah Kalori, Vegetarian, Kaya Vitamin, Halal"
        ),
        SnackSpec(
            baseTitle = "Ubi Cilembu Panggang Madu Alami",
            mainIngredients = "Ubi Jalar Cilembu Asli, Madu Alami, Bubuk Kayu Manis",
            ingredientsRaw = """4 buah ubi madu Cilembu asli berukuran sedang (sekitar 600 gr)
1 sdm madu murni alami
1/4 sdt bubuk kayu manis (opsional untuk aroma harum)""".trimIndent(),
            instructionsRaw = """1. Cuci bersih kulit ubi madu Cilembu dengan air mengalir tanpa mengupas kulitnya (kulit ubi menjaga cairan karamel madu tidak hilang saat dipanggang), keringkan dengan lap bersih.
2. Panaskan oven pada suhu 200°C atau siapkan air fryer suhu 190°C.
3. Tusuk-tusuk sedikit permukaan ubi dengan garpu di 2-3 titik agar uap panas bisa bersirkulasi.
4. Letakkan ubi di atas loyang yang dialasi aluminium foil atau baking paper (untuk menampung lelehan karamel madu).
5. Panggang selama 50-60 menit hingga tekstur ubi terasa empuk lumer saat ditekan dan cairan getah gula madu alaminya meleleh karamel wangi kecokelatan.
6. Belah ubi selagi panas mengepul, beri sedikit olesan madu murni dan taburan kayu manis. Sajikan hangat lumer manis legit.""".trimIndent(),
            chefTips = "Ubi Cilembu yang didiamkan beberapa hari setelah dipanen memiliki kadar getah gula alami yang lebih pekat sehingga saat dipanggang akan melelehkan karamel madu manis legit.",
            cookingTime = 55, prepTime = 10,
            calories = 140, protein = 1.8, carbs = 32.0, fat = 0.4, fiber = 4.0,
            dietTags = "Rendah Lemak, Bebas Gluten, Vegan, Halal, Kaya Serat Alami"
        )
    )

    fun getRemainingSnacks(startId: Int, targetCount: Int, provinces: List<String>): List<RecipeEntity> {
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
                    category = "Camilan Sehat",
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
                    reviewCount = 85 + (currentId % 140),
                    iconBadge = "snack"
                )
            )
            currentId++
        }

        return list
    }
}
