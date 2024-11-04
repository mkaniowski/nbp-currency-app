package com.sokar.nbpcurrency.data.network.services

import com.sokar.nbpcurrency.data.model.ExchangeRatesTable
import retrofit2.http.GET

interface ExchangeRatesApiService {
    // TODO Create GET request (exchangerates/rates/{table}/{currency}/) with two path parameters (table and currency)
    @GET("")
    suspend fun getExchangeRates(): ExchangeRatesTable
}
