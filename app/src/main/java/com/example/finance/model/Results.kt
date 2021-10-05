package com.example.finance.model

import java.io.Serializable

data class Results(
    val available_sources: List<String>?,
    val currencies: Currencies?,
    val stocks: Stocks?,
    val taxes: List<Any>?
): Serializable