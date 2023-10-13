package com.example.bottommenulayout.model

import java.math.BigDecimal

class Order(
    var numero: Int,
    var itens: List<OrderItem>,
    var status: Boolean,

    ) {

    val valorTotal: BigDecimal
        get() = itens.sumOf { it.valorTotalItem }

    val totalItens: Int
        get() = itens.sumOf { it.quantidade }
}
