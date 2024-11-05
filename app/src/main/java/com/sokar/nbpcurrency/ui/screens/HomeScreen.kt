package com.sokar.nbpcurrency.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sokar.nbpcurrency.R
import com.sokar.nbpcurrency.data.enums.TableEnum
import com.sokar.nbpcurrency.data.states.ExchangeRatesState
import com.sokar.nbpcurrency.ui.components.CurrencyDropdown
import com.sokar.nbpcurrency.viewmodel.CurrencyViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    currencyViewModel: CurrencyViewModel = koinViewModel(),
) {
    val currencies = stringArrayResource(id = R.array.currencies).toList()
    val selectedCurrency = remember { mutableStateOf(currencies[0]) }

    val exchangeRatesState by currencyViewModel.exchangeRatesCurrencyState.collectAsState()

    Column(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            CurrencyDropdown(
                modifier = modifier,
                selectedValue = selectedCurrency.value,
                options = currencies,
                label = "Currency",
                onValueChangedEvent = {
                    selectedCurrency.value = it
                    currencyViewModel.setExchangeRatesState(ExchangeRatesState.Idle)
                },
            )

            Button(onClick = {
                currencyViewModel.getCurrencyExchangeRates(
                    TableEnum.A,
                    selectedCurrency.value,
                )
            }) {
                Text(text = "Get Exchange Rates")
            }
        }

        Column(
            modifier = modifier.fillMaxWidth().padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            when (exchangeRatesState) {
                is ExchangeRatesState.Loading -> {
                    Text(
                        modifier = modifier,
                        text = "Loading...",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                }

                is ExchangeRatesState.Success -> {
                    val exchangeRates =
                        (exchangeRatesState as ExchangeRatesState.Success).table.rates[0].mid
                    Text(
                        modifier = modifier,
                        text = "${selectedCurrency.value}: $exchangeRates",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                }

                is ExchangeRatesState.Error -> {
                    val error = (exchangeRatesState as ExchangeRatesState.Error).error
                    Text(
                        modifier = modifier,
                        text = "Error: ${error.message}",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                }

                ExchangeRatesState.Idle -> {
                    Text(
                        modifier = modifier,
                        text = "Press the button to get exchange rates",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
