package com.example.finance.model

import java.io.Serializable

data class NIKKEI(
    val location: String?,
    val name: String?,
    val points: Double?,
    val variation: Double?
): Serializable