package com.example.finance.model

import java.io.Serializable

data class Stocks(
    val CAC: CAC?,
    val DOWJONES: DOWJONES?,
    val IBOVESPA: IBOVESPA?,
    val IFIX: IFIX?,
    val NASDAQ: NASDAQ?,
    val NIKKEI: NIKKEI?
): Serializable