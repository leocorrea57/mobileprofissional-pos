package com.example.bottommenulayout.model

import java.math.BigDecimal

data class OrderItem(
    var quantidade: Int,
    var foodMenuItem: FoodMenuItem
) {

    val valorTotalItem: BigDecimal
        get() = foodMenuItem.valor * quantidade.toBigDecimal()
}

