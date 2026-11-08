package com.example.startechcomputer.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.startechcomputer.data.OrderUiState

import com.example.startechcomputer.ui.components.formatRupiah

@Composable
fun OrderSummaryScreen(

    orderUiState: OrderUiState,

    onCancelButtonClicked: () -> Unit,

    onShareButtonClicked: () -> Unit,

    modifier: Modifier = Modifier

) {

    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Column {

            Text(
                text = "RINGKASAN PESANAN",

                style = MaterialTheme.typography.headlineSmall,

                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))


            SummaryItem(
                "Prosesor",
                orderUiState.processor?.name,
                orderUiState.processor?.price
            )

            SummaryItem(
                "Hardisk / SSD",
                orderUiState.storage?.name,
                orderUiState.storage?.price
            )

            SummaryItem(
                "Ukuran Monitor",
                orderUiState.monitor?.name,
                orderUiState.monitor?.price
            )

            SummaryItem(
                "Kartu Grafis (VGA)",
                orderUiState.graphics?.name,
                orderUiState.graphics?.price
            )


            Spacer(modifier = Modifier.height(16.dp))

            Divider()

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "TOTAL PERKIRAAN HARGA",

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold
            )

            Text(
                text = formatRupiah(orderUiState.totalPrice),

                style = MaterialTheme.typography.headlineMedium,

                color = MaterialTheme.colorScheme.primary,

                fontWeight = FontWeight.Bold
            )


            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Terima kasih telah menggunakan " +
                        "layanan STARTECH COMPUTER.",

                style = MaterialTheme.typography.bodySmall
            )
        }


        Column {

            Button(

                onClick = onShareButtonClicked,

                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Bagikan Ringkasan")
            }


            OutlinedButton(

                onClick = onCancelButtonClicked,

                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Buat Konfigurasi Baru")
            }
        }
    }
}


// Menampilkan rincian setiap komponen
@Composable
private fun SummaryItem(

    label: String,

    value: String?,

    price: Long?

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)

    ) {

        Text(
            text = label,

            fontWeight = FontWeight.Bold
        )

        Text(
            text = value ?: "Belum dipilih"
        )

        if (price != null) {

            Text(
                text = formatRupiah(price),

                color = MaterialTheme.colorScheme.primary
            )
        }

        Divider(
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}