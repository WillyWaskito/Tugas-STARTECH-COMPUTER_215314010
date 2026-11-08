package com.example.startechcomputer.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.selection.selectable

import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.startechcomputer.data.ComponentOption
import com.example.startechcomputer.data.DataSource
import com.example.startechcomputer.ui.components.formatRupiah
import com.example.startechcomputer.ui.theme.CupcakeTheme
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SelectOptionScreen(

    options: List<ComponentOption>,

    selectedOption: ComponentOption?,

    totalPrice: Long,

    onSelectionChanged: (ComponentOption) -> Unit,

    onCancelButtonClicked: () -> Unit,

    onNextButtonClicked: () -> Unit,

    nextButtonText: String = "Lanjut",

    modifier: Modifier = Modifier

) {

    var selectedName by rememberSaveable(selectedOption?.name) {

        mutableStateOf(
            selectedOption?.name.orEmpty()
        )
    }

    Column(

        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),

        verticalArrangement = Arrangement.SpaceBetween

    ) {

        // Daftar pilihan komponen
        Column(

            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())

        ) {

            options.groupBy { it.group }.forEach { (groupName, groupedOptions) ->

                Text(
                    text = groupName,

                    fontWeight = FontWeight.Bold,

                    style = MaterialTheme.typography.titleMedium,

                    modifier = Modifier.padding(
                        top = 12.dp,
                        bottom = 6.dp
                    )
                )

                groupedOptions.forEach { option ->

                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(

                                selected = selectedName == option.name,

                                onClick = {

                                    selectedName = option.name

                                    onSelectionChanged(option)
                                },

                                role = Role.RadioButton
                            )
                            .padding(vertical = 4.dp),

                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        RadioButton(

                            selected = selectedName == option.name,

                            onClick = {

                                selectedName = option.name

                                onSelectionChanged(option)
                            }
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        ) {

                            Text(
                                text = option.name,

                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = formatRupiah(option.price),

                                fontWeight = FontWeight.Bold,

                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

                Divider(
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }


        // Harga sementara
        Column {

            Text(
                text = "Estimasi Harga Sementara",

                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = formatRupiah(totalPrice),

                fontWeight = FontWeight.Bold,

                style = MaterialTheme.typography.headlineSmall
            )


            // Tombol navigasi
            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),

                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                OutlinedButton(

                    onClick = onCancelButtonClicked,

                    modifier = Modifier.weight(1f)
                ) {

                    Text("Batal")
                }


                Button(

                    onClick = onNextButtonClicked,

                    enabled = selectedName.isNotEmpty(),

                    modifier = Modifier.weight(1f)
                ) {

                    Text(nextButtonText)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectOptionScreenPreview() {
    CupcakeTheme {
        SelectOptionScreen(
            options = DataSource.processors,
            selectedOption = DataSource.processors[0],
            totalPrice = 1_000_000,
            onSelectionChanged = {},
            onCancelButtonClicked = {},
            onNextButtonClicked = {}
        )
    }
}