package com.sokar.nbpcurrency.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Rate(
    val no: String,
    val effectiveDate: String,
    val mid: Double,
)
