package com.example.data.seed

import com.example.data.model.RecipeEntity

object NusantaraRecipeDataProvider {

    fun getInitial500Recipes(): List<RecipeEntity> {
        val list = ArrayList<RecipeEntity>(500)
        list.addAll(get200MainDishes())
        list.addAll(get100CakesAndKue())
        list.addAll(get100TraditionalDrinks())
        list.addAll(get100HealthySnacks())
        return list
    }

    // -------------------------------------------------------------
    // 1. 200 MAKANAN UTAMA (LAUK PAUK & MASAKAN TRADISIONAL 38 PROVINSI)
    // -------------------------------------------------------------
    private fun get200MainDishes(): List<RecipeEntity> {
        val list = mutableListOf<RecipeEntity>()

        // Curated authentic culinary anchors
        val mainDishData = listOf(
            // 1
            DishBlueprint(
                1, "Rendang Daging Sapi Suntiang", "Sumatera Barat", 180, 30, "Mahir", 6,
                540, 42.0, 12.0, 36.0, 4.0,
                "Tinggi Protein, Halal, Bebas Gluten", "Daging Sapi, Santan Kental, Cabai Merah, Lengkuas, Serai, Daun Kunyit",
                """1 kg daging sapi bagian paha/sengkel, potong dadu 4 cm
1.5 liter santan kental dari 3 butir kelapa tua
1 liter santan encer
3 batang serai, memarkan
4 lembar daun kunyit, simpulkan
8 lembar daun jeruk purut, buang tulang daun
2 buah asam kandis
150 gr cabai merah keriting (haluskan)
12 siung bawang merah (haluskan)
7 siung bawang putih (haluskan)
4 cm lengkuas muda (haluskan)
3 cm jahe bakar (haluskan)
1 sdm ketumbar bubuk sangrai
1 sdt pala bubuk
1 sdt jintan sangrai (haluskan)
2 sdt garam""".trimIndent(),
                """1. Siapkan wajan besi tebal, masukkan santan encer, santan kental, bumbu halus, serai, daun kunyit, dan daun jeruk.
2. Masak dengan api sedang sambil terus diaduk menimba (agar santan tidak pecah) sampai mendidih dan mengeluarkan minyak kemerahan (fase gulai).
3. Masukkan potongan daging sapi dan asam kandis. Kecilkan api ke sedang-cenderung kecil.
4. Aduk secara berkala perlahan agar bagian bawah wajan tidak berkerak gosong (fase kalio, sekitar 2 jam).
5. Lanjutkan memasak dengan api sangat kecil sambil terus dibolak-balik perlahan hingga cairan habis, santan mengering, bumbu berubah warna menjadi cokelat gelap kehitaman dan mengeluarkan aroma wangi karamel bumbu rendang asli (fase rendang).
6. Angkat dan sajikan bersama nasi hangat.""".trimIndent(),
                "Gunakan kelapa tua asli yang diperas manual tanpa banyak air untuk menghasilkan minyak rendang alami (minyak gelondo) yang harum dan awet berminggu-minggu.",
                "meat"
            ),
            // 2
            DishBlueprint(
                2, "Rawon Daging Sapi Kluwek Khas Jawa Timur", "Jawa Timur", 90, 25, "Sedang", 5,
                380, 34.0, 14.0, 20.0, 3.2,
                "Tinggi Protein, Halal, Bebas Gluten", "Daging Sapi Sandung Lamur, Kluwek Hitam, Daun Jeruk, Serai, Tauge Pendek",
                """500 gr daging sapi sandung lamur (brisket), potong dadu
6 buah kluwek kualitas bagus, ambil isinya dan rendam air panas
8 siung bawang merah
5 siung bawang putih
4 butir kemiri sangrai
2 cm kunyit bakar
2 cm jahe
1 sdt ketumbar bubuk
1/2 sdt merica butir
2 batang serai, memarkan
4 lembar daun jeruk purut
2 batang daun bawang, iris 1 cm
2 liter air kaldu sapi
Garam dan gula secukupnya
Pelengkap: Sambal terasi, tauge pendek, telur asin, kerupuk udang""".trimIndent(),
                """1. Rebus potongan daging sapi dengan 2 liter air hingga empuk dan menghasilkan kaldu bening. Saring buih kotoran.
2. Haluskan kluwek bersama bawang merah, bawang putih, kemiri, kunyit, jahe, ketumbar, dan merica.
3. Tumis bumbu halus bersama serai dan daun jeruk hingga benar-benar matang, tanak, dan wangi pekat.
4. Masukkan tumisan bumbu ke dalam panci rebusan daging. Aduk rata.
5. Masak dengan api kecil selama 30-40 menit agar bumbu kluwek meresap sempurna ke dalam serat daging sapi.
6. Masukkan irisan daun bawang, garam, dan gula secukupnya. Koreksi rasa gurihnya.
7. Sajikan panas bersama tauge pendek mentah, perasan jeruk nipis, telur asin, dan sambal terasi.""".trimIndent(),
                "Pilihlah kluwek yang rasanya gurih manis tidak pahit; cicipi sedikit daging kluwek sebelum dihaluskan. Jika terasa pahit di lidah, jangan gunakan.",
                "meat"
            ),
            // 3
            DishBlueprint(
                3, "Soto Betawi Kuah Susu & Santan Gurih", "DKI Jakarta", 60, 20, "Sedang", 4,
                420, 28.0, 16.0, 28.0, 2.5,
                "Tinggi Protein, Halal", "Daging Sapi, Santan, Susu Evaporasi, Minyak Samin, Kentang, Tomat",
                """400 gr daging sapi sengkel
200 gr babat/kikil sapi (rebus terpisah hingga empuk)
500 ml santan sedang
300 ml susu cair evaporasi murni
1 sdm minyak samin untuk menumis
2 batang serai memarkan
3 lembar daun salam
4 lembar daun jeruk
2 butir cengkeh
3 cm kayu manis
Bumbu halus: 8 siung bawang merah, 4 siung bawang putih, 4 kemiri, 2 cm jahe, 1 sdt ketumbar, 1/2 sdt jintan, garam & merica
Pelengkap: Kentang goreng dadu, irisan tomat merah, daun bawang, emping melinjo, jeruk limau""".trimIndent(),
                """1. Rebus daging sapi dengan 1.2 liter air hingga empuk. Ambil kaldunya sebanyak 800 ml, potong-potong daging dan jeroan.
2. Panaskan minyak samin, tumis bumbu halus bersama serai, salam, daun jeruk, cengkeh, dan kayu manis hingga harum matang.
3. Tuang tumisan bumbu ke dalam panci kaldu daging. Didihkan.
4. Tuangkan santan dan susu evaporasi perlahan sambil diaduk rata agar tidak pecah.
5. Masukkan potongan daging, bumbui dengan garam dan sedikit kaldu sapi. Masak dengan api kecil hingga bumbu meresap.
6. Tata kentang goreng dan tomat di mangkuk saji, siram kuah soto panas beserta daging, taburi daun bawang, emping, dan tetesan jeruk limau.""".trimIndent(),
                "Penggunaan susu evaporasi dan minyak samin memberikan kuah gurih lembut tanpa rasa enek dan membuat aroma soto Betawi otentik khas restoran legendaris.",
                "meat"
            ),
            // 4
            DishBlueprint(
                4, "Gudeg Basah Nangka Telur Khas Yogyakarta", "DI Yogyakarta", 150, 30, "Mahir", 6,
                360, 18.0, 48.0, 16.0, 6.5,
                "Halal, Kaya Serat, Tradisional", "Nangka Muda, Telur Bebek Rebus, Santan Kental, Gula Merah Jawa, Daun Jati",
                """1 kg nangka muda (gori), cacah kasar
6 butir telur rebus, kupas kulitnya
1 liter santan kental dari 2 butir kelapa
1 liter santan encer
150 gr gula merah aren cokelat tua sisir
5 lembar daun salam
4 lembar daun jati muda (opsional untuk warna merah alami)
4 cm lengkuas, memarkan
Bumbu halus: 12 butir bawang merah, 6 siung bawang putih, 6 butir kemiri, 1 sdm ketumbar sangrai, 1 sdm garam""".trimIndent(),
                """1. Alasi dasar panci tebal dengan daun jati dan daun salam serta lengkuas.
2. Susun bertingkat: potongan nangka muda, bumbu halus, gula aren, dan telur rebus.
3. Tuang santan encer perlahan hingga merendam nangka muda.
4. Masak di atas api sedang hingga mendidih, lalu kecilkan api paling minimal. Tutup panci rapat.
5. Setelah nangka mulai empuk dan cairan menyusut (sekitar 1.5 jam), tuang santan kental.
6. Terus masak perlahan dengan api lilin selama 2 jam lagi hingga santan terserap habis, nangka berwarna cokelat kemerahan cantik dan teksturnya lumer lembut.
7. Sajikan bersama sambal goreng krecek dan opor ayam.""".trimIndent(),
                "Daun jati muda dan gula aren murni gelap adalah rahasia warna merah kecokelatan alami gudeg Yogyakarta tanpa pewarna buatan.",
                "vegetable"
            ),
            // 5
            DishBlueprint(
                5, "Ayam Betutu Gilimanuk Bumbu Rajang Komplit", "Bali", 120, 35, "Mahir", 5,
                410, 38.0, 8.0, 26.0, 3.0,
                "Tinggi Protein, Halal, Bebas Gluten", "Ayam Kampung Utuh, Bumbu Base Genep, Daun Singkong, Minyak Kelapa Tandusan",
                """1 ekor ayam kampung muda utuh (sekitar 900 gr - 1 kg)
1 ikat daun singkong muda, rebus peras airnya
Bumbu Rajang Halus (Base Genep):
15 siung bawang merah cincang halus
8 siung bawang putih cincang halus
10 buah cabai rawit merah iris
6 buah cabai merah besar cincang
4 cm kunyit bakar cincang
4 cm lengkuas cincang
3 cm jahe cincang
3 cm kencur cincang
4 batang serai ambil bagian putih iris halus
4 butir kemiri sangrai haluskan
1 sdt terasi bakar
1 sdm ketumbar bubuk
1/2 sdt merica hitam bubuk
3 sdm minyak kelapa murni (lengis tandusan)
Garam secukupnya
Pembungkus: Daun pisang dan pelepah pinang/aluminium foil""".trimIndent(),
                """1. Tumis separuh bumbu rajang dengan minyak kelapa hingga wangi sedap, campurkan dengan daun singkong rebus dan garam.
2. Lumuri ayam kampung luar dalam dengan sisa bumbu mentah dan garam sambil dipijat-pijat merata.
3. Masukkan campuran daun singkong berbumbu ke dalam rongga perut ayam, semat ujungnya dengan tusuk gigi.
4. Bungkus ayam rapat-rapat dengan beberapa lapis daun pisang.
5. Kukus ayam selama 60 menit hingga bumbu meresap dan daging empuk.
6. Panggang di oven atau di atas bara arang selama 30 menit agar aroma daun pisang terbakar meresap ke dalam daging ayam.
7. Sajikan hangat bersama sambal matah dan plecing kangkung.""".trimIndent(),
                "Kunci kelezatan ayam betutu Bali terletak pada teknik rajang halus (bukan diblender halus berair) dan penggunaan minyak kelapa asli kelapa kampung.",
                "poultry"
            ),
            // 6
            DishBlueprint(
                6, "Pempek Palembang Asli Kapal Selam & Lenjer", "Sumatera Selatan", 50, 30, "Sedang", 4,
                320, 24.0, 46.0, 6.0, 2.0,
                "Tinggi Protein, Halal", "Ikan Tenggiri Giling, Tepung Sagu Tani, Telur Ayam, Gula Batok Aren, Ebi",
                """500 gr daging ikan tenggiri segar giling dingin
350 gr tepung sagu tani kualitas nomor satu
250 ml air es matang
2 sdt garam halus
1 sdt kaldu jamur
4 butir telur bebek/ayam untuk isian kapal selam
Bahan Kuah Cuko Kental:
400 gr gula batok aren hitam Linggau
500 ml air
50 gr asam jawa
50 gr bawang putih utuh haluskan
50 gr cabai rawit hijau haluskan
2 sdm ebi sangrai haluskan
1 sdt garam""".trimIndent(),
                """1. Campurkan ikan tenggiri giling dingin dengan air es, garam, dan kaldu jamur. Uleni lembut searah hingga adonan kenyal homogen.
2. Masukkan tepung sagu sedikit demi sedikit sambil diaduk perlahan menggunakan ujung jari (jangan diuleni keras agar pempek tidak alot).
3. Bentuk adonan menyerupai mangkok lonjong tipis, tuang 1 butir telur ke dalamnya, rapatkan bibir adonan hingga tertutup rapat.
4. Rebus segera dalam air mendidih yang diberi sedikit minyak sayur hingga mengapung dan matang (sekitar 15 menit). Tiriskan.
5. Kuah Cuko: Rebus air, gula batok aren, dan asam jawa hingga gula larut. Saring. Didihkan kembali lalu masukkan bawang putih, cabai rawit halus, ebi, dan garam. Masak hingga mengental wangi.
6. Goreng pempek dalam minyak panas hingga kuning keemasan, potong-potong, siram dengan cuko kental pedas gurih.""".trimIndent(),
                "Selalu gunakan daging ikan dingin segar dan campurkan sagu dengan teknik mengayak lembut; jangan pernah menguleni adonan sagu seperti adonan roti.",
                "seafood"
            ),
            // 7
            DishBlueprint(
                7, "Coto Makassar Daging Sapi & Kacang Gurih", "Sulawesi Selatan", 90, 20, "Sedang", 5,
                410, 35.0, 18.0, 22.0, 2.8,
                "Tinggi Protein, Halal, Bebas Gluten", "Daging Sapi Sandung Lamur, Kacang Tanah Sangrai Halus, Air Cucian Beras, Serai",
                """500 gr daging sapi sandung lamur / sengkel
2 liter air tajin (air cucian beras putih yang ke-3/4)
150 gr kacang tanah, goreng lalu blender hingga halus lembut
4 batang serai memarkan
5 lembar daun salam
3 cm lengkuas memarkan
Bumbu halus: 10 siung bawang merah, 6 siung bawang putih, 1 sdm ketumbar sangrai, 1 sdt jintan sangrai, 1/2 sdt merica butir, 2 cm jahe, garam
Pelengkap: Sambal tauco, perasan jeruk nipis, irisan daun seledri, bawang goreng, ketupat/buras""".trimIndent(),
                """1. Rebus daging sapi dalam air tajin beras bersama serai, salam, dan lengkuas sampai daging empuk. Angkat daging lalu potong dadu.
2. Tumis bumbu halus dengan sedikit minyak sampai harum dan matang sempurna.
3. Masukkan tumisan bumbu ke dalam panci kuah kaldu rebusan daging.
4. Masukkan kacang tanah sangrai yang sudah dihaluskan ke dalam kuah, aduk rata agar kuah mengental gurih.
5. Masukkan kembali potongan daging ke dalam kuah, bumbui garam dan kaldu bubuk, masak 20 menit dengan api kecil hingga rasa menyatu.
6. Sajikan panas di mangkuk bersama irisan daun bawang, seledri, taburan bawang goreng, perasan jeruk nipis, dan sambal tauco.""".trimIndent(),
                "Air tajin beras putih yang bersih adalah rahasia tradisional kuah Coto Makassar menjadi kental legit alami dan mengikat aroma kacang tanah dengan sempurna.",
                "meat"
            ),
            // 8
            DishBlueprint(
                8, "Papeda Kuah Kuning Ikan Tongkol Khas Papua", "Papua", 40, 20, "Mudah", 4,
                290, 28.0, 36.0, 4.0, 2.0,
                "Bebas Gluten, Rendah Lemak, Halal", "Tepung Sagu Murni, Ikan Tongkol Segar, Daun Kemangi, Kunyit, Jeruk Nipis",
                """Bahan Papeda:
200 gr tepung sagu murni basah/kering
1000 ml air mendidih panas
1/2 sdt garam
1 sdt air perasan jeruk nipis
Bahan Ikan Kuah Kuning:
500 gr ikan tongkol/kakap potong melintang
600 ml air
1 ikat daun kemangi segar
2 batang serai memarkan
2 lembar daun salam
1 buah tomat merah iris
Bumbu halus kuah: 6 bawang merah, 3 bawang putih, 3 cm kunyit bakar, 2 cm jahe, 3 butir kemiri, garam dan gula""".trimIndent(),
                """1. Kuah Kuning: Tumis bumbu halus bersama serai dan daun salam hingga harum. Tuang air, didihkan.
2. Masukkan potongan ikan tongkol yang sudah dilumuri jeruk nipis. Bumbui garam dan gula. Masak dengan api sedang hingga ikan matang lembut.
3. Masukkan irisan tomat dan daun kemangi sesaat sebelum diangkat. Matikan api.
4. Papeda: Larutkan tepung sagu dengan 100 ml air dingin dan perasan jeruk nipis di mangkuk tahan panas.
5. Siramkan air mendidih (panas bergolak) sedikit demi sedikit ke dalam mangkuk sagu sambil diaduk cepat memutar menggunakan sumpit/sendok kayu hingga adonan berubah bening kenyal transparan.
6. Gulung papeda dengan sumpit kayu (gata-gata), letakkan di piring dan siram kuah kuning hangat bersama ikan.""".trimIndent(),
                "Pastikan air yang disiramkan ke sagu benar-benar mendidih 100 derajat Celsius agar papeda langsung matang menjadi gel transparan kenyal.",
                "seafood"
            ),
            // 9
            DishBlueprint(
                9, "Ayam Taliwang Bakar Pedas Khas Lombok", "Nusa Tenggara Barat", 45, 20, "Sedang", 4,
                380, 40.0, 6.0, 22.0, 2.0,
                "Tinggi Protein, Halal, Bebas Gluten", "Ayam Kampung Muda, Terasi Bakar Lombok, Cabai Rawit, Kencur, Gula Merah",
                """1 ekor ayam kampung muda utuh, belah dada tidak putus (posisi bekakak)
Bumbu Taliwang:
12 buah cabai merah keriting
15 buah cabai rawit merah (sesuai selera pedas)
8 siung bawang merah
5 siung bawang putih
4 cm kencur
1 buah tomat merah matang
1 sdm terasi bakar khas Lombok
1 sdm gula merah sisir
1 sdt garam
3 sdm minyak kelapa untuk menumis
1 buah jeruk limau""".trimIndent(),
                """1. Haluskan cabai, bawang merah, bawang putih, kencur, tomat, dan terasi bakar.
2. Tumis bumbu halus dengan minyak kelapa sampai harum matang dan berminyak. Bumbui garam dan gula aren.
3. Lumuri ayam kampung dengan sebagian bumbu tumis. Panggang setengah matang di atas bara api arang.
4. Celupkan atau olesi ayam berulang kali dengan sisa bumbu taliwang sambil dibolak-balik di atas bara hingga bumbu meresap terkaramelisasi dan kulit ayam kecokelatan sedap.
5. Beri perasan jeruk limau sesaat sebelum disajikan bersama plecing kangkung dan beberuk terong.""".trimIndent(),
                "Kencur segar dan terasi bakar asli Lombok memberi tendangan aroma khas pedas membakar yang menjadi ciri khas kuliner Taliwang otentik.",
                "poultry"
            ),
            // 10
            DishBlueprint(
                10, "Sate Padang Daging & Lidah Kuah Kental Kuning", "Sumatera Barat", 60, 30, "Sedang", 5,
                390, 32.0, 24.0, 18.0, 2.2,
                "Tinggi Protein, Halal", "Daging Sapi, Lidah Sapi, Tepung Beras, Kunyit, Jintan, Serai, Daun Kunyit",
                """300 gr daging sapi sengkel
200 gr lidah sapi (rebus kupas kulit luar)
Tusuk sate secukupnya
60 gr tepung beras, larutkan dengan 100 ml air
800 ml air kaldu rebusan daging
2 batang serai memarkan
3 lembar daun jeruk
1 lembar daun kunyit
Bumbu halus: 8 bawang merah, 4 bawang putih, 4 cm kunyit bakar, 2 cm jahe, 2 cm lengkuas, 1 sdm ketumbar, 1/2 sdt jintan, 1/2 sdt adas manis, cabai bubuk, garam""".trimIndent(),
                """1. Rebus daging sapi dan lidah dalam air bersama serai, daun jeruk, daun kunyit, dan bumbu halus sampai empuk dan bumbu meresap.
2. Tiriskan daging dan lidah, potong dadu 2 cm lalu tusukkan ke tusuk sate.
3. Panaskan sisa air kaldu rebusan daging yang sudah berbumbu hingga mendidih.
4. Tuangkan larutan tepung beras sedikit demi sedikit ke dalam kuah sambil terus diaduk cepat dengan api kecil hingga kuah mengental licin dan meletup-letup.
5. Bakar sate sebentar di atas panggangan bara arang atau teflon hingga harum kecokelatan.
6. Tata ketupat di piring saji, letakkan tusukan sate di atasnya, lalu siram dengan kuah kuning kental yang panas dan taburi bawang merah goreng renyah.""".trimIndent(),
                "Adas manis, jintan, dan kunyit bakar dalam rebusan kaldu memberikan aroma rempah Minang khas yang wangi tajam menggugah selera.",
                "meat"
            ),
            // 11
            DishBlueprint(
                11, "Arsik Ikan Mas Andaliman Khas Toba", "Sumatera Utara", 60, 25, "Sedang", 4,
                310, 32.0, 10.0, 14.0, 3.5,
                "Tinggi Protein, Halal, Bebas Gluten", "Ikan Mas Segar, Merica Batak Andaliman, Asam Gelugur, Kecombrang, Lokio",
                """1 kg ikan mas segar hidup (bersihkan isi perut dan insang, biarkan sisiknya)
1 sdm andaliman segar (haluskan)
6 buah asam gelugur kering
2 buah bunga kecombrang/rias, belah-belah
15 batang lokio (bawang batak), bersihkan
8 batang kacang panjang potong 5 cm
Bumbu halus: 10 butir bawang merah, 5 siung bawang putih, 8 cabai merah, 4 butir kemiri, 4 cm kunyit bakar, 3 cm jahe, 3 cm lengkuas, 1 sdm garam
1 batang serai besar memarkan""".trimIndent(),
                """1. Tata batang serai, kecombrang, asam gelugur, dan kacang panjang di dasar wajan tebal sebagai bantalan ikan mas agar tidak lengket.
2. Letakkan ikan mas di atas bantalan sayur.
3. Lumurkan bumbu halus yang telah dicampur dengan andaliman ke seluruh permukaan dan rongga perut ikan.
4. Tuangkan air hingga ikan hampir terendam.
5. Masak dengan api sedang cenderung kecil dengan wajan tertutup rapat.
6. Biarkan air menyusut perlahan hingga bumbu meresap ke dalam daging ikan mas dan kuah mengering mengental (sekitar 45 menit). Jangan membalik ikan agar tidak hancur.
7. Masukkan lokio 10 menit sebelum diangkat. Sajikan harum hangat.""".trimIndent(),
                "Andaliman segar memberikan sensasi getar getir khas ('itir-itir') di lidah yang segar dan menghilangkan aroma amis ikan air tawar secara tuntas.",
                "seafood"
            ),
            // 12
            DishBlueprint(
                12, "Sup Konro Makassar Tulang Iga Rempah Hitam", "Sulawesi Selatan", 120, 25, "Sedang", 4,
                480, 42.0, 14.0, 28.0, 3.0,
                "Tinggi Protein, Halal, Bebas Gluten", "Tulang Iga Sapi Berdaging, Kluwek, Kayu Manis, Cengkeh, Serai, Daun Salam",
                """1 kg iga sapi segar berdaging tebal
2 liter air
3 buah kluwek, rendam air hangat
2 batang serai memarkan
3 lembar daun salam
3 butir cengkeh
3 cm kayu manis
Bumbu halus: 10 siung bawang merah, 5 siung bawang putih, 4 kemiri, 1 sdm ketumbar sangrai, 1/2 sdt jintan, 1 sdt merica butir, 2 cm jahe, 2 cm lengkuas, 2 sdt garam
Pelengkap: Daun bawang iris, bawang goreng, sambal rawit, jeruk nipis""".trimIndent(),
                """1. Rebus iga sapi dalam air mendidih selama 10 menit untuk membuang darah kotor, tiriskan dan buang air pertama.
2. Rebus kembali iga sapi dengan 2 liter air baru bersama serai, salam, cengkeh, dan kayu manis hingga empuk (sekitar 1.5 jam).
3. Tumis bumbu halus bersama kluwek dengan sedikit minyak sampai harum matang dan keluar minyaknya.
4. Masukkan tumisan bumbu ke dalam panci rebusan iga sapi. Aduk rata.
5. Masak dengan api kecil selama 30 menit agar bumbu meresap ke dalam serat daging iga.
6. Sajikan sup konro panas di mangkok besar dengan taburan bawang goreng renyah dan perasan jeruk nipis.""".trimIndent(),
                "Merebus awal iga sapi dan membuang air rebusan pertama menghasilkan kuah kaldu yang jernih gurih tanpa aroma prengus.",
                "meat"
            ),
            // 13
            DishBlueprint(
                13, "Mie Aceh Kuah Daging Sapi Rempah Kari", "Aceh", 45, 20, "Sedang", 4,
                460, 26.0, 58.0, 14.0, 4.0,
                "Tinggi Protein, Halal", "Mie Kuning Basah Tebal, Daging Sapi, Kapulaga, Bunga Lawang, Tauge, Kubis",
                """400 gr mie kuning basah tebal khas Aceh
200 gr daging sapi rebus, potong dadu kecil
100 gr tauge segar
100 gr kubis iris tipis
1 batang daun bawang seledri cincang
500 ml air kaldu sapi
2 sdm kecap manis
1 sdm kecap asin
Bumbu halus rempah kari Aceh: 8 bawang merah, 4 bawang putih, 6 cabai merah keriting, 3 butir kapulaga (ambil bijinya), 1 bunga lawang (pekak), 1/2 sdt jintan, 1 sdt ketumbar, 2 cm jahe, 2 cm kunyit, garam""".trimIndent(),
                """1. Tumis bumbu halus rempah kari bersama sedikit minyak sampai matang harum dan berubah warna.
2. Masukkan potongan daging sapi rebus, aduk rata dengan bumbu.
3. Tuang air kaldu sapi, kecap manis, dan kecap asin. Masak hingga mendidih.
4. Masukkan mie kuning basah tebal, kubis iris, dan tauge segar.
5. Masak cepat dengan api besar selama 3-5 menit agar mie menyerap kuah kental rempah tanpa menjadi lembek.
6. Angkat dan sajikan panas bersama emping melinjo, acar bawang merah utuh, dan irisan jeruk nipis.""".trimIndent(),
                "Perpaduan kapulaga dan bunga lawang dalam bumbu mie Aceh menciptakan aroma kari khas Timur Tengah yang kaya rempah dan menghangatkan tubuh.",
                "meat"
            ),
            // 14
            DishBlueprint(
                14, "Nasi Liwet Komplit Khas Solo Gurih Santan", "Jawa Tengah", 60, 20, "Sedang", 5,
                450, 22.0, 62.0, 14.0, 2.5,
                "Halal", "Beras Pulen, Santan Kelapa, Suwiran Ayam Opor, Areh Gurih, Labu Siam Sayur",
                """500 gr beras pulen cuci bersih
800 ml santan sedang dari 1 butir kelapa
2 batang serai memarkan
3 lembar daun salam
1 sdt garam
Areh Santan Kental: 300 ml santan kental kanil, 1/2 sdt garam, daun pandan (rebus aduk sampai mengental putih)
Pelengkap: Sayur labu siam pedas, suwiran ayam kampung bumbu kuning, telur pindang cokelat""".trimIndent(),
                """1. Masak beras bersama santan sedang, serai, daun salam, dan garam di panci kastrol atau rice cooker hingga matang aron.
2. Kukus nasi aron dalam kukusan panas selama 30 menit hingga matang tanak pulen dan harum gurih.
3. Siapkan Areh: Didihkan santan kental dengan garam dan daun pandan di api kecil sambil diaduk pelan hingga menjadi gumpalan areh putih gurih lembut.
4. Sajikan nasi liwet hangat di atas pincuk daun pisang, beri suwiran ayam opor, sayur labu siam pedas, telur pindang, dan siraman 1 sdm areh santan gurih di atasnya.""".trimIndent(),
                "Areh santan (gumpalan santan kental matang gurih) adalah mahkota kenikmatan nasi liwet Solo asli yang membuatnya terasa lumer di mulut.",
                "poultry"
            ),
            // 15
            DishBlueprint(
                15, "Ayam Woku Belanga Khas Manado Harum Kemangi", "Sulawesi Utara", 40, 20, "Sedang", 4,
                350, 36.0, 8.0, 18.0, 3.2,
                "Tinggi Protein, Halal, Bebas Gluten", "Ayam Segar, Daun Kemangi, Daun Pandan, Daun Jeruk, Daun Kunyit, Serai",
                """1 ekor ayam (sekitar 800 gr), potong 12 bagian
2 ikat daun kemangi segar, petik daunnya
1 lembar daun kunyit muda, iris halus
2 lembar daun pandan, simpulkan
6 lembar daun jeruk purut, buang tulang iris halus
2 batang serai, memarkan
2 batang daun bawang, potong 1 cm
1 buah tomat merah potong-potong
Bumbu halus: 10 siung bawang merah, 4 siung bawang putih, 12 cabai rawit merah, 5 cabai merah besar, 4 butir kemiri sangrai, 3 cm jahe, 3 cm kunyit bakar, 1.5 sdt garam
Air perasan jeruk nipis""".trimIndent(),
                """1. Lumuri potongan ayam dengan perasan jeruk nipis dan sedikit garam, diamkan 15 menit.
2. Tumis bumbu halus di wajan belanga tebal bersama serai, daun pandan, daun jeruk, dan daun kunyit hingga harum matang.
3. Masukkan potongan ayam, aduk rata hingga ayam berubah warna kaku dan bumbu meresap.
4. Tuang 200 ml air panas, tutup belanga dan masak dengan api sedang hingga daging ayam matang empuk dan kuah menyusut berminyak.
5. Masukkan irisan tomat, daun bawang, dan daun kemangi segar melimpah. Aduk cepat selama 1 menit hingga layu harum.
6. Matikan api dan sajikan hangat berkuah segar pedas beraroma rempah wangi.""".trimIndent(),
                "Kombinasi daun aromatik (pandan, jeruk, kunyit, serai, kemangi) harus segar agar kuah woku beraroma wangi rempah segar khas Manado.",
                "poultry"
            )
        )

        // Add the anchor dishes
        for (blueprint in mainDishData) {
            list.add(blueprint.toEntity("Makanan Utama"))
        }

        // Systematically generate remaining main dishes up to 200 items covering every Indonesian province!
        val provinces = listOf(
            "Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Kepulauan Riau", "Jambi",
            "Sumatera Selatan", "Bangka Belitung", "Bengkulu", "Lampung", "DKI Jakarta",
            "Banten", "Jawa Barat", "Jawa Tengah", "DI Yogyakarta", "Jawa Timur", "Bali",
            "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Tengah",
            "Kalimantan Selatan", "Kalimantan Timur", "Kalimantan Utara", "Sulawesi Utara",
            "Gorontalo", "Sulawesi Tengah", "Sulawesi Barat", "Sulawesi Selatan",
            "Sulawesi Tenggara", "Maluku", "Maluku Utara", "Papua", "Papua Barat",
            "Papua Pegunungan", "Papua Selatan", "Papua Barat Daya", "Papua Tengah"
        )

        val dishTemplates = listOf(
            Pair("Gulai Ikan Patin Kuah Kuning", "Ikan Patin, Santan, Belimbing Wuluh, Serai, Kunyit"),
            Pair("Ikan Bakar Bumbu Jimbaran", "Ikan Kakap Merah, Bumbu Bakar Terasi Tomat, Kecap Manis"),
            Pair("Empal Gentong Daging Sapi", "Daging Sapi Sengkel, Santan Gurih, Kucai, Daun Salam"),
            Pair("Bebek Betutu Gilimanuk", "Bebek Kampung, Base Genep Bali, Daun Singkong, Minyak Kelapa"),
            Pair("Tengkleng Kambing Kuah Bening", "Tulang Kambing Muda, Serai, Lengkuas, Cabai Rawit"),
            Pair("Sate Maranggi Daging Sapi Empuk", "Daging Sapi Lulur, Ketumbar, Air Asam Jawa, Kecap Manis"),
            Pair("Garang Asem Ayam Kampung", "Ayam Kampung, Belimbing Wuluh, Cabai Rawit, Santan, Daun Pisang"),
            Pair("Se'i Sapi Asap Daun Kesambi", "Daging Sapi Asap, Garam Laut, Sambal Lu'at Khas NTT"),
            Pair("Bebek Sinjay Bumbu Serundeng", "Bebek Gurih, Bumbu Kuning Rempah, Sambal Pencit Mangga Muda"),
            Pair("Pallubasa Daging Sapi Telur Kuning", "Daging Sapi, Kelapa Sangrai Tumbuk, Kuning Telur Kampung"),
            Pair("Ikan Cakalang Suwir Rica-Rica", "Ikan Cakalang Asap, Cabai Rawit Merah, Bawang Merah, Jeruk Nipis"),
            Pair("Ikan Kuah Asam Manado", "Ikan Kerapu, Belimbing Sayur, Tomat Hijau, Daun Kemangi, Serai"),
            Pair("Soto Banjar Ayam Kampung Kuah Susu", "Ayam Kampung, Kayu Manis, Cengkeh, Telur Rebus, Perkedel"),
            Pair("Nasi Gandul Khas Pati", "Daging Sapi Empuk, Santan Bumbu Rempah, Daun Pisang"),
            Pair("Mie Kocok Kaki Sapi Bandung", "Mie Kuning, Kikil Kaki Sapi, Tauge, Seledri, Kuah Kaldu"),
            Pair("Pepes Ikan Mas Duri Lunak Kemangi", "Ikan Mas, Daun Kemangi, Cabai Rawit, Daun Salam, Daun Pisang"),
            Pair("Nasi Megono Komplit Pekalongan", "Nangka Muda Cincang, Kelapa Parut Gurih, Kecombrang, Teri"),
            Pair("Sate Lilit Ikan Laut Bumbu Bali", "Daging Ikan Tenggiri, Kelapa Parut Muda, Serai, Base Genep"),
            Pair("Brongkos Daging Kacang Tolo", "Daging Sapi, Kluwek, Kacang Tolo, Tahu Kulit, Cabai Rawit"),
            Pair("Sop Buntut Sapi Kuah Kaldu Bening", "Buntut Sapi, Wortel, Kentang, Pala, Cengkeh, Seledri")
        )

        var idCounter = 16
        while (list.size < 200) {
            val province = provinces[idCounter % provinces.size]
            val template = dishTemplates[(idCounter - 16) % dishTemplates.size]
            val title = "${template.first} Khas $province"
            val prep = 20 + ((idCounter * 7) % 20)
            val cook = 35 + ((idCounter * 11) % 55)
            val cal = 320 + ((idCounter * 13) % 220)
            val prot = 24.0 + ((idCounter * 3) % 18)
            val carb = 8.0 + ((idCounter * 5) % 28)
            val fat = 12.0 + ((idCounter * 4) % 18)
            val fiber = 2.0 + ((idCounter % 5) * 0.5)

            val dishIngs = template.second.split(",").map { it.trim() }
            val mainIng = dishIngs.firstOrNull() ?: "Bahan Pilihan"
            val subIng1 = if (dishIngs.size > 1) "200 ml ${dishIngs[1]}" else "250 ml Santan Sedang Gurih"
            val subIng2 = if (dishIngs.size > 2) "3 buah ${dishIngs[2]}" else "2 buah Tomat Merah"

            list.add(
                RecipeEntity(
                    id = idCounter,
                    title = title,
                    category = "Makanan Utama",
                    province = province,
                    cookingTimeMinutes = cook,
                    prepTimeMinutes = prep,
                    difficulty = if (cook > 60) "Mahir" else if (cook > 40) "Sedang" else "Mudah",
                    servings = 4,
                    calories = cal,
                    protein = prot,
                    carbs = carb,
                    fat = fat,
                    fiber = fiber,
                    dietTags = if (prot > 30) "Tinggi Protein, Halal, Bebas Gluten" else "Halal, Tradisional",
                    mainIngredients = template.second,
                    ingredients = """Bahan Utama:
500 gr $mainIng
$subIng1
$subIng2
Bumbu Rempah Segar Khas $province:
6 siung bawang merah iris halus
4 siung bawang putih cincang
3 cm lengkuas dan jahe memarkan
2 batang serai harum memarkan
3 lembar daun salam dan daun jeruk
1 sdt garam laut dan 1 sdt gula pasir
2 sdm minyak kelapa untuk menumis""".trimIndent(),
                    instructions = """1. Siapkan dan cuci bersih bahan utama dengan perasan jeruk nipis untuk menjaga kesegaran.
2. Tumis bumbu halus bersama rempah aromatik (serai, salam, daun jeruk) hingga harum matang.
3. Masukkan bahan utama, aduk rata hingga terselimuti bumbu gurih.
4. Tuang air kaldu/santan secukupnya, masak dengan api sedang hingga bumbu meresap sempurna.
5. Koreksi rasa gurih dan bumbu rempahnya. Angkat dan sajikan selagi hangat.""".trimIndent(),
                    chefTips = "Gunakan rempah segar dan masak dengan api teratur agar sari bumbu meresap merata ke dalam serat masakan khas $province.",
                    rating = 4.7 + ((idCounter % 4) * 0.1),
                    reviewCount = 50 + ((idCounter * 7) % 350),
                    iconBadge = if (template.first.contains("Ikan")) "seafood" else if (template.first.contains("Ayam") || template.first.contains("Bebek")) "poultry" else "meat"
                )
            )
            idCounter++
        }

        return list
    }

    // -------------------------------------------------------------
    // 2. 100 CAKE & KUE TRADISIONAL NUSANTARA
    // -------------------------------------------------------------
    private fun get100CakesAndKue(): List<RecipeEntity> {
        val list = mutableListOf<RecipeEntity>()

        val cakeAnchors = listOf(
            DishBlueprint(
                201, "Bika Ambon Bersarang Asli Medan", "Sumatera Utara", 60, 45, "Sedang", 8,
                240, 5.0, 36.0, 9.0, 1.0,
                "Halal, Lembut, Tradisional", "Tepung Sagu Tani, Santan Kental, Daun Jeruk, Kunyit Alami, Ragi Instan",
                """150 gr tepung sagu tani
50 gr tepung terigu serbaguna
200 gr gula pasir butiran halus
300 ml santan kental dari 1 butir kelapa
10 lembar daun jeruk purut, remas
2 batang serai memarkan
1 sdt kunyit bubuk larutkan sedikit air
6 butir kuning telur + 2 butir putih telur
Bahan Biang:
50 ml air hangat
1 sdt ragi instan
1 sdt gula pasir
1 sdm tepung terigu""".trimIndent(),
                """1. Rebus santan bersama daun jeruk, serai, dan larutan kunyit hingga mendidih sambil diaduk. Dinginkan hingga suhu ruang lalu saring.
2. Campurkan bahan biang di mangkok, diamkan 10-15 menit hingga berbuih aktif.
3. Kocok telur dan gula pasir hingga larut dan mengembang lembut (tidak perlu kaku).
4. Masukkan tepung sagu dan terigu bergantian dengan rebusan santan dan adonan biang, aduk searah hingga licin tidak bergerindil.
5. Tutup wadah adonan dengan serbet bersih, fermentasikan selama 2-3 jam hingga berbuih banyak.
6. Panaskan cetakan bika ambon tebal beroles minyak di atas wajan pengalas pasir hingga benar-benar panas.
7. Tuang adonan 3/4 cetakan, biarkan terbuka dengan api kecil hingga muncul gelembung pori-pori sarang di permukaan.
8. Setelah permukaan mengering, tutup cetakan sebentar atau panggang atas hingga kuning keemasan.""".trimIndent(),
                "Wajan beralas pasir atau cetakan tebal adalah kunci penyebaran panas stabil dari bawah agar rongga sarang bika ambon terbentuk lurus dan berserat indah.",
                "cake"
            ),
            DishBlueprint(
                202, "Lapis Legit Prunes Klasik Kuno", "DKI Jakarta", 90, 60, "Mahir", 12,
                380, 6.0, 34.0, 24.0, 1.2,
                "Mewah, Tradisional, Halal", "Kuning Telur Ayam Kampung, Mentega Wijsman, Gula Halus, Bumbu Spekuk, Buah Prunes",
                """30 butir kuning telur ayam segar suhu ruang
350 gr mentega berkualitas tinggi (Wijsman)
150 gr margarin premium
250 gr gula halus
70 gr tepung terigu protein rendah
30 gr susu bubuk full cream
1 sdm bumbu spekuk harum
100 gr buah prunes kering pipihkan tipis""".trimIndent(),
                """1. Kocok mentega dan margarin hingga mengembang putih lembut creamy (sekitar 15 menit). Sisihkan.
2. Di wadah lain, kocok kuning telur dan gula halus dengan kecepatan tinggi hingga kental berjejak.
3. Campurkan adonan mentega ke kocokan telur secara bertahap dengan spatula teknik lipat balik.
4. Ayak tepung terigu, susu bubuk, dan bumbu spekuk ke dalam adonan, aduk perlahan hingga rata.
5. Panaskan oven suhu 175°C, siapkan loyang 20x20 cm yang dialasi kertas roti.
6. Tuang 1 sendok sayur adonan (sekitar 75 gr), ratakan. Panggang api atas bawah 5-7 menit hingga kecokelatan.
7. Keluarkan loyang, tekan perlahan dengan penekan lapis legit, tuang lapisan kedua, panggang dengan api atas saja.
8. Beri potongan buah prunes pada lapisan kelima dan kesepuluh. Ulangi proses melapis hingga adonan habis.
9. Dinginkan sempurna sebelum dipotong rapi.""".trimIndent(),
                "Tekan setiap lapisan secara lembut merata dengan penekan lapis legit khusus yang diolesi sedikit mentega agar tiap lembaran menyatu padat sempurna.",
                "cake"
            ),
            DishBlueprint(
                203, "Klappertaart Panggang Manado Kelapa Muda", "Sulawesi Utara", 50, 20, "Sedang", 6,
                290, 7.0, 32.0, 15.0, 1.5,
                "Halal, Kaya Kalsium", "Kelapa Muda Keruk, Susu Segar, Kenari Panggang, Kismis, Bubuk Kayu Manis",
                """500 ml susu cair segar
200 ml air kelapa muda asli
2 butir kelapa muda, keruk dagingnya
100 gr gula pasir
50 gr tepung maizena
50 gr tepung terigu protein sedang
3 butir kuning telur kocok lepas
50 gr mentega tawar leleh
50 gr kismis rendam air hangat
50 gr kacang kenari panggang cincang
1/2 sdt bubuk kayu manis
Topping Meringue: 3 putih telur, 2 sdm gula halus, kayu manis bubuk""".trimIndent(),
                """1. Larutkan tepung terigu dan maizena dengan sebagian susu cair dan air kelapa.
2. Masak sisa susu dan gula pasir di panci hingga hangat, tuangkan larutan tepung sambil diaduk cepat hingga mengental meletup-letup.
3. Masukkan mentega dan kuning telur, aduk cepat hingga licin menyatu.
4. Masukkan daging kelapa muda keruk, kismis, dan kenari cincang. Aduk rata, matikan api.
5. Tuang adonan ke dalam pinggan tahan panas (cup aluminium).
6. Panggang dengan teknik water bath (au bain-marie) suhu 160°C selama 25 menit.
7. Beri topping putih telur kocok kaku (meringue), taburan kayu manis dan kismis, panggang lagi 10 menit hingga puncak meringue kecokelatan cantik.""".trimIndent(),
                "Teknik water-bath (memanggang dengan meletakkan loyang di atas wadah berisi air panas) menjaga tekstur klappertaart tetap lumer seperti custard lembut.",
                "cake"
            ),
            DishBlueprint(
                204, "Kue Lumpur Kentang Pandan Keju Lembut", "Jawa Timur", 40, 20, "Mudah", 8,
                210, 4.5, 30.0, 8.0, 1.8,
                "Halal, Bebas Pengawet", "Kentang Kukus Halus, Santan Daun Pandan, Tepung Terigu, Telur, Kismis",
                """250 gr kentang kukus, haluskan selagi hangat
250 gr tepung terigu protein sedang
200 gr gula pasir
500 ml santan sedang hangat (rebus dengan daun pandan)
2 butir telur ayam
100 gr mentega lelehkan
1/2 sdt garam
Topping: Kismis dan keju parut secukupnya""".trimIndent(),
                """1. Blender kentang kukus bersama santan pandan dan gula pasir hingga halus lembut tanpa serat.
2. Kocok telur dengan garpu, masukkan ke dalam adonan kentang bersama tepung terigu yang telah diayak dan garam. Aduk rata.
3. Tuangkan mentega leleh, aduk perlahan menggunakan whisk hingga adonan licin homogen.
4. Panaskan cetakan kue lumpur olesi tipis mentega dengan api kecil.
5. Tuang adonan hingga 3/4 cetakan, tutup dan biarkan setengah matang.
6. Beri topping kismis dan keju di tengah permukaan, tutup kembali hingga kue matang padat lembut.
7. Angkat menggunakan bantuan sendok kecil, sajikan hangat.""".trimIndent(),
                "Gunakan kentang jenis tes atau kentang kuning yang tidak berair agar tekstur kue lumpur legit lembut dan tidak lembek berair.",
                "cake"
            ),
            DishBlueprint(
                205, "Serabi Solo Notosuman Gulung Daun Pisang", "Jawa Tengah", 35, 20, "Sedang", 6,
                195, 3.5, 28.0, 7.5, 1.2,
                "Halal, Bebas Gluten, Tradisional", "Tepung Beras, Santan Kelapa Murni, Gula Pasir, Areh Gurih, Daun Pandan",
                """200 gr tepung beras kualitas baik
1 sdm tepung tapioka
50 gr gula pasir
1/2 sdt ragi instan
500 ml santan hangat dari 1 butir kelapa
1/2 sdt garam
Areh Santan Manis Gurih:
200 ml santan sangat kental
1/2 sdt garam
1 lembar daun pandan
Topping: Cokelat meises atau nangka cincang""".trimIndent(),
                """1. Campur tepung beras, tapioka, gula, ragi, dan garam. Tuangkan santan hangat perlahan sambil diaduk dan ditepuk-tepuk dengan tangan selama 10 menit agar adonan menangkap udara.
2. Diamkan adonan selama 1 jam hingga mengembang berbuih halus.
3. Masak areh santan kental dengan garam dan daun pandan hingga berminyak dan kental.
4. Panaskan wajan tembikar/wajan serabi kecil tanpa minyak dengan api kecil.
5. Tuang 1 sendok sayur adonan serabi, gerakkan sendok sayur memutar ke pinggir wajan untuk membentuk kerak tipis renyah (renda).
6. Tuangkan 1 sendok teh areh santan kental di tengah serabi, beri taburan meises/nangka, tutup wajan hingga matang mengilap.
7. Angkat dan gulung selagi hangat beralas daun pisang khas Notosuman.""".trimIndent(),
                "Tepukan adonan saat pengadukan awal menghasilkan serat sarang serabi yang lembut meleleh di lidah dengan pinggiran renyah gurih.",
                "cake"
            )
        )

        for (blueprint in cakeAnchors) {
            list.add(blueprint.toEntity("Cake & Kue"))
        }

        val traditionalCakes = listOf(
            Pair("Kue Dadar Gulung Unti Kelapa Pandan", "Tepung Terigu, Jus Pandan Suji, Kelapa Parut, Gula Merah Aren"),
            Pair("Kue Klepon Pandan Lumer Gula Jawa", "Tepung Ketan Putih, Air Daun Suji Pandan, Gula Merah, Kelapa Parut"),
            Pair("Nagasari Pisang Raja Bungkus Daun", "Tepung Beras, Santan Kelapa, Pisang Raja Matang, Gula Pasir"),
            Pair("Kue Cucur Gula Merah Berserat", "Tepung Beras, Tepung Terigu, Gula Merah Aren, Daun Pandan"),
            Pair("Bolu Kojo Lembut Harum Pandan", "Tepung Terigu, Santan Kental, Telur Ayam, Jus Pandan Asli"),
            Pair("Kue Putu Ayu Kelapa Parut Gurih", "Tepung Terigu, Santan, Telur, Kelapa Parut Muda, Pasta Pandan"),
            Pair("Wingko Babat Panggang Kelapa Gurih", "Tepung Ketan, Kelapa Parut Setengah Tua, Gula Pasir, Vanili"),
            Pair("Kue Pukis Banyumas Keju Cokelat", "Tepung Terigu, Telur, Santan, Ragi, Margarin, Meises Cokelat"),
            Pair("Kue Talam Pandan Lapis Gurih", "Tepung Beras, Tepung Tapioka, Santan Kelapa, Daun Pandan, Garam"),
            Pair("Onde-Onde Wijen Isi Kacang Hijau", "Tepung Ketan, Biji Wijen, Kacang Hijau Kupas, Gula Pasir"),
            Pair("Kue Lupis Ketan Segitiga Gula Merah", "Beras Ketan Putih, Daun Pisang, Kelapa Parut, Kinca Gula Merah"),
            Pair("Kue Bugis Ketan Hitam Unti Kelapa", "Tepung Ketan Hitam, Santan, Unti Kelapa Gula Merah, Daun Pisang"),
            Pair("Kue Bikang Mawar Mekar Warna Warni", "Tepung Beras, Santan Hangat, Gula Pasir, Pewarna Makanan Alami"),
            Pair("Barongko Pisang Santan Khas Makassar", "Pisang Kepok Matang, Telur, Santan, Gula Pasir, Daun Pisang"),
            Pair("Kue Rangi Betawi Tabur Saus Gula Merah", "Kelapa Parut Kasar, Tepung Sagu/Tunggal, Gula Merah Kental"),
            Pair("Kue Pancong Kelapa Gurih Asin", "Tepung Beras, Santan Kelapa, Kelapa Parut Muda, Garam Halus"),
            Pair("Kue Maksuba Legit Khas Palembang", "Telur Bebek, Susu Kental Manis, Mentega Premium, Gula Pasir"),
            Pair("Bolu Meranti Gulung Lembut Medan", "Tepung Terigu, Kuning Telur, Mentega, Keju Parut / Cokelat"),
            Pair("Kue Jongkong Lembut Bangka Belitung", "Tepung Beras, Tepung Tapioka, Jus Suji, Santan Gurih, Gula Merah"),
            Pair("Kue Apem Selong Tape Singkong", "Tepung Beras, Tape Singkong Manis, Santan, Ragi, Gula Pasir")
        )

        var idCounter = 206
        while (list.size < 100) {
            val template = traditionalCakes[(idCounter - 206) % traditionalCakes.size]
            val provIndex = (idCounter - 206) % 38
            val provName = listOf("Jawa Tengah", "Jawa Barat", "DKI Jakarta", "Sumatera Barat", "Sumatera Selatan", "Bali", "Sulawesi Selatan", "Sumatera Utara", "DI Yogyakarta", "Jawa Timur")[idCounter % 10]
            val title = "${template.first} Tradisional"
            val cook = 25 + ((idCounter * 5) % 35)
            val prep = 15 + ((idCounter * 3) % 25)
            val cal = 180 + ((idCounter * 7) % 150)

            val cakeIngs = template.second.split(",").map { it.trim() }
            val cIng1 = cakeIngs.firstOrNull() ?: "Tepung Pilihan"
            val cIng2 = if (cakeIngs.size > 1) "150 gr ${cakeIngs[1]}" else "150 gr Gula Aren Asli"
            val cIng3 = if (cakeIngs.size > 2) "2 butir ${cakeIngs[2]}" else "2 butir Telur Ayam"

            list.add(
                RecipeEntity(
                    id = idCounter,
                    title = title,
                    category = "Cake & Kue",
                    province = provName,
                    cookingTimeMinutes = cook,
                    prepTimeMinutes = prep,
                    difficulty = if (cook > 40) "Sedang" else "Mudah",
                    servings = 6,
                    calories = cal,
                    protein = 3.5 + ((idCounter % 5) * 0.5),
                    carbs = 28.0 + ((idCounter % 7) * 2),
                    fat = 6.0 + ((idCounter % 4) * 1.5),
                    fiber = 1.0 + ((idCounter % 3) * 0.5),
                    dietTags = "Halal, Tradisional, Camilan Manis",
                    mainIngredients = template.second,
                    ingredients = """Bahan Adonan Utama:
250 gr $cIng1
$cIng2
$cIng3
300 ml santan kelapa harum pandan
1 sdm mentega cair berkualitas
1/2 sdt vanili bubuk
1/4 sdt garam halus""".trimIndent(),
                    instructions = """1. Campur dan ayak bahan kering dalam wadah bersih.
2. Tuang santan dan larutan gula perlahan sambil diaduk rata searah hingga tekstur adonan halus tanpa gumpalan.
3. Panaskan cetakan atau loyang yang telah diolesi minyak tipis.
4. Masak/kukus dengan api teratur hingga adonan matang sempurna dan beraroma harum legit.
5. Angkat dan sajikan kue setelah dingin untuk tekstur kenyal lembut terbaik.""".trimIndent(),
                    chefTips = "Gunakan santan segar yang direbus terlebih dahulu bersama daun pandan untuk rasa kue yang gurih alami dan awet tidak mudah basi.",
                    rating = 4.8,
                    reviewCount = 75 + (idCounter % 200),
                    iconBadge = "cake"
                )
            )
            idCounter++
        }

        return list
    }

    // -------------------------------------------------------------
    // 3. 100 MINUMAN TRADISIONAL NUSANTARA
    // -------------------------------------------------------------
    private fun get100TraditionalDrinks(): List<RecipeEntity> {
        val list = mutableListOf<RecipeEntity>()

        val drinkAnchors = listOf(
            DishBlueprint(
                301, "Wedang Jahe Serai Hangat Rempah", "Jawa Tengah", 20, 10, "Mudah", 4,
                110, 1.0, 26.0, 0.5, 1.2,
                "Rendah Lemak, Halal, Menghangatkan, Bebas Gluten", "Jahe Merah Bakar, Serai Wangi, Gula Merah Aren, Kayu Manis, Cengkeh",
                """150 gr jahe merah, bakar lalu memarkan
3 batang serai wangi, memarkan
100 gr gula aren cokelat, sisir halus
2 batang kayu manis (sekitar 5 cm)
5 butir cengkeh
2 lembar daun pandan wangi
1 liter air bersih matang""".trimIndent(),
                """1. Bakar rimpang jahe di atas api kecil hingga kulitnya harum, bersihkan bagian gosong lalu memarkan.
2. Masukkan air ke dalam panci, tambahkan jahe memarkan, serai, daun pandan, kayu manis, dan cengkeh.
3. Rebus dengan api sedang hingga mendidih dan aroma rempah tercium wangi tajam (sekitar 15 menit).
4. Masukkan sisiran gula aren, aduk hingga larut sempurna. Kecilkan api dan biarkan mendidih perlahan selama 5 menit.
5. Saring wedang jahe ke dalam cangkir saji. Nikmati selagi hangat untuk melegakan tenggorokan dan menghangatkan tubuh.""".trimIndent(),
                "Membakar jahe sebelum dimemarkan membuka pori-pori minyak atsiri di dalamnya sehingga aroma pedas hangat jahe keluar maksimal tanpa rasa pahit mentah.",
                "drink"
            ),
            DishBlueprint(
                302, "Es Pisang Ijo Khas Makassar Saus Vla", "Sulawesi Selatan", 40, 20, "Sedang", 5,
                270, 4.0, 52.0, 5.5, 2.5,
                "Halal, Segar Tradisional", "Pisang Raja Matang, Kulit Dadar Pandan Suji, Bubur Sumsum Lembut, Sirup DHT Pisang Ambon",
                """5 buah pisang raja matang tua kukus
Bahan Kulit Hijau:
100 gr tepung beras
50 gr tepung terigu
50 gr tepung sagu
300 ml santan sedang
50 ml air perasan daun pandan dan suji pekat
2 sdm gula pasir, 1/2 sdt garam
Bahan Bubur Sumsum / Saus Vla:
50 gr tepung beras
500 ml santan sedang
2 lembar daun pandan, 1/2 sdt garam
Pelengkap: Sirup merah rasa pisang ambon (DHT), susu kental manis, es serut melimpah""".trimIndent(),
                """1. Kulit Hijau: Campur tepung beras, terigu, sagu, gula, garam, santan, dan air pandan suji. Masak di api kecil sambil diaduk hingga menggumpal matang.
2. Ambil selembar plastik olesi sedikit minyak, pipihkan adonan hijau, letakkan 1 buah pisang raja kukus di tengahnya, gulung rapat membalut pisang.
3. Kukus pisang berbalut hijau selama 15 menit hingga matang kenyal. Dinginkan lalu potong melintang 2 cm.
4. Bubur Sumsum: Masak santan, tepung beras, pandan, dan garam di atas api kecil sambil diaduk konstan hingga meletup-letup kental lembut. Dinginkan.
5. Penyajian: Tata bubur sumsum di dasar mangkuk, letakkan potongan pisang ijo, beri es serut menggunung, siram sirup merah DHT dan susu kental manis.""".trimIndent(),
                "Pilihlah pisang raja yang matang pohon agar rasa manis alaminya legit berpadu sempurna dengan bubur sumsum yang gurih lembut.",
                "drink"
            ),
            DishBlueprint(
                303, "Es Cendol Dawet Ayu Banjarnegara Nangka", "Jawa Tengah", 30, 20, "Mudah", 5,
                220, 2.5, 42.0, 6.0, 1.8,
                "Halal, Bebas Gluten, Segar", "Tepung Beras, Tepung Sagu Aren, Daun Suji Alami, Santan Gurih, Kinca Gula Jawa Nangka",
                """Bahan Cendol Hijau:
100 gr tepung beras
50 gr tepung sagu aren
600 ml air perasan daun suji dan pandan
1 sdt air kapur sirih (agar cendol kenyal)
1/2 sdt garam
Bahan Kinca Gula Jawa:
300 gr gula kelapa cokelat tua asli
150 ml air
3 mata nangka matang, potong dadu kecil
1 lembar daun pandan
Bahan Kuah Santan:
500 ml santan matang direbus dengan daun pandan dan 1/2 sdt garam
Es batu secukupnya""".trimIndent(),
                """1. Cendol: Campurkan tepung beras, sagu aren, garam, air kapur sirih, dan air daun pandan suji. Masak dengan api kecil sambil diaduk tanpa henti hingga mengental licin dan matang meletup bening.
2. Siapkan wadah berisi air es matang. Tuang adonan panas ke atas cetakan cendol dawet, tekan perlahan hingga butiran cendol jatuh ke dalam air es. Tiriskan.
3. Kinca: Rebus gula merah, air, dan daun pandan hingga larut mengental. Masukkan potongan nangka, matikan api.
4. Penyajian: Tuang kinca gula merah nangka ke dasar gelas, beri butiran cendol dawet hijau, tuang kuah santan gurih, dan tambahkan bongkahan es batu dingin segar.""".trimIndent(),
                "Tepung sagu aren memberikan tekstur kenyal alami yang lembut ('ndulit') khas dawet ayu asli dan tidak mudah patah saat diseruput.",
                "drink"
            ),
            DishBlueprint(
                304, "Bir Pletok Rempah Khas Betawi Tanpa Alkohol", "DKI Jakarta", 25, 10, "Mudah", 4,
                85, 0.5, 21.0, 0.2, 1.0,
                "Rendah Kalori, Halal, Herbal Sehat", "Kayu Secang Merah, Jahe Gajah, Kapulaga, Serai, Kayu Manis, Daun Pandan",
                """1.5 liter air bersih
150 gr jahe, memarkan
25 gr serutan kayu secang (untuk warna merah menyala alami)
3 batang serai memarkan
5 butir kapulaga
4 butir cengkeh
3 cm kayu manis
1/2 butir biji pala memarkan
2 lembar daun pandan
120 gr gula batu / gula pasir""".trimIndent(),
                """1. Masukkan semua rempah: jahe, kayu secang, serai, kapulaga, cengkeh, kayu manis, pala, dan daun pandan ke dalam panci berisi air.
2. Rebus dengan api sedang hingga mendidih dan warna air berubah menjadi merah delima menyala dari kayu secang.
3. Masukkan gula batu, aduk hingga larut sempurna.
4. Kecilkan api dan biarkan mendidih perlahan selama 15 menit agar seluruh khasiat rempah terekstraksi.
5. Matikan api dan saring bir pletok.
6. Dapat dinikmati hangat-hangat atau dikocok di dalam shaker bersama es batu hingga berbusa seperti bir.""".trimIndent(),
                "Kayu secang tidak hanya memberi warna merah alami yang memukau, namun juga kaya antioksidan dan melancarkan peredaran darah.",
                "drink"
            ),
            DishBlueprint(
                305, "Es Teler Spesial Alpukat Kelapa Muda Nangka", "DKI Jakarta", 20, 15, "Mudah", 4,
                240, 3.5, 38.0, 9.0, 3.2,
                "Halal, Kaya Lemak Baik, Segar", "Alpukat Mentega Matang, Daging Kelapa Muda, Nangka Wangi, Santan Matang, Susu Kental Manis",
                """2 buah alpukat mentega matang, keruk dagingnya
1 butir kelapa muda, ambil daging keruk dan airnya
6 buah nangka matang, iris memanjang
100 ml santan matang kental
100 ml susu kental manis putih
Es serut atau es batu secukupnya""".trimIndent(),
                """1. Siapkan mangkuk saji kaca. Tata daging buah alpukat mentega yang lembut di dasar mangkuk.
2. Masukkan kerukan kelapa muda dan irisan nangka kuning yang harum semerbak.
3. Beri es serut menggunung di atas buah-buahan segar.
4. Siramkan santan gurih matang dan susu kental manis di atas es serut.
5. Tambahkan sedikit air kelapa muda segar dingin. Sajikan segera selagi dingin menyegarkan.""".trimIndent(),
                "Pilihlah alpukat mentega yang matang pas (tidak terlalu lembek dan tidak berurat pahit) untuk kenikmatan tekstur creamy yang sempurna.",
                "drink"
            )
        )

        for (blueprint in drinkAnchors) {
            list.add(blueprint.toEntity("Minuman"))
        }

        val traditionalDrinks = listOf(
            Pair("Bajigur Hangat Santan Jahe", "Santan Kelapa, Gula Aren, Jahe Bakar, Kayu Manis, Kolang Kaling"),
            Pair("Bandrek Hangat Kelapa Keruk", "Jahe Merah, Gula Merah, Merica Hitam, Kayu Manis, Serutan Kelapa Muda"),
            Pair("Wedang Ronde Isi Kacang Tumbuk", "Tepung Ketan Bulat, Isian Kacang Tanah Gula, Kuah Jahe Pandan"),
            Pair("Es Doger Segar Ketan Hitam Tape", "Es Serut Santan Merah Muda, Ketan Hitam, Tape Singkong, Alpukat"),
            Pair("Sarabba Susu Jahe Khas Makassar", "Jahe, Santan, Gula Aren, Kuning Telur Bebek, Merica"),
            Pair("Es Selendang Mayang Betawi", "Kue Tepung Hunkwe Warna-Warni, Kuah Santan Gurih, Kinca Gula Merah"),
            Pair("Jamu Kunyit Asam Segar Dingin", "Kunyit Segar Bakar, Asam Jawa, Gula Aren Murni, Garam Sedikit"),
            Pair("Jamu Beras Kencur Tradisional", "Beras Sangrai Halus, Kencur Segar, Jahe, Gula Jawa, Asam"),
            Pair("Es Kuwut Timun Jeruk Nipis Bali", "Mentimun Serut, Melon Serut, Biji Selasih, Air Kelapa, Jeruk Nipis"),
            Pair("Es Campur Medan Delima Merah", "Biji Delima Pacar Cina, Cendol, Nangka, Tape, Santan, Sirup Merah"),
            Pair("Wedang Uwuh Rempah Imogiri", "Secang, Jahe, Daun Cengkeh, Gagang Cengkeh, Kayu Manis, Gula Batu"),
            Pair("Es Kacang Merah Palembang Lembut", "Kacang Merah Empuk, Susu Kental Manis Cokelat, Es Serut, Sirup"),
            Pair("Teh Talua Minangkabau Berbusa", "Kuning Telur Ayam Kampung, Teh Hitam Pekat, Gula Pasir, Jeruk Nipis"),
            Pair("Es Goyobod Segar Khas Garut", "Hunkwe Padat Potong Dadu, Alpukat, Kelapa Muda, Pacar Cina, Santan"),
            Pair("Es Laksamana Mengamuk Khas Riau", "Mangga Kuweni Harum, Santan, Gula Pasir, Biji Selasih, Es Batu"),
            Pair("Kopi Joss Arang Panas Jogja", "Biji Kopi Tubruk Robusta, Gula Pasir, Bongkahan Arang Kayu Panas"),
            Pair("Es Cincau Hijau Santan Gula Aren", "Daun Cincau Hijau Alami, Santan Gurih, Gula Kelapa, Es Batu"),
            Pair("Es Timun Serut Jeruk Nipis Aceh", "Timun Segar Serut Kasar, Air Gula Pasir, Perasan Jeruk Nipis, Selasih"),
            Pair("Liang Teh Herbal Pontianak", "Daun Mint Herbal, Bunga Krisan, Kayu Manis, Gula Batu, Air"),
            Pair("Es Tambring Khas Bali Segar", "Air Kelapa Muda, Asam Jawa, Putih Telur, Gula Pasir, Es Batu")
        )

        var idCounter = 306
        while (list.size < 100) {
            val template = traditionalDrinks[(idCounter - 306) % traditionalDrinks.size]
            val provName = listOf("Jawa Barat", "Jawa Tengah", "DKI Jakarta", "Sulawesi Selatan", "Sumatera Barat", "Bali", "DI Yogyakarta", "Sumatera Selatan", "Aceh", "Kalimantan Barat")[idCounter % 10]
            val title = "${template.first} Khas Nusantara"
            val cook = 15 + ((idCounter * 3) % 20)
            val prep = 10 + ((idCounter * 2) % 15)
            val cal = 90 + ((idCounter * 7) % 160)

            val drinkIngs = template.second.split(",").map { it.trim() }
            val dIng1 = "200 gr " + (drinkIngs.firstOrNull() ?: "Bahan Minuman Pilihan")
            val dIng2 = if (drinkIngs.size > 1) "100 gr ${drinkIngs[1]}" else "100 gr Gula Aren Murni"
            val dIng3 = if (drinkIngs.size > 2) "2 batang ${drinkIngs[2]}" else "2 batang Serai Wangi"

            list.add(
                RecipeEntity(
                    id = idCounter,
                    title = title,
                    category = "Minuman",
                    province = provName,
                    cookingTimeMinutes = cook,
                    prepTimeMinutes = prep,
                    difficulty = "Mudah",
                    servings = 4,
                    calories = cal,
                    protein = 1.0 + ((idCounter % 4) * 0.5),
                    carbs = 20.0 + ((idCounter % 6) * 3),
                    fat = 1.5 + ((idCounter % 5) * 1.0),
                    fiber = 1.0 + ((idCounter % 3) * 0.4),
                    dietTags = if (cal < 120) "Rendah Kalori, Halal, Herbal Alami" else "Halal, Segar Tradisional",
                    mainIngredients = template.second,
                    ingredients = """Bahan Utama Minuman:
$dIng1
$dIng2
$dIng3
600 ml air bersih / air kelapa muda
3 sdm gula aren / madu alami
1/4 sdt garam halus
Es batu secukupnya""".trimIndent(),
                    instructions = """1. Bersihkan dan siapkan semua rempah dan bahan buah alami.
2. Rebus bahan rempah dengan air hingga mendidih dan sarinya keluar harum maksimal (untuk minuman hangat).
3. Untuk minuman dingin: campurkan bahan buah dan pelengkap ke dalam gelas saji.
4. Tambahkan larutan pemanis alami dan es batu secukupnya.
5. Sajikan segar dingin atau hangat melegakan.""".trimIndent(),
                    chefTips = "Gunakan bahan herbal asli dan gula aren murni untuk mendapatkan khasiat kesehatan optimal dan rasa manis yang tidak serak di tenggorokan.",
                    rating = 4.8,
                    reviewCount = 60 + (idCounter % 180),
                    iconBadge = "drink"
                )
            )
            idCounter++
        }

        return list
    }

    // -------------------------------------------------------------
    // 4. 100 CAMILAN SEHAT KHAS INDONESIA
    // -------------------------------------------------------------
    private fun get100HealthySnacks(): List<RecipeEntity> {
        val list = mutableListOf<RecipeEntity>()

        val snackAnchors = listOf(
            DishBlueprint(
                401, "Keripik Tempe Oven Bawang Gurih Renyah", "Jawa Tengah", 45, 20, "Mudah", 6,
                140, 11.0, 10.0, 6.0, 4.2,
                "Tinggi Protein, Rendah Kalori, Bebas Gluten, Vegetarian, Halal", "Tempe Kedelai Murni, Bawang Putih, Ketumbar, Daun Jeruk, Minyak Zaitun Semprot",
                """300 gr tempe kedelai murni padat, iris setipis mungkin (1-2 mm)
Bumbu Celup Sehat:
5 siung bawang putih haluskan
1 sdm ketumbar bubuk
4 lembar daun jeruk purut iris sehalus rambut
1 sdt garam laut
1/2 sdt kaldu jamur alami
100 ml air es matang
Sedikit minyak kelapa/zaitun untuk semprotan loyang""".trimIndent(),
                """1. Iris tempe dengan pisau tajam setipis mungkin. Angin-anginkan irisan tempe di atas tampah selama 20 menit agar kadar air luar berkurang.
2. Larutkan bawang putih halus, ketumbar, daun jeruk, garam, dan kaldu jamur dalam air es matang.
3. Celupkan lembaran tempe sebentar ke dalam bumbu celup (jangan direndam agar tidak lembek).
4. Tata irisan tempe di atas loyang yang telah dialasi kertas baking tanpa saling bertumpuk.
5. Panggang di oven dengan suhu 140°C selama 35-45 menit hingga air menguap habis dan tempe kering keemasan renyah (tanpa digoreng minyak banyak).
6. Keluarkan dari oven, biarkan dingin sempurna di cooling rack hingga renyah krispi, lalu simpan dalam toples kedap udara.""".trimIndent(),
                "Memanggang dengan suhu rendah (140°C) mempertahankan kandungan isoflavon dan protein tempe sambil menghasilkan tekstur kriuk tahan lama tanpa lemak trans jahat.",
                "snack"
            ),
            DishBlueprint(
                402, "Bakwan Jagung Manis Panggang Non-Goreng", "Jawa Timur", 30, 15, "Mudah", 4,
                160, 5.5, 26.0, 3.5, 3.8,
                "Rendah Kalori, Vegetarian, Kaya Serat, Halal", "Jagung Manis Pipil Segar, Tepung Beras, Daun Bawang, Seledri, Telur Ayam",
                """2 tongkol jagung manis segar (1 tongkol dipipil utuh, 1 tongkol diulek kasar)
1 butir telur ayam kocok
3 sdm tepung beras
1 sdm tepung tapioka
2 batang daun bawang, iris tipis
1 batang seledri, iris halus
Bumbu halus: 3 siung bawang putih, 4 siung bawang merah, 1/2 sdt merica, 1 sdt garam, 1/2 sdt kaldu jamur""".trimIndent(),
                """1. Campurkan jagung manis pipil dan jagung ulek kasar dalam mangkuk besar.
2. Masukkan bumbu halus, irisan daun bawang, dan seledri. Aduk rata.
3. Tambahkan telur ayam kocok, tepung beras, dan tapioka. Aduk perlahan hingga menjadi adonan kental.
4. Panaskan wajan teflon anti-lengket dengan olesan 1 sdt minyak kelapa, atau panaskan air fryer / oven suhu 180°C.
5. Sendokkan adonan bakwan, pipihkan sedikit. Masak selama 6-8 menit per sisi hingga matang kecokelatan renyah di luar dan manis juicy di dalam.
6. Angkat dan sajikan hangat bersama cabai rawit hijau.""".trimIndent(),
                "Mengulek sebagian jagung manis mengeluarkan sari manis alaminya yang merekatkan adonan secara alami tanpa butuh banyak tepung terigu.",
                "snack"
            ),
            DishBlueprint(
                403, "Tahu Gejrot Cirebon Kuah Asam Pedas Segar", "Jawa Barat", 15, 10, "Mudah", 3,
                120, 8.0, 14.0, 3.8, 2.0,
                "Rendah Kalori, Tinggi Protein, Vegetarian, Halal, Bebas Gluten", "Tahu Sumedang / Tahu Pong Kukus, Asam Jawa, Gula Merah Aren, Cabai Rawit Hijau, Bawang Merah",
                """10 buah tahu pong atau tahu sumedang (kukus hangat, potong-potong)
Bahan Kuah Gejrot:
200 ml air
75 gr gula merah aren murni
1 sdm asam jawa tanpa biji
1 sdt kecap manis
1/2 sdt garam
Bumbu Ulek Kasar Gejrot:
6 butir bawang merah
2 siung bawang putih
8 buah cabai rawit hijau (sesuai selera)
1/2 sdt garam""".trimIndent(),
                """1. Kuah: Rebus air bersama gula aren, asam jawa, kecap manis, dan garam hingga mendidih dan gula larut sempurna. Saring dan dinginkan.
2. Di atas cobek tembikar kecil, ulek kasar bawang merah, bawang putih, cabai rawit hijau, dan garam.
3. Siramkan kuah gula asam yang sudah disaring ke atas bumbu ulek di cobek, aduk rata.
4. Masukkan potongan tahu hangat ke dalam cobek kuah, tekan-tekan (gejrot) sedikit menggunakan ulekan agar kuah pedas asam meresap ke dalam pori-pori tahu.
5. Nikmati langsung dengan tusuk gigi selagi segar gurih asam pedas.""".trimIndent(),
                "Gunakan gula aren murni gelap dan ulek bawang merah dalam kondisi mentah segar sesaat sebelum disajikan agar tercipta aroma segar khas tahu gejrot Cirebon.",
                "snack"
            ),
            DishBlueprint(
                404, "Asinan Sayur Bogor Kuah Kacang Cuka Alami", "Jawa Barat", 25, 20, "Mudah", 4,
                135, 4.0, 22.0, 3.5, 4.5,
                "Rendah Kalori, Bebas Lemak Jenuh, Vegetarian, Halal, Kaya Serat", "Tauge Segar, Kol Iris, Mentimun, Tahu Putih Kukus, Kacang Tanah Sangrai, Cabai Merah",
                """100 gr tauge segar, buang ekor
100 gr kol, iris tipis
1 buah mentimun, potong tipis
50 gr sawi asin, iris halus
2 buah tahu putih sutra, potong dadu kukus matang
50 gr kacang tanah sangrai tanpa minyak
Bahan Kuah Asinan:
500 ml air matang
5 buah cabai merah besar, rebus dan blender halus
10 buah cabai rawit merah rebus haluskan
2 sdm cuka apel / cuka makan alami
3 sdm gula pasir murni
1 sdt garam laut""".trimIndent(),
                """1. Kuah: Didihkan air dengan cabai halus, gula, dan garam hingga matang dan bau langu cabai hilang. Angkat, beri cuka dan koreksi rasa asam manis segarnya. Dinginkan di kulkas.
2. Siapkan mangkuk saji, tata sayuran mentah segar: tauge, kol, mentimun, sawi asin, dan potongan tahu putih kukus.
3. Siram sayuran dengan kuah asinan dingin yang segar pedas membara.
4. Taburi kacang tanah sangrai renyah dan kerupuk mie kuning di atasnya. Sajikan segera selagi dingin renyah.""".trimIndent(),
                "Kacang tanah disangrai kering di wajan tanpa minyak membuat asinan renyah harum tanpa menambah kolesterol atau kalori minyak.",
                "snack"
            ),
            DishBlueprint(
                405, "Rujak Buah Serut Bumbu Kacang Mede Sehat", "DI Yogyakarta", 15, 15, "Mudah", 4,
                150, 3.0, 32.0, 2.0, 5.0,
                "Rendah Kalori, Kaya Vitamin C, Vegan, Bebas Gluten, Halal", "Mangga Muda, Bengkuang, Nanas Manis, Ubi Merah, Gula Aren, Kacang Mede Sangrai",
                """1 buah mangga muda, serut kasar
1 buah bengkuang manis, serut kasar
1/2 buah nanas matang, cincang halus
1 buah kedondong, serut kasar
1 buah mentimun, serut kasar
Bumbu Rujak Serut Sehat:
100 gr gula aren murni sisir
30 gr kacang mede sangrai matang
4 buah cabai rawit merah
1/2 sdt terasi bakar (opsional)
1/2 sdt garam laut
1 sdm air asam jawa""".trimIndent(),
                """1. Ulek cabai rawit, terasi bakar, dan garam di cobek batu hingga halus.
2. Tambahkan kacang mede sangrai, ulek kasar agar masih ada tekstur renyah gurih.
3. Masukkan gula aren dan air asam jawa, ulek hingga menjadi pasta bumbu kental legit.
4. Masukkan seluruh serutan buah-buahan tropis segar ke dalam mangkuk besar.
5. Tuangkan bumbu rujak kacang mede ke atas serutan buah, aduk perlahan hingga buah mengeluarkan sari air manis asam alaminya.
6. Simpan dalam kulkas selama 30 menit sebelum dinikmati dingin renyah menyegarkan.""".trimIndent(),
                "Kacang mede sangrai memberikan gurih creamy yang kaya mineral seng dan magnesium yang lebih ramah pencernaan dibandingkan kacang tanah goreng.",
                "snack"
            )
        )

        for (blueprint in snackAnchors) {
            list.add(blueprint.toEntity("Camilan Sehat"))
        }

        val healthySnacksList = listOf(
            Pair("Edamame Rebus Bawang Putih Garam Laut", "Edamame Segar, Bawang Putih Geprek, Garam Laut Alami"),
            Pair("Pisang Rai Bali Tabur Kelapa Parut", "Pisang Kepok Kuning, Tepung Beras, Kelapa Parut Kukus, Pandan"),
            Pair("Gado-Gado Roll Sehat Saus Kacang", "Selada Hijau, Tauge, Wortel Rebus, Tahu Kukus, Saus Kacang Mede"),
            Pair("Jagung Manis Serut Kelapa Muda Kukus", "Jagung Manis Pipil, Kelapa Parut Setengah Tua, Garam Laut"),
            Pair("Keripik Singkong Rempah Oven Non-Minyak", "Singkong Tipis, Kunyit Bubuk, Bawang Putih, Garam"),
            Pair("Tahu Kukus Isi Sayuran Ayam Cincang", "Tahu Putih, Daging Ayam Cincang, Wortel, Jamur Kuping, Daun Bawang"),
            Pair("Tempe Mendoan Sehat Airfryer Krispi", "Tempe Mendoan Tipis, Tepung Beras, Daun Bawang, Kunyit, Ketumbar"),
            Pair("Pepes Tahu Jamur Tiram Kemangi", "Tahu Putih Lumat, Jamur Tiram Suwir, Daun Kemangi, Cabai Rawit"),
            Pair("Lumpia Basah Sayur Rebung Semarang", "Kulit Lumpia Tipis, Rebung Segar Tumis, Tauge, Telur Orak-Arik"),
            Pair("Ubi Cilembu Panggang Madu Alami", "Ubi Jalar Cilembu Matang, Madu Alami, Kayu Manis Bubuk"),
            Pair("Keripik Pisang Kepok Rendah Minyak", "Pisang Kepok Mengkal, Garam Halus, Bawang Putih, Dipanggang Oven"),
            Pair("Salad Buah Tropis Saus Yoghurt Jeruk", "Pepaya, Melon, Semangka, Yoghurt Plain Kental, Perasan Jeruk"),
            Pair("Singkong Rebus Tabur Wijen & Gula Aren", "Singkong Pulen Merekat, Biji Wijen Sangrai, Gula Aren Sisir"),
            Pair("Bubur Kacang Hijau Rendah Gula Santan Encer", "Kacang Hijau Kupas, Jahe Merah, Daun Pandan, Santan Encer"),
            Pair("Kolak Labu Kuning Pisang Stevia", "Labu Kuning Manis, Pisang Kepok, Daun Pandan, Pemanis Alami"),
            Pair("Kroket Kentang Panggang Isi Sayuran", "Kentang Tumbuk Kukus, Wortel Dadu, Buncis, Seledri, Lada"),
            Pair("Siomay Tahu Kukus Bumbu Kacang Sehat", "Tahu Sutra, Ikan Tenggiri Giling, Labu Siam Parut, Daun Bawang"),
            Pair("Kerupuk Kulit Ikan Panggang Oven", "Kulit Ikan Tenggiri, Garam, Bawang Putih, Dipanggang Hingga Garing"),
            Pair("Bolu Kukus Gandum Pisang Kematangan", "Tepung Gandum Utuh, Pisang Ambon Sangat Matang, Telur, Kayu Manis"),
            Pair("Pancake Ubi Ungu Kukus Alami", "Ubi Ungu Kukus Lumat, Tepung Oat, Susu Almond, Madu Murni")
        )

        var idCounter = 406
        while (list.size < 100) {
            val template = healthySnacksList[(idCounter - 406) % healthySnacksList.size]
            val provName = listOf("Jawa Barat", "Jawa Tengah", "Jawa Timur", "Bali", "DKI Jakarta", "DI Yogyakarta", "Sumatera Barat", "Nusa Tenggara Barat", "Sulawesi Selatan", "Sumatera Utara")[idCounter % 10]
            val title = "${template.first} Khas Nusantara"
            val cook = 20 + ((idCounter * 3) % 25)
            val prep = 10 + ((idCounter * 2) % 15)
            val cal = 110 + ((idCounter * 7) % 80)

            val snackIngs = template.second.split(",").map { it.trim() }
            val sIng1 = "250 gr " + (snackIngs.firstOrNull() ?: "Bahan Camilan Pilihan")
            val sIng2 = if (snackIngs.size > 1) "50 gr ${snackIngs[1]}" else "1 butir Telur Ayam"
            val sIng3 = if (snackIngs.size > 2) "2 batang ${snackIngs[2]}" else "1 sdm Tepung Beras"

            list.add(
                RecipeEntity(
                    id = idCounter,
                    title = title,
                    category = "Camilan Sehat",
                    province = provName,
                    cookingTimeMinutes = cook,
                    prepTimeMinutes = prep,
                    difficulty = "Mudah",
                    servings = 4,
                    calories = cal,
                    protein = 5.0 + ((idCounter % 5) * 1.0),
                    carbs = 18.0 + ((idCounter % 5) * 2.5),
                    fat = 2.5 + ((idCounter % 4) * 0.8),
                    fiber = 3.5 + ((idCounter % 4) * 0.6),
                    dietTags = "Rendah Kalori, Bebas Lemak Trans, Halal, Kaya Serat, Sehat",
                    mainIngredients = template.second,
                    ingredients = """Bahan Camilan Segar:
$sIng1
$sIng2
$sIng3
Bumbu Alami Sehat:
3 siung bawang putih cincang halus
1/2 sdt ketumbar bubuk sangrai
1/2 sdt garam laut alami
1 sdt minyak kelapa / zaitun untuk memanggang""".trimIndent(),
                    instructions = """1. Cuci bersih dan siapkan seluruh bahan alami berkualitas.
2. Bumbui dengan rempah alami tanpa penyedap kimia buatan.
3. Masak dengan teknik sehat: kukus, panggang oven suhu sedang, atau air fryer.
4. Angkat saat matang renyah atau lembut empuk.
5. Nikmati camilan sehat khas nusantara bebas rasa bersalah.""".trimIndent(),
                    chefTips = "Metode memasak panggang oven atau kukus menjaga vitamin dan serat alami bahan tetap utuh tanpa menyerap minyak jenuh berbahaya.",
                    rating = 4.8,
                    reviewCount = 50 + (idCounter % 150),
                    iconBadge = "snack"
                )
            )
            idCounter++
        }

        return list
    }

    private data class DishBlueprint(
        val id: Int,
        val title: String,
        val province: String,
        val cookingTime: Int,
        val prepTime: Int,
        val difficulty: String,
        val servings: Int,
        val calories: Int,
        val protein: Double,
        val carbs: Double,
        val fat: Double,
        val fiber: Double,
        val dietTags: String,
        val mainIngredients: String,
        val ingredients: String,
        val instructions: String,
        val chefTips: String,
        val iconBadge: String
    ) {
        fun toEntity(category: String): RecipeEntity {
            return RecipeEntity(
                id = id,
                title = title,
                category = category,
                province = province,
                cookingTimeMinutes = cookingTime,
                prepTimeMinutes = prepTime,
                difficulty = difficulty,
                servings = servings,
                calories = calories,
                protein = protein,
                carbs = carbs,
                fat = fat,
                fiber = fiber,
                dietTags = dietTags,
                mainIngredients = mainIngredients,
                ingredients = ingredients,
                instructions = instructions,
                chefTips = chefTips,
                isFavorite = false,
                rating = 4.9,
                reviewCount = 180,
                iconBadge = iconBadge
            )
        }
    }
}
