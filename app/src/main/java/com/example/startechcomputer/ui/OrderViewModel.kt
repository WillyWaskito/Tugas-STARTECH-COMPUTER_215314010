package com.example.startechcomputer.ui

import androidx.lifecycle.ViewModel

import com.example.startechcomputer.data.ComponentOption
import com.example.startechcomputer.data.OrderUiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(OrderUiState())

    val uiState: StateFlow<OrderUiState> =
        _uiState.asStateFlow()


    // Memilih prosesor
    fun setProcessor(option: ComponentOption) {

        _uiState.update { currentState ->

            currentState.copy(
                processor = option
            )
        }
    }


    // Memilih HDD atau SSD
    fun setStorage(option: ComponentOption) {

        _uiState.update { currentState ->

            currentState.copy(
                storage = option
            )
        }
    }


    // Memilih monitor
    fun setMonitor(option: ComponentOption) {

        _uiState.update { currentState ->

            currentState.copy(
                monitor = option
            )
        }
    }


    // Memilih VGA
    fun setGraphics(option: ComponentOption) {

        _uiState.update { currentState ->

            currentState.copy(
                graphics = option
            )
        }
    }


    // Menghapus seluruh pilihan
    fun resetOrder() {

        _uiState.value = OrderUiState()
    }
}