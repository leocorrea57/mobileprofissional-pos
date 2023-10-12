package com.example.bottommenulayout.Model

import java.math.BigDecimal

class Order(
    var numero: Int,
    var itens: List<OrderItem>,
    var status: Boolean,

    ) {

    val valorTotal: BigDecimal
        get() = itens.sumOf { it.valor }

    val totalItens: Int
        get() = itens.sumOf { it.quantidade }
}