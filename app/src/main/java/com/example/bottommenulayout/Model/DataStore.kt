package com.example.bottommenulayout.Model

import java.math.BigDecimal

object DataStore {

    var restaurantes: MutableList<Restaurante> = arrayListOf()
    var pedidos: MutableList<Order> = arrayListOf()
    var id: Int = 0

    init {
        val item1 = OrderItem(
            "Calabresa Grande",
            "Pizza grande 8 fatias, massa tradicional, recheio calabresa",
            CategoriasPizzaria.SALGADAS,
            1,
            BigDecimal(49.99)
        )
        val item2 = OrderItem(
            "Brigadeiro Grande",
            "Pizza grande 8 fatias, massa tradicional, recheio brigadeiro",
            CategoriasPizzaria.DOCES,
            1,
            BigDecimal(59.99)
        )

        pedidos.add(Order(1000, listOf(item1, item2), true))
        pedidos.add(Order(1001, listOf(item1, item1), true))
        pedidos.add(Order(1002, listOf(item1, item1), true))
        pedidos.add(Order(1003, listOf(item1, item1), true))
        pedidos.add(Order(1004, listOf(item1, item1), true))
        pedidos.add(Order(1005, listOf(item2, item2), false))
        pedidos.add(Order(1006, listOf(item1), false))
        pedidos.add(Order(1007, listOf(item2), false))
        pedidos.add(Order(1008, listOf(item2), false))
        pedidos.add(Order(1009, listOf(item2), false))
    }

    fun addRestaurante(rest: Restaurante) {
        id++
        restaurantes.add(rest)
    }

    fun getRestaurante(at: Int): Restaurante {
        return restaurantes[at]
    }

    fun setLists(list: MutableList<Restaurante>) {
        restaurantes = list
//        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)

        // creating a variable for editor to
//        // store data in shared preferences.
//        val editor = sharedPreferences.edit()
//        val gson = Gson()
//        val json = gson.toJson(list)//converting list to Json
//        editor.putString("LIST",json)
//        editor.commit()
    }

}