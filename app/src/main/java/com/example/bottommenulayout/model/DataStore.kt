package com.example.bottommenulayout.model

import java.math.BigDecimal

object DataStore {
    var pedidos: MutableList<Order> = arrayListOf()
    var itensPedido: MutableList<OrderItem> = arrayListOf()

    var id: Int = 0

    init {
        loadMockItens()
        loadMockOrders()
    }

    fun setLists(list: MutableList<Restaurante>) {
//        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)

        // creating a variable for editor to
//        // store data in shared preferences.
//        val editor = sharedPreferences.edit()
//        val gson = Gson()
//        val json = gson.toJson(list)//converting list to Json
//        editor.putString("LIST",json)
//        editor.commit()
    }

    fun loadMockOrders() {
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

    fun loadMockItens() {
        itensPedido.add(
            OrderItem(
                nome = "Calabresa Grande",
                descricao = "Pizza grande 8 fatias, massa tradicional, recheio calabresa",
                categoria = CategoriasPizzaria.SALGADAS,
                quantidade = 1,
                valor = BigDecimal(49.99)
            )
        )
        itensPedido.add(
            OrderItem(
                nome = "Brigadeiro pequena",
                descricao = "Pizza de 4 fatias, massa tradicional, recheio brigadeiro",
                categoria = CategoriasPizzaria.DOCES,
                quantidade = 1,
                valor = BigDecimal(59.99)
            )
        )
        itensPedido.add(
            OrderItem(
                nome = "Refrigerante 2L",
                descricao = "Coca cola, Guaraná, Fanta, Pepsi, Soda",
                categoria = CategoriasPizzaria.BEBIDAS,
                quantidade = 1,
                valor = BigDecimal(12.00)
            )
        )
    }


}