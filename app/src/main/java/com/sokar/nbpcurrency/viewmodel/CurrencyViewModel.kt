package com.sokar.nbpcurrency.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sokar.nbpcurrency.data.enums.TableEnum
import com.sokar.nbpcurrency.data.repository.ExchangeRatesRepository
import com.sokar.nbpcurrency.data.states.ExchangeRatesState
import com.sokar.nbpcurrency.utils.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val exchangeRatesRepository: ExchangeRatesRepository,
    private val dispatcherProvider: DispatcherProvider,
) : ViewModel() {
    private val _exchangeRatesCurrencyState = MutableStateFlow<ExchangeRatesState>(ExchangeRatesState.Idle)
    val exchangeRatesCurrencyState: StateFlow<ExchangeRatesState> = _exchangeRatesCurrencyState

    fun setExchangeRatesState(state: ExchangeRatesState) {
        _exchangeRatesCurrencyState.value = state
    }

    fun getCurrencyExchangeRates(
        table: TableEnum,
        currency: String,
    ) {
        _exchangeRatesCurrencyState.value = ExchangeRatesState.Loading

        viewModelScope.launch(dispatcherProvider.io()) {
            try {
                TODO("Implement getCurrencyExchangeRates, use repository")
            } catch (e: Exception) {
                TODO("Implement getCurrencyExchangeRates, set error state")
            }
        }
    }
}
