package com.example.bottommenulayout.model

import java.math.BigDecimal

class Restaurante(
    var nome : String,
    var id : Int,
    var tipo : String,
    var taxa: BigDecimal
)
{
    constructor(): this("",0,"", BigDecimal.ZERO)
}
