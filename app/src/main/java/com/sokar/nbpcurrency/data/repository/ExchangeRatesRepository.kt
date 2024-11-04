package com.sokar.nbpcurrency.data.repository

import com.sokar.nbpcurrency.data.enums.TableEnum
import com.sokar.nbpcurrency.data.model.ExchangeRatesTable

interface ExchangeRatesRepository {
    suspend fun getExchangeRates(
        table: TableEnum,
        currency: String,
    ): ExchangeRatesTable
}
