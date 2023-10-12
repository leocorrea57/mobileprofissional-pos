package com.example.bottommenulayout.model

import java.math.BigDecimal

data class OrderItem(
    var nome: String,
    var descricao: String,
    var categoria: String,
    var quantidade: Int,
    var valor: BigDecimal
)
