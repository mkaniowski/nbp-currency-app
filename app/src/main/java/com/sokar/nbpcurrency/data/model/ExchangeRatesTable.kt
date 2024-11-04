package com.sokar.nbpcurrency.data.model

import com.sokar.nbpcurrency.data.enums.TableEnum
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRatesTable(
    val table: TableEnum,
    val currency: String,
    val code: String,
    val rates: List<Rate>,
)
