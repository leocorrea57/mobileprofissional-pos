package com.example.bottommenulayout.model

import java.math.BigDecimal

data class OrderItem(
    override var id: Int = 0,
    var quantidade: Int,
    var foodMenuItem: FoodMenuItem
) : ListItemObject() {

    val valorTotalItem: BigDecimal
        get() = foodMenuItem.valor * quantidade.toBigDecimal()
}

