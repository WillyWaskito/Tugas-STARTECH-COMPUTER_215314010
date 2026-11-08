package com.example.startechcomputer.ui.components

import java.text.NumberFormat
import java.util.Locale

// Mengubah angka menjadi format mata uang Rupiah
fun formatRupiah(amount: Long): String {

    val formatter =
        NumberFormat.getCurrencyInstance(
            Locale("id", "ID")
        )

    formatter.maximumFractionDigits = 0

    formatter.minimumFractionDigits = 0

    return formatter.format(amount)
}