package com.example.finance.model

import java.io.Serializable

data class Currencies(
    val ARS: ARS?,
    val AUD: AUD?,
    val BTC: BTC?,
    val CAD: CAD?,
    val CNY: CNY?,
    val EUR: EUR?,
    val GBP: GBP?,
    val JPY: JPY?,
    val USD: USD?,
    val source: String?
): Serializable