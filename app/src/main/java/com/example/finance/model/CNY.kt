package com.example.finance.model

import java.io.Serializable

data class CNY(
    val buy: Double?,
    val name: String?,
    val sell: Any?,
    val variation: Double?
): Serializable