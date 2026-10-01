package com.example.data.seed

import com.example.data.model.RecipeEntity

object NusantaraMainDishesProvider {

    data class CulinaryDishSpec(
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
        val fiber: Double,
        val dietTags: String,
        val iconBadge: String
    )

    private val specs = listOf(
        CulinaryDishSpec(
            baseTitle = "Gulai Ikan Patin Kuah Kuning",
            mainIngredients = "Ikan Patin Segar, Santan Kelapa, Belimbing Wuluh, Asam Kandis, Serai, Daun Kunyit",
            ingredientsRaw = """600 gr ikan patin segar, potong melintang 4 cm
700 ml santan kelapa sedang dari 1 butir kelapa
5 buah belimbing wuluh, belah dua memanjang
2 buah asam kandis kering
2 batang serai, memarkan
4 lembar daun jeruk purut, buang tulang daun
1 lembar daun kunyit, ikat simpul
1 ikat daun ruku-ruku segar
1 sdm air perasan jeruk nipis
Bumbu Halus:
8 siung bawang merah
4 siung bawang putih
8 buah cabai merah keriting
3 cm kunyit bakar
2 cm jahe
2 cm lengkuas
1 sdt ketumbar bubuk
1.5 sdt garam laut
1/2 sdt gula pasir""".trimIndent(),
            instructionsRaw = """1. Cuci bersih potongan ikan patin, lumuri dengan air perasan jeruk nipis dan garam selama 15 menit untuk menghilangkan aroma tanah, lalu bilas bersih.
2. Siapkan wajan, masukkan santan, bumbu halus, serai, daun kunyit, daun jeruk, dan asam kandis. Masak di atas api sedang sambil ditimba perlahan agar santan tidak pecah hingga mendidih dan harum.
3. Masukkan potongan ikan patin dan belimbing wuluh. Kecilkan api dan masak perlahan selama 20 menit hingga ikan matang lembut dan bumbu meresap gurih.
4. Masukkan daun ruku-ruku sesaat sebelum api dimatikan. Aduk perlahan hingga layu harum.
5. Angkat dan sajikan gulai ikan patin selagi hangat bersama nasi putih pulen.""".trimIndent(),
            chefTips = "Jangan sering membolak-balik ikan patin saat kuah mendidih agar daging lembutnya tidak hancur. Cukup siramkan kuah santan hangat ke atas permukaan ikan.",
            cookingTime = 35, prepTime = 20, difficulty = "Sedang",
            calories = 340, protein = 28.0, carbs = 10.0, fat = 22.0, fiber = 2.5,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "seafood"
        ),
        CulinaryDishSpec(
            baseTitle = "Ikan Bakar Bumbu Jimbaran",
            mainIngredients = "Ikan Kakap Merah, Terasi Bakar, Kecap Manis, Cabai Merah, Bawang Putih, Asam Jawa",
            ingredientsRaw = """1 ekor ikan kakap merah segar (sekitar 700 gr), belah punggung bentuk kupu-kupu
2 sdm air perasan jeruk nipis
1 sdt garam halus
Bumbu Oles Jimbaran:
5 siung bawang putih cincang halus
8 siung bawang merah cincang halus
6 buah cabai merah keriting haluskan
1 sdm terasi bakar harum
4 sdm kecap manis kental
1 sdm saus tiram
1 sdm air asam jawa pekat
1 sdt ketumbar bubuk sangrai
3 sdm minyak kelapa murni untuk menumis
1 sdt garam dan 1/2 sdt merica bubuk""".trimIndent(),
            instructionsRaw = """1. Lumuri ikan kakap dengan perasan jeruk nipis dan garam, diamkan selama 15 menit agar kesat dan tidak amis.
2. Tumis bawang merah, bawang putih, cabai, dan terasi bakar dengan minyak kelapa sampai harum matang berminyak.
3. Masukkan kecap manis, saus tiram, air asam jawa, ketumbar, garam, dan merica. Masak hingga bumbu oles mengental terkaramelisasi.
4. Panggang ikan kakap di atas bara arang atau wajan grill panas selama 5 menit per sisi hingga setengah matang.
5. Olesi seluruh permukaan ikan secara tebal merata dengan bumbu Jimbaran sambil terus dibolak-balik hingga bumbu meresap beraroma asap harum dan matang sempurna.
6. Angkat dan sajikan bersama sambal matah dan plecing kangkung.""".trimIndent(),
            chefTips = "Bakar bumbu halus terlebih dahulu sampai matang tanak sebelum dioleskan ke ikan agar aroma bakarannya tidak berbau bumbu mentah.",
            cookingTime = 30, prepTime = 20, difficulty = "Sedang",
            calories = 310, protein = 35.0, carbs = 12.0, fat = 14.0, fiber = 1.8,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "seafood"
        ),
        CulinaryDishSpec(
            baseTitle = "Empal Gentong Daging & Babat Sapi",
            mainIngredients = "Daging Sapi Sengkel, Babat Sapi Rebus, Santan Gurih, Kucai Segar, Serai, Cengkeh",
            ingredientsRaw = """300 gr daging sapi bagian sengkel, potong dadu 2 cm
200 gr babat sapi rebus empuk, potong 2 cm
800 ml air kaldu sapi rebusan
400 ml santan kental dari 1 butir kelapa
2 batang serai, memarkan
3 lembar daun salam
3 butir cengkeh
3 cm kayu manis
Bumbu Halus:
8 siung bawang merah
5 siung bawang putih
4 butir kemiri sangrai
3 cm kunyit bakar
2 cm jahe
1 sdt ketumbar sangrai
1/2 sdt merica butir
1.5 sdt garam dan 1 sdt gula pasir
Pelengkap: 5 batang kucai iris 1 cm, bubuk cabai merah kering, emping melinjo""".trimIndent(),
            instructionsRaw = """1. Rebus daging sapi dan babat dengan 1.2 liter air bersama serai, salam, cengkeh, dan kayu manis hingga daging benar-benar empuk dan menghasilkan kaldu gurih.
2. Tumis bumbu halus dengan sedikit minyak sampai harum matang dan tercium wangi rempah tanak.
3. Tuang tumisan bumbu ke dalam panci rebusan daging. Masak dengan api sedang hingga bumbu menyatu dengan kaldu.
4. Tuang santan kental perlahan sambil terus diaduk perlahan agar santan tidak pecah. Masak dengan api kecil selama 25 menit hingga kuah kuning gurih mengental sedap.
5. Siapkan mangkok saji, tuang kuah empal gentong beserta daging dan babat, taburi irisan kucai segar melimpah dan bubuk cabai merah kering sesuai selera.""".trimIndent(),
            chefTips = "Daun kucai segar dan bubuk cabai kering adalah ciri khas otentik empal gentong Cirebon yang memberi rasa pedas segar dan wangi khas.",
            cookingTime = 60, prepTime = 20, difficulty = "Sedang",
            calories = 420, protein = 32.0, carbs = 14.0, fat = 26.0, fiber = 2.0,
            dietTags = "Tinggi Protein, Halal", iconBadge = "meat"
        ),
        CulinaryDishSpec(
            baseTitle = "Bebek Sinjay Bumbu Serundeng Lengkuas",
            mainIngredients = "Bebek Kampung Muda, Lengkuas Parut Kasar, Kunyit, Ketumbar, Sambal Pencit Mangga Muda",
            ingredientsRaw = """1 ekor bebek kampung muda (sekitar 1 kg), potong 4 bagian
150 gr lengkuas muda, parut kasar memanjang untuk serundeng
500 ml air kelapa murni
2 batang serai memarkan
4 lembar daun jeruk purut
3 lembar daun salam
Bumbu Halus Bebek:
12 siung bawang merah
6 siung bawang putih
5 cm kunyit bakar
3 cm jahe
1 sdm ketumbar sangrai
4 butir kemiri sangrai
1.5 sdt garam dan 1 sdt kaldu jamur
Bahan Sambal Pencit:
1 buah mangga muda (mangga golek/indramayu), cacah memanjang
15 buah cabai rawit merah
1 sdt terasi bakar matang
1 sdt gula merah dan 1/2 sdt garam""".trimIndent(),
            instructionsRaw = """1. Cuci bersih bebek, lumuri cuka atau jeruk nipis selama 20 menit, lalu bilas bersih.
2. Campurkan bebek bersama bumbu halus, parutan lengkuas, serai, daun jeruk, salam, dan air kelapa dalam panci presto atau wajan tebal tertutup.
3. Ungkep bebek dengan api kecil selama 45-60 menit (atau 25 menit di panci presto) sampai daging bebek empuk lumer dan bumbu meresap pekat. Tiriskan bebek dan pisahkan parutan bumbu lengkuas.
4. Goreng bebek dalam minyak panas melimpah hingga kulit luar renyah kecokelatan keemasan. Angkat tiriskan.
5. Goreng sisa parutan bumbu lengkuas di minyak panas hingga kering renyah keemasan (serundeng bebek).
6. Ulek cabai rawit, terasi, gula, dan garam, lalu campurkan dengan serutan mangga muda (sambal pencit).
7. Sajikan bebek goreng bertabur serundeng lengkuas renyah bersama sambal pencit asam pedas menggigit.""".trimIndent(),
            chefTips = "Mengungkep bebek menggunakan air kelapa murni melunakkan serat daging bebek sekaligus memberikan rasa manis gurih alami tanpa amis.",
            cookingTime = 60, prepTime = 25, difficulty = "Sedang",
            calories = 460, protein = 36.0, carbs = 16.0, fat = 28.0, fiber = 3.0,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "poultry"
        ),
        CulinaryDishSpec(
            baseTitle = "Sate Maranggi Sapi Empuk Bumbu Ketumbar",
            mainIngredients = "Daging Sapi Has Dalam, Ketumbar Sangrai, Air Asam Jawa, Gula Merah Aren, Kecap Manis",
            ingredientsRaw = """500 gr daging sapi lulur dalam (tenderloin/sirloin), potong dadu 2 cm
150 gr lemak sapi (sandung lamur), potong dadu 1.5 cm
Tusuk sate secukupnya, rendam air agar tidak gosong
Bumbu Marinasi Maranggi:
8 siung bawang merah haluskan
5 siung bawang putih haluskan
2 sdm ketumbar butir, sangrai lalu haluskan
2 cm jahe haluskan
2 cm lengkuas haluskan
80 gr gula merah aren sisir halus
3 sdm air asam jawa pekat
4 sdm kecap manis premium
1.5 sdt garam laut
Bahan Sambal Tomat Kecap:
2 buah tomat merah segar potong dadu
10 buah cabai rawit hijau dan merah iris
4 butir bawang merah iris kasar
3 sdm kecap manis dan 1 buah jeruk limau""".trimIndent(),
            instructionsRaw = """1. Campurkan potongan daging sapi dan lemak dengan seluruh bumbu marinasi maranggi sambil dipijat-pijat perlahan agar bumbu meresap ke serat daging.
2. Diamkan daging dalam kulkas minimal 1 jam (atau semalaman untuk rasa maksimal).
3. Tusuk daging sapi berselang-seling dengan sepotong lemak di setiap tusukan (biasanya 3 daging + 1 lemak).
4. Panaskan panggangan arang atau grill pan. Bakar sate maranggi sambil diolesi sisa bumbu marinasi kecap ketumbar hingga matang harum kecokelatan berkaramel.
5. Campur potongan tomat, cabai rawit, bawang merah, kecap manis, dan perasan jeruk limau untuk sambal pendamping.
6. Sajikan sate maranggi empuk hangat bersama ketan bakar atau nasi putih hangat.""".trimIndent(),
            chefTips = "Kombinasi ketumbar sangrai dan air asam jawa melunakkan daging sapi secara alami dan menghasilkan aroma karamel wangi saat dibakar di atas arang.",
            cookingTime = 30, prepTime = 30, difficulty = "Sedang",
            calories = 380, protein = 34.0, carbs = 18.0, fat = 20.0, fiber = 1.5,
            dietTags = "Tinggi Protein, Halal", iconBadge = "meat"
        ),
        CulinaryDishSpec(
            baseTitle = "Tengkleng Kambing Kuah Rempah Bening",
            mainIngredients = "Tulang & Daging Kambing Muda, Serai, Lengkuas, Daun Jeruk, Cabai Rawit Utuh",
            ingredientsRaw = """800 gr tulang iga dan daging tetelan kambing muda
1.5 liter air bersih
3 batang serai, memarkan
4 cm lengkuas, memarkan
3 cm jahe, memarkan
5 lembar daun jeruk purut buang tulang daun
3 lembar daun salam
15 buah cabai rawit merah utuh
Bumbu Halus:
10 siung bawang merah
6 siung bawang putih
4 butir kemiri sangrai
3 cm kunyit bakar
1 sdm ketumbar bubuk
1/2 sdt pala bubuk
1/2 sdt merica butir
2 sdt garam laut dan 1 sdt gula pasir
Pelengkap: Bawang goreng renyah, perasan jeruk nipis""".trimIndent(),
            instructionsRaw = """1. Rebus tulang kambing dalam air mendidih selama 10 menit untuk mengangkat buih kotoran darah, lalu tiriskan dan buang air pertama.
2. Didihkan 1.5 liter air bersih baru, masukkan tulang kambing, serai, lengkuas, jahe, daun salam, dan daun jeruk. Masak dengan api sedang hingga daging pada tulang empuk (sekitar 45 menit).
3. Tumis bumbu halus dengan 2 sdm minyak sampai harum matang dan berwarna kuning keemasan tanak.
4. Masukkan tumisan bumbu ke dalam panci rebusan tengkleng kambing. Aduk rata.
5. Masukkan cabai rawit merah utuh, bumbui dengan garam dan gula. Masak dengan api kecil selama 25 menit agar sari kaldu sumsum tulang kambing keluar menyatu dengan kuah rempah bening gurih.
6. Angkat dan sajikan panas berkuah pedas segar bersama taburan bawang goreng dan perasan jeruk nipis.""".trimIndent(),
            chefTips = "Tengkleng Solo asli berkuah encer rempah tanpa santan kental, sehingga rasa kaldu sumsum tulang kambing tetap gurih segar tanpa rasa enek.",
            cookingTime = 60, prepTime = 20, difficulty = "Sedang",
            calories = 390, protein = 38.0, carbs = 8.0, fat = 22.0, fiber = 2.0,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "meat"
        ),
        CulinaryDishSpec(
            baseTitle = "Garang Asem Ayam Kampung Belimbing Wuluh",
            mainIngredients = "Ayam Kampung Muda, Belimbing Wuluh, Santan Encer, Cabai Rawit Merah, Tomat Hijau, Daun Pisang",
            ingredientsRaw = """1 ekor ayam kampung muda (sekitar 800 gr), potong 16 bagian kecil
500 ml santan encer segar
10 buah belimbing wuluh, potong bulat 1 cm
4 buah tomat hijau, belah empat
15 buah cabai rawit merah dan hijau utuh
4 lembar daun salam
3 batang serai iris serong
4 cm lengkuas iris tipis
Daun pisang tebal dan tusuk gigi untuk membungkus
Bumbu Iris Halus:
8 siung bawang merah iris tipis
5 siung bawang putih iris tipis
3 cm jahe iris tipis
1.5 sdt garam laut dan 1 sdt gula pasir""".trimIndent(),
            instructionsRaw = """1. Cuci bersih potongan ayam kampung, tiriskan.
2. Campurkan potongan ayam dengan bumbu iris, santan encer, belimbing wuluh, tomat hijau, cabai rawit utuh, daun salam, serai, lengkuas, garam, dan gula dalam mangkuk besar. Aduk rata.
3. Siapkan 2 lapis daun pisang, letakkan 3-4 potong ayam beserta kuah santan berbumbu, belimbing, dan cabai rawit.
4. Bungkus bentuk tum rapat, semat ujungnya dengan tusuk gigi (atau letakkan dalam wadah tahan panas beralas daun pisang).
5. Panaskan kukusan, kukus garang asem selama 45-50 menit hingga ayam kampung empuk lumer dan kuah asam gurihnya meresap harum.
6. Angkat dan sajikan hangat berkuah asam pedas gurih yang segar menggugah selera.""".trimIndent(),
            chefTips = "Daun pisang yang dipanaskan sebentar di atas api akan lebih lentur dan tidak mudah sobek saat membungkus kuah santan garang asem.",
            cookingTime = 50, prepTime = 25, difficulty = "Sedang",
            calories = 330, protein = 32.0, carbs = 11.0, fat = 18.0, fiber = 2.8,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "poultry"
        ),
        CulinaryDishSpec(
            baseTitle = "Ikan Cakalang Suwir Rica-Rica Kemangi",
            mainIngredients = "Ikan Cakalang Asap, Cabai Rawit Merah, Bawang Merah, Daun Kemangi, Jeruk Nipis",
            ingredientsRaw = """400 gr ikan cakalang fufu asap, suwir-suwir kasar dagingnya
2 ikat daun kemangi segar, petik daunnya
4 lembar daun jeruk purut, buang tulang iris halus
1 batang serai, memarkan
1 buah tomat merah matang, cincang kasar
Bumbu Ulek Kasar Rica-Rica:
12 siung bawang merah
4 siung bawang putih
20 buah cabai rawit merah pedas
6 buah cabai merah keriting
2 cm jahe segar
1 sdt garam laut
1/2 sdt gula pasir
4 sdm minyak kelapa murni untuk menumis
1 sdm air perasan jeruk limau""".trimIndent(),
            instructionsRaw = """1. Siapkan suwiran ikan cakalang asap, pastikan bebas dari tulang dan duri.
2. Panaskan minyak kelapa di wajan, tumis bumbu ulek kasar rica-rica bersama serai dan daun jeruk sampai harum matang dan minyaknya berwarna kemerahan.
3. Masukkan potongan tomat cincang, aduk hingga tomat layu hancur dan menyatu dengan bumbu rica.
4. Masukkan suwiran ikan cakalang asap, aduk rata dengan api sedang hingga bumbu meresap ke dalam serat ikan asap (sekitar 7-10 menit).
5. Tambahkan garam dan gula, koreksi rasa gurih pedasnya.
6. Masukkan daun kemangi segar dan kucuran jeruk limau, aduk cepat selama 1 menit hingga kemangi layu harum, lalu matikan api.
7. Sajikan cakalang rica hangat bersama nasi pulen harum.""".trimIndent(),
            chefTips = "Bumbu rica-rica harus diulek kasar (jangan diblender halus berair) agar tekstur sambal minyak khas Manado terasa renyah gurih di lidah.",
            cookingTime = 25, prepTime = 20, difficulty = "Mudah",
            calories = 290, protein = 36.0, carbs = 6.0, fat = 14.0, fiber = 2.0,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "seafood"
        ),
        CulinaryDishSpec(
            baseTitle = "Soto Banjar Kuah Susu Rempah Harum",
            mainIngredients = "Ayam Kampung, Susu Evaporasi, Kayu Manis, Cengkeh, Kapulaga, Perkedel Kentang, Telur Bebek",
            ingredientsRaw = """1/2 ekor ayam kampung (sekitar 500 gr)
1.5 liter air kaldu ayam
100 ml susu cair evaporasi murni (atau 1 butir kuning telur bebek kocok)
3 butir kapulaga jawa
3 butir cengkeh
4 cm kayu manis
1/2 butir biji pala, memarkan
Bumbu Halus:
8 siung bawang merah
4 siung bawang putih
3 butir kemiri sangrai
2 cm jahe
1 sdt lada putih bubuk
1.5 sdt garam dan 1 sdt gula pasir
Pelengkap Soto Banjar:
100 gr soun putih rendam air panas
4 butir telur bebek rebus belah dua
4 buah perkedel kentang goreng
Ketupat potong dadu, daun seledri, bawang merah goreng, sambal rawit, jeruk nipis""".trimIndent(),
            instructionsRaw = """1. Rebus ayam kampung bersama air, kayu manis, cengkeh, kapulaga, dan biji pala hingga ayam empuk dan kaldunya wangi semerbak. Angkat ayam, suwir-suwir dagingnya.
2. Tumis bumbu halus dengan sedikit minyak sampai harum matang sempurna.
3. Masukkan tumisan bumbu ke dalam panci kaldu rebusan ayam. Didihkan.
4. Tuang susu evaporasi perlahan sambil diaduk rata agar kuah soto banjar menjadi gurih lembut dan berwarna putih keruh sedap.
5. Tata potongan ketupat, soun, suwiran ayam, dan perkedel kentang di mangkuk saji.
6. Siram dengan kuah soto Banjar panas yang harum rempah, beri separuh telur bebek rebus, taburan seledri, bawang goreng renyah, dan perasan jeruk nipis.""".trimIndent(),
            chefTips = "Rempah kayu manis, kapulaga, dan susu evaporasi adalah rahasia kuah Soto Banjar asli Kalimantan Selatan yang beraroma harum mewah layaknya hidangan kerajaan.",
            cookingTime = 50, prepTime = 25, difficulty = "Sedang",
            calories = 410, protein = 30.0, carbs = 38.0, fat = 16.0, fiber = 2.2,
            dietTags = "Tinggi Protein, Halal", iconBadge = "poultry"
        ),
        CulinaryDishSpec(
            baseTitle = "Sop Buntut Sapi Kuah Kaldu Rempah Pala",
            mainIngredients = "Buntut Sapi Tebal, Wortel, Kentang, Biji Pala, Cengkeh, Daun Bawang, Emping",
            ingredientsRaw = """750 gr buntut sapi pilihan, potong melintang 3-4 cm
2 liter air bersih untuk kaldu
2 buah wortel manis, potong bulat 1.5 cm
2 buah kentang tes, potong dadu 2 cm
1 batang daun bawang besar, potong 2 cm
2 batang seledri, simpulkan
Bumbu Rempah Sup:
1 butir biji pala, memarkan utuh
5 butir cengkeh
3 cm kayu manis
Bumbu Halus:
8 siung bawang merah
5 siung bawang putih
1 sdt merica butir sangrai
2 sdt garam laut dan 1 sdt kaldu sapi
Pelengkap: Bawang merah goreng renyah, emping melinjo gurih, sambal rawit hijau, jeruk limau""".trimIndent(),
            instructionsRaw = """1. Rebus buntut sapi dalam air mendidih selama 10 menit untuk membersihkan kotoran dan darah, lalu tiriskan dan buang air rebusan pertama.
2. Rebus kembali buntut dengan 2 liter air baru bersama biji pala, cengkeh, kayu manis, dan simpul seledri. Masak dengan api kecil selama 2-2.5 jam (atau 40 menit di panci presto) hingga daging buntut empuk terlepas dari tulang.
3. Tumis bawang putih dan bawang merah halus dengan sedikit margarin/minyak hingga wangi keemasan, masukkan ke dalam panci kuah buntut.
4. Masukkan potongan wortel dan kentang ke dalam panci sup, masak selama 15 menit hingga sayuran matang empuk.
5. Masukkan potongan daun bawang, bumbui dengan garam dan kaldu. Koreksi rasa gurih kaldunya.
6. Sajikan sop buntut panas di mangkok besar bertabur emping melinjo dan bawang goreng.""".trimIndent(),
            chefTips = "Rebus buntut dengan api sangat kecil dan buang minyak lemak yang mengapung di permukaan panci agar kuah sop buntut jernih berkilau dan tidak enek.",
            cookingTime = 90, prepTime = 25, difficulty = "Sedang",
            calories = 480, protein = 42.0, carbs = 18.0, fat = 28.0, fiber = 3.5,
            dietTags = "Tinggi Protein, Halal, Bebas Gluten", iconBadge = "meat"
        )
    )

    fun getRemainingMainDishes(startId: Int, targetCount: Int, provinces: List<String>): List<RecipeEntity> {
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
                    category = "Makanan Utama",
                    province = province,
                    cookingTimeMinutes = spec.cookingTime,
                    prepTimeMinutes = spec.prepTime,
                    difficulty = spec.difficulty,
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
                    reviewCount = 110 + (currentId % 180),
                    iconBadge = spec.iconBadge
                )
            )
            currentId++
        }

        return list
    }
}
