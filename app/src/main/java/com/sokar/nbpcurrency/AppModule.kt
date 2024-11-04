package com.sokar.nbpcurrency
import com.sokar.nbpcurrency.data.network.RetrofitInstance
import com.sokar.nbpcurrency.data.repository.ExchangeRatesRepository
import com.sokar.nbpcurrency.domain.repository.ExchangeRatesRepositoryImpl
import com.sokar.nbpcurrency.utils.DispatcherProvider
import com.sokar.nbpcurrency.utils.DispatcherProviderImpl
import com.sokar.nbpcurrency.viewmodel.CurrencyViewModel
import org.koin.dsl.module

val appModule =
    module {
        single<DispatcherProvider> { DispatcherProviderImpl() }

        single { RetrofitInstance.exchangeRatesApiService }

        single<ExchangeRatesRepository> { ExchangeRatesRepositoryImpl(get()) }

        factory { CurrencyViewModel(get(), get()) }
    }
