package com.example.bottommenulayout.model

import java.math.BigDecimal

class Order(
    override var id: Int = 0,
    var itens: List<OrderItem>,
    var status: Boolean,

    ) : ListItemObject() {

    val valorTotal: BigDecimal
        get() = itens.sumOf { it.valorTotalItem }

    val totalItens: Int
        get() = itens.sumOf { it.quantidade }
}
