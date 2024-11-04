package com.sokar.nbpcurrency.data.states

import com.sokar.nbpcurrency.data.model.ExchangeRatesTable

sealed class ExchangeRatesState {
    data object Loading : ExchangeRatesState()

    data class Success(
        val table: ExchangeRatesTable,
    ) : ExchangeRatesState()

    data class Error(
        val error: Exception,
    ) : ExchangeRatesState()

    data object Idle : ExchangeRatesState()
}
