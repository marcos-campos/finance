package com.example.finance.model

import java.io.Serializable

data class GBP(
    val buy: Double?,
    val name: String?,
    val sell: Any?,
    val variation: Double?
): Serializable