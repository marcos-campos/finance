package com.example.finance.model

import java.io.Serializable

data class IFIX(
    val location: String?,
    val name: String?,
    val points: Double?,
    val variation: Double?
): Serializable