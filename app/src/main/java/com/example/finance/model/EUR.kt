package com.example.finance.model

import java.io.Serializable

data class EUR(
    val buy: Double?,
    val name: String?,
    val sell: Double?,
    val variation: Double?
): Serializable