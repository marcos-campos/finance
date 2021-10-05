package com.example.finance.model

import java.io.Serializable

data class JPY(
    val buy: Double?,
    val name: String?,
    val sell: Any?,
    val variation: Double?
): Serializable