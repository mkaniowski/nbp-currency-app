package com.sokar.nbpcurrency.data.network.services

import com.sokar.nbpcurrency.data.enums.TableEnum
import com.sokar.nbpcurrency.data.model.ExchangeRatesTable
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRatesApiService {
    @GET("exchangerates/rates/{table}/{currency}/")
    suspend fun getExchangeRates(
        @Path("table") table: TableEnum,
        @Path("currency") currency: String,
    ): ExchangeRatesTable
}
