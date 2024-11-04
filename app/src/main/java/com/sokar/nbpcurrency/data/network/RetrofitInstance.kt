package com.sokar.nbpcurrency.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitInstance {
    private const val BASE_URL = ""

    private val okHttpClient: OkHttpClient =
        TODO("Create an OkHttpClient instance with a logging interceptor and a timeout of 60 seconds")

    private val retrofit: Retrofit =
        TODO("Create a Retrofit instance with a base URL and a Gson converter factory")

    val exchangeRatesApiService =
        TODO("Create an instance of the ExchangeRatesApiService interface")
}
