package com.sokar.nbpcurrency.domain.repository

import com.sokar.nbpcurrency.data.enums.TableEnum
import com.sokar.nbpcurrency.data.model.ExchangeRatesTable
import com.sokar.nbpcurrency.data.network.services.ExchangeRatesApiService
import com.sokar.nbpcurrency.data.repository.ExchangeRatesRepository

class ExchangeRatesRepositoryImpl(
    private val exchangeRatesApiService: ExchangeRatesApiService,
) : ExchangeRatesRepository {
    override suspend fun getExchangeRates(
        table: TableEnum,
        currency: String,
    ): ExchangeRatesTable = exchangeRatesApiService.getExchangeRates(table, currency)
}
