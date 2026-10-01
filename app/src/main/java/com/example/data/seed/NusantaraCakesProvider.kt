package com.example.data.seed

import com.example.data.model.RecipeEntity

object NusantaraCakesProvider {

    data class CakeSpec(
        val baseTitle: String,
        val mainIngredients: String,
        val ingredientsRaw: String,
        val instructionsRaw: String,
        val chefTips: String,
        val cookingTime: Int,
        val prepTime: Int,
        val difficulty: String,
        val calories: Int,
        val protein: Double,
        val carbs: Double,
        val fat: Double,
        val fiber: Double
    )

    private val specs = listOf(
        CakeSpec(
            baseTitle = "Kue Dadar Gulung Unti Kelapa Pandan",
            mainIngredients = "Tepung Terigu, Air Daun Suji Pandan, Kelapa Parut, Gula Merah Aren",
            ingredientsRaw = """Bahan Kulit Dadar:
150 gr tepung terigu protein sedang
1 butir telur ayam kocok lepas
300 ml santan encer hangat
50 ml air perasan daun pandan dan suji pekat
1/4 sdt garam halus
1 sdm minyak sayur untuk adonan
Bahan Isian Unti Kelapa:
200 gr kelapa parut setengah tua (kupas kulit ari)
120 gr gula merah aren sisir halus
50 ml air matang
1 lembar daun pandan simpulkan
1/4 sdt garam halus""".trimIndent(),
            instructionsRaw = """1. Unti Kelapa: Masak gula merah aren bersama air, daun pandan, dan garam di wajan hingga gula larut. Masukkan kelapa parut, aduk terus dengan api kecil hingga air terserap habis dan unti kelapa mengering legit (jangan sampai gosong). Dinginkan.
2. Kulit Dadar: Campur tepung terigu dan garam dalam wadah. Tuang campuran santan, telur, dan air daun pandan suji sedikit demi sedikit sambil diaduk dengan whisk hingga licin tanpa gumpalan. Saring adonan.
3. Panaskan wajan teflon anti lengket diameter 18 cm, olesi sedikit minyak dengan tisu.
4. Tuang 1 sendok sayur adonan, putar wajan hingga membentuk dadar tipis merata. Masak dengan api kecil hingga pinggirannya mengelupas dan matang berpori. Angkat dadar.
5. Ambil 1 lembar kulit dadar, beri 1 sdm isian unti kelapa di bagian tengah, lipat sisi kiri dan kanan, lalu gulung rapat rapi. Lakukan hingga adonan habis.
6. Sajikan dadar gulung pandan harum manis gurih.""".trimIndent(),
            chefTips = "Pastikan wajan teflon sudah cukup panas saat menuang adonan agar permukaan dadar gulung menghasilkan pori-pori bopeng cantik khas dadar gulung tradisional.",
            cookingTime = 30, prepTime = 20, difficulty = "Mudah",
            calories = 190, protein = 3.8, carbs = 32.0, fat = 5.5, fiber = 2.0
        ),
        CakeSpec(
            baseTitle = "Kue Klepon Pandan Lumer Gula Jawa",
            mainIngredients = "Tepung Ketan Putih, Tepung Beras, Daun Pandan Suji, Gula Merah Aren, Kelapa Parut",
            ingredientsRaw = """Bahan Kulit Klepon:
250 gr tepung ketan putih kualitas bagus
50 gr tepung beras
200 ml air hangat yang dicampur 3 sdm endapan jus pandan suji
1/2 sdt air kapur sirih (opsional untuk kekenyalan)
1/4 sdt garam halus
Bahan Isian:
120 gr gula merah aren murni, sisir halus atau potong dadu kecil 5 mm
Bahan Taburan Kelapa Gurih:
150 gr kelapa parut setengah tua, kupas kulit arinya
1/2 sdt garam halus
1 lembar daun pandan (kukus kelapa selama 15 menit agar tahan basi)""".trimIndent(),
            instructionsRaw = """1. Campur tepung ketan, tepung beras, dan garam. Tuangkan air pandan hangat sedikit demi sedikit sambil diuleni lembut hingga adonan kalis lembut dan bisa dipulung tanpa lengket di tangan.
2. Ambil sedikit adonan klepon (sekitar 15 gr), pipihkan di telapak tangan, beri potongan gula merah aren di tengahnya.
3. Rapatkan kembali adonan dan bulatkan secara perlahan hingga mulus rapat (pastikan tidak ada retakan agar gula tidak bocor saat direbus).
4. Masukkan bulatan klepon ke dalam panci berisi air yang sedang mendidih bergolak di atas api sedang.
5. Rebus hingga klepon mengapung ke permukaan, lalu biarkan mengapung selama 3 menit lagi agar gula merah di dalamnya benar-benar lumer cair.
6. Angkat klepon dengan saringan, tiriskan sebentar, lalu langsung gulingkan di atas parutan kelapa kukus yang gurih hingga terbalut merata.
7. Sajikan klepon hangat sensasi letusan gula aren manis legit di mulut.""".trimIndent(),
            chefTips = "Pastikan adonan ketan dibulatkan benar-benar rapat dan tidak ada celah tipis agar gula merah tidak bocor keluar ke dalam air rebusan.",
            cookingTime = 25, prepTime = 25, difficulty = "Mudah",
            calories = 175, protein = 2.8, carbs = 35.0, fat = 3.5, fiber = 1.5
        ),
        CakeSpec(
            baseTitle = "Nagasari Pisang Raja Bungkus Daun",
            mainIngredients = "Tepung Beras, Santan Kelapa, Pisang Raja Matang, Gula Pasir, Daun Pisang",
            ingredientsRaw = """200 gr tepung beras
50 gr tepung tapioka/sagu
150 gr gula pasir
800 ml santan sedang dari 1 butir kelapa
2 lembar daun pandan simpulkan
1/2 sdt garam halus
4 buah pisang raja matang tua, kukus sebentar lalu potong serong 1 cm
Daun pisang muda yang sudah dilayukan di atas api secukupnya""".trimIndent(),
            instructionsRaw = """1. Larutkan tepung beras dan tapioka dengan 300 ml santan dingin, aduk rata tanpa gumpalan.
2. Masak 500 ml santan sisanya bersama gula pasir, garam, dan daun pandan hingga mendidih di atas api sedang.
3. Kecilkan api, tuangkan larutan tepung beras sambil terus diaduk cepat searah menggunakan whisk/sendok kayu hingga adonan mengental licin dan meletup-letup matang. Matikan api.
4. Siapkan selembar daun pisang, beri 2 sdm adonan putih nagasari selagi hangat, letakkan sepotong pisang raja di tengahnya, tutup kembali dengan 1 sdm adonan.
5. Lipat kedua sisi daun pisang ke tengah, lalu lipat kedua ujungnya ke bawah membentuk bungkusan nagasari rapi.
6. Tata di kukusan panas, kukus selama 25-30 menit hingga matang sempurna dan daun pisang berubah warna harum.
7. Dinginkan hingga padat lembut sebelum disajikan.""".trimIndent(),
            chefTips = "Gunakan pisang raja yang matang pohon agar rasa manis alaminya legit berpadu kontras dengan adonan nagasari gurih lembut.",
            cookingTime = 30, prepTime = 20, difficulty = "Mudah",
            calories = 195, protein = 3.0, carbs = 38.0, fat = 4.2, fiber = 1.8
        ),
        CakeSpec(
            baseTitle = "Kue Cucur Gula Merah Berserat Renda",
            mainIngredients = "Tepung Beras, Tepung Terigu, Gula Merah Aren, Daun Pandan, Garam",
            ingredientsRaw = """150 gr tepung beras kualitas baik
50 gr tepung terigu protein sedang
150 gr gula merah aren murni cokelat tua
250 ml air matang
1 lembar daun pandan
1/4 sdt garam halus
Minyak goreng secukupnya untuk menggoreng rendam""".trimIndent(),
            instructionsRaw = """1. Masak gula merah aren bersama air, daun pandan, dan garam hingga gula larut mendidih. Saring lalu dinginkan hingga suam-suam kuku.
2. Campur tepung beras dan terigu dalam mangkuk. Tuangkan larutan gula merah hangat bertahap sambil diaduk dan ditepuk-tepuk adonan dengan telapak tangan selama 15 menit agar udara terperangkap.
3. Diamkan adonan selama 1-2 jam di suhu ruang.
4. Panaskan wajan cekung kecil berisi sekitar 100 ml minyak goreng di atas api sedang cenderung kecil.
5. Tuang 1 sendok sayur adonan ke tengah wajan minyak panas, biarkan bagian pinggir mengembang membentuk renda keriting berserat ke tengah.
6. Siram-siramkan minyak panas ke bagian tengah cucur yang masih basah hingga matang dan membentuk topi cembung berserat. Tusuk tengahnya dengan lidi, jika tidak basah segera balik sebentar lalu angkat tiriskan.
7. Sajikan kue cucur hangat berserat empuk legit.""".trimIndent(),
            chefTips = "Menepuk-nepuk adonan saat pengadukan dan suhu minyak yang stabil adalah kunci cucur membentuk renda berserat bambu yang sempurna.",
            cookingTime = 30, prepTime = 20, difficulty = "Sedang",
            calories = 180, protein = 2.5, carbs = 36.0, fat = 3.8, fiber = 1.2
        ),
        CakeSpec(
            baseTitle = "Kue Putu Ayu Santan Kelapa Parut Gurih",
            mainIngredients = "Tepung Terigu, Telur Ayam, Santan Pandan Suji, Kelapa Parut Muda, Garam",
            ingredientsRaw = """200 gr tepung terigu protein sedang
150 gr gula pasir
2 butir telur ayam suhu ruang
150 ml santan kelapa sedang hangat
1 sdt emulsifier / SP
1/2 sdt pasta pandan atau 2 sdm endapan jus pandan suji
Bahan Topping Kelapa:
150 gr kelapa parut muda setengah tua
1 sdm tepung maizena (agar kelapa merekat)
1/2 sdt garam halus
Minyak sayur secukupnya untuk olesan cetakan""".trimIndent(),
            instructionsRaw = """1. Campur kelapa parut dengan garam dan maizena, kukus selama 10 menit agar tidak mudah basi.
2. Olesi cetakan putu ayu dengan minyak tipis. Masukkan 1 sdt kelapa parut kukus ke dasar cetakan, tekan-tekan padat menggunakan ujung jari.
3. Kocok telur, gula pasir, dan SP dengan mixer kecepatan tinggi hingga mengembang putih, kental, dan berjejak (sekitar 8-10 menit).
4. Masukkan tepung terigu yang sudah diayak bergantian dengan santan pandan ke dalam kocokan telur, aduk balik dengan spatula atau mixer kecepatan rendah hingga rata.
5. Tuang adonan hijau pandan ke atas lapisan kelapa di cetakan hingga 3/4 penuh.
6. Kukus dalam kukusan panas yang tutupnya dibungkus kain bersih selama 15-20 menit hingga matang mengembang empuk.
7. Keluarkan dari cetakan selagi hangat dan sajikan.""".trimIndent(),
            chefTips = "Menambahkan sedikit tepung maizena ke kelapa parut dan menekannya padat mencegah kelapa terlepas rontok saat kue putu ayu dikeluarkan dari cetakan.",
            cookingTime = 20, prepTime = 20, difficulty = "Mudah",
            calories = 170, protein = 3.5, carbs = 28.0, fat = 5.0, fiber = 1.4
        )
    )

    fun getRemainingCakes(startId: Int, targetCount: Int, provinces: List<String>): List<RecipeEntity> {
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
                    category = "Cake & Kue",
                    province = province,
                    cookingTimeMinutes = spec.cookingTime,
                    prepTimeMinutes = spec.prepTime,
                    difficulty = spec.difficulty,
                    servings = 6,
                    calories = spec.calories,
                    protein = spec.protein,
                    carbs = spec.carbs,
                    fat = spec.fat,
                    fiber = spec.fiber,
                    dietTags = "Halal, Tradisional, Camilan Manis",
                    mainIngredients = spec.mainIngredients,
                    ingredients = spec.ingredientsRaw,
                    instructions = spec.instructionsRaw,
                    chefTips = spec.chefTips,
                    rating = 4.8,
                    reviewCount = 90 + (currentId % 160),
                    iconBadge = "cake"
                )
            )
            currentId++
        }

        return list
    }
}
