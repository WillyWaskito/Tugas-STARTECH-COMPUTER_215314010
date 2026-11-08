package com.example.startechcomputer

import android.content.Context
import android.content.Intent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.startechcomputer.data.DataSource
import com.example.startechcomputer.data.OrderUiState

import com.example.startechcomputer.ui.OrderViewModel
import com.example.startechcomputer.ui.StartOrderScreen
import com.example.startechcomputer.ui.SelectOptionScreen
import com.example.startechcomputer.ui.OrderSummaryScreen


// Daftar halaman aplikasi
enum class StartechScreen(val title: String) {

    Start("STARTECH COMPUTER"),

    Processor("Pilih Prosesor"),

    Storage("Pilih Hardisk / SSD"),

    Monitor("Pilih Ukuran Monitor"),

    Graphics("Pilih Kartu Grafis"),

    Summary("Ringkasan Pesanan")
}


// Top App Bar
@Composable
fun StartechAppBar(

    currentScreen: StartechScreen,

    canNavigateBack: Boolean,

    navigateUp: () -> Unit

) {

    TopAppBar(

        title = {
            Text(currentScreen.title)
        },

        colors = TopAppBarDefaults.mediumTopAppBarColors(

            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        ),

        navigationIcon = {

            if (canNavigateBack) {

                IconButton(onClick = navigateUp) {

                    Icon(

                        imageVector = Icons.Filled.ArrowBack,

                        contentDescription = "Kembali"
                    )
                }
            }
        }
    )
}


// Aplikasi utama
@Composable
fun StartechApp(

    viewModel: OrderViewModel = viewModel(),

    navController: NavHostController = rememberNavController()

) {

    // Mengambil halaman yang sedang aktif
    val backStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry?.destination?.route
            ?: StartechScreen.Start.name

    val currentScreen =
        StartechScreen.values().firstOrNull {
            it.name == currentRoute
        } ?: StartechScreen.Start


    Scaffold(

        topBar = {

            StartechAppBar(

                currentScreen = currentScreen,

                canNavigateBack =
                    navController.previousBackStackEntry != null,

                navigateUp = {
                    navController.navigateUp()
                }
            )
        }

    ) { innerPadding ->


        // Mengambil data pilihan dari ViewModel
        val uiState by viewModel.uiState.collectAsState()


        // Navigation Host
        NavHost(

            navController = navController,

            startDestination = StartechScreen.Start.name,

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {


            // HALAMAN BERANDA
            composable(
                route = StartechScreen.Start.name
            ) {

                StartOrderScreen(

                    onNextButtonClicked = {

                        navController.navigate(
                            StartechScreen.Processor.name
                        )
                    }
                )
            }


            // HALAMAN PROSESOR
            composable(
                route = StartechScreen.Processor.name
            ) {

                SelectOptionScreen(

                    options = DataSource.processors,

                    selectedOption = uiState.processor,

                    totalPrice = uiState.totalPrice,

                    onSelectionChanged = {
                        viewModel.setProcessor(it)
                    },

                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },

                    onNextButtonClicked = {

                        navController.navigate(
                            StartechScreen.Storage.name
                        )
                    }
                )
            }


            // HALAMAN HARDISK / SSD
            composable(
                route = StartechScreen.Storage.name
            ) {

                SelectOptionScreen(

                    options = DataSource.storage,

                    selectedOption = uiState.storage,

                    totalPrice = uiState.totalPrice,

                    onSelectionChanged = {
                        viewModel.setStorage(it)
                    },

                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },

                    onNextButtonClicked = {

                        navController.navigate(
                            StartechScreen.Monitor.name
                        )
                    }
                )
            }


            // HALAMAN MONITOR
            composable(
                route = StartechScreen.Monitor.name
            ) {

                SelectOptionScreen(

                    options = DataSource.monitors,

                    selectedOption = uiState.monitor,

                    totalPrice = uiState.totalPrice,

                    onSelectionChanged = {
                        viewModel.setMonitor(it)
                    },

                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },

                    onNextButtonClicked = {

                        navController.navigate(
                            StartechScreen.Graphics.name
                        )
                    }
                )
            }


            // HALAMAN VGA
            composable(
                route = StartechScreen.Graphics.name
            ) {

                SelectOptionScreen(

                    options = DataSource.graphics,

                    selectedOption = uiState.graphics,

                    totalPrice = uiState.totalPrice,

                    onSelectionChanged = {
                        viewModel.setGraphics(it)
                    },

                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },

                    nextButtonText = "Lihat Ringkasan",

                    onNextButtonClicked = {

                        navController.navigate(
                            StartechScreen.Summary.name
                        )
                    }
                )
            }


            // HALAMAN RINGKASAN
            composable(
                route = StartechScreen.Summary.name
            ) {

                val context = LocalContext.current

                OrderSummaryScreen(

                    orderUiState = uiState,

                    onCancelButtonClicked = {

                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },

                    onShareButtonClicked = {

                        shareConfiguration(
                            context,
                            uiState
                        )
                    }
                )
            }
        }
    }
}


// Membatalkan konfigurasi
private fun cancelOrderAndNavigateToStart(

    viewModel: OrderViewModel,

    navController: NavHostController

) {

    viewModel.resetOrder()

    navController.popBackStack(

        StartechScreen.Start.name,

        inclusive = false
    )
}


// Membagikan ringkasan konfigurasi
private fun shareConfiguration(

    context: Context,

    state: OrderUiState

) {

    val summary = buildString {

        appendLine("STARTECH COMPUTER")
        appendLine("RINGKASAN KONFIGURASI")
        appendLine()

        appendLine(
            "Prosesor: ${state.processor?.name}"
        )

        appendLine(
            "Hardisk/SSD: ${state.storage?.name}"
        )

        appendLine(
            "Monitor: ${state.monitor?.name}"
        )

        appendLine(
            "VGA: ${state.graphics?.name}"
        )

        appendLine()

        appendLine(
            "TOTAL HARGA: Rp${state.totalPrice}"
        )
    }


    val intent = Intent(Intent.ACTION_SEND).apply {

        type = "text/plain"

        putExtra(
            Intent.EXTRA_SUBJECT,
            "Pesanan STARTECH COMPUTER"
        )

        putExtra(
            Intent.EXTRA_TEXT,
            summary
        )
    }


    context.startActivity(

        Intent.createChooser(

            intent,

            "Bagikan konfigurasi"
        )
    )
}