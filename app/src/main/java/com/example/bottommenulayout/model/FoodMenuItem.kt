package com.example.bottommenulayout.model

import java.math.BigDecimal

class FoodMenuItem(
    override var id: Int = 0,
    var nome: String,
    var descricao: String,
    var categoria: String,
    var valor: BigDecimal
) : ListItemObject() {
}
