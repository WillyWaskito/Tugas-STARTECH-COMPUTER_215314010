/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.startechcomputer.data

data class OrderUiState(

    val processor: ComponentOption? = null,

    val storage: ComponentOption? = null,

    val monitor: ComponentOption? = null,

    val graphics: ComponentOption? = null

) {

    // Menghitung keseluruhan harga komponen
    val totalPrice: Long
        get() =
            (processor?.price ?: 0L) +
                    (storage?.price ?: 0L) +
                    (monitor?.price ?: 0L) +
                    (graphics?.price ?: 0L)


    // Memeriksa apakah semua pilihan sudah lengkap
    val isComplete: Boolean
        get() =
            processor != null &&
                    storage != null &&
                    monitor != null &&
                    graphics != null
}