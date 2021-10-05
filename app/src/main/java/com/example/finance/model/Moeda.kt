package com.example.finance.model

import java.io.Serializable

data class Moeda(val nome: String,
                 val compra: String,
                 val venda: String,
                 val variacao: String
): Serializable
