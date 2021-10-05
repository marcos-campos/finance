package com.example.finance.model

import java.io.Serializable

data class QuotationResponse(
    val `by`: String?,
    val execution_time: Double?,
    val from_cache: Boolean?,
    val results: Results?,
    val valid_key: Boolean?
): Serializable