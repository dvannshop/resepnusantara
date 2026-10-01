package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.viewmodel.SortOrder

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterBottomSheet(
    selectedCategory: String,
    selectedProvince: String?,
    selectedDietTag: String?,
    selectedIngredient: String?,
    sortOrder: SortOrder,
    onCategorySelect: (String) -> Unit,
    onProvinceSelect: (String?) -> Unit,
    onDietTagSelect: (String?) -> Unit,
    onIngredientSelect: (String?) -> Unit,
    onSortSelect: (SortOrder) -> Unit,
    onReset: () -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val provincesList = listOf(
        "Semua Provinsi", "Sumatera Barat", "DKI Jakarta", "Jawa Barat", "Jawa Tengah",
        "DI Yogyakarta", "Jawa Timur", "Bali", "Sumatera Utara", "Aceh",
        "Sulawesi Selatan", "Sulawesi Utara", "Nusa Tenggara Barat", "Nusa Tenggara Timur",
        "Papua", "Kalimantan Selatan", "Kalimantan Barat", "Kalimantan Timur",
        "Sumatera Selatan", "Riau", "Bangka Belitung", "Lampung", "Maluku"
    )

    val dietTagsList = listOf(
        "Semua Diet",
        "Rendah Kalori (<300 kkal)",
        "Tinggi Protein",
        "Bebas Gluten",
        "Vegetarian",
        "Ramah Diabetes",
        "Kaya Serat"
    )

    val mainIngredientsList = listOf(
        "Semua Bahan", "Daging Sapi", "Ayam", "Ikan", "Tempe",
        "Tahu", "Pisang", "Jagung", "Santan", "Telur"
    )

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Filter & Urutkan Resep",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                IconButton(onClick = onDismiss) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Tutup")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 1. Kategori Kuliner
            SectionTitle(title = "Kategori Kuliner Nusantara")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Semua", "Makanan Utama", "Cake & Kue", "Minuman", "Camilan Sehat").forEach { cat ->
                    val isSelected = selectedCategory == cat
                    FilterChip(
                        selected = isSelected,
                        onClick = { onCategorySelect(cat) },
                        label = { Text(cat) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Batasan Diet & Kalori
            SectionTitle(title = "Batasan Diet & Target Nutrisi")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                dietTagsList.forEach { tag ->
                    val isSelected = if (tag == "Semua Diet") selectedDietTag == null else selectedDietTag == tag
                    FilterChip(
                        selected = isSelected,
                        onClick = { onDietTagSelect(if (tag == "Semua Diet") null else tag) },
                        label = { Text(tag) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 3. Pencarian Berdasarkan Bahan Utama
            SectionTitle(title = "Pencarian Berdasarkan Bahan Utama")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                mainIngredientsList.forEach { ing ->
                    val isSelected = if (ing == "Semua Bahan") selectedIngredient == null else selectedIngredient == ing
                    FilterChip(
                        selected = isSelected,
                        onClick = { onIngredientSelect(if (ing == "Semua Bahan") null else ing) },
                        label = { Text(ing) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 4. Kategori Per Provinsi
            SectionTitle(title = "Asal Daerah / Provinsi")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                provincesList.forEach { prov ->
                    val isSelected = if (prov == "Semua Provinsi") selectedProvince == null else selectedProvince == prov
                    FilterChip(
                        selected = isSelected,
                        onClick = { onProvinceSelect(if (prov == "Semua Provinsi") null else prov) },
                        label = { Text(prov) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 5. Urutkan Berdasarkan
            SectionTitle(title = "Urutkan Berdasarkan")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SortOrder.values().forEach { order ->
                    FilterChip(
                        selected = sortOrder == order,
                        onClick = { onSortSelect(order) },
                        label = { Text(order.label) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bottom Buttons: Reset & Apply
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onReset,
                    modifier = Modifier.weight(1f).testTag("btn_reset_filter"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(imageVector = Icons.Default.RestartAlt, contentDescription = null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Reset")
                }

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.weight(1f).testTag("btn_apply_filter"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Terapkan")
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}
