package com.example.bottommenulayout.model

import java.math.BigDecimal

object DataStore {
    var pedidos: MutableList<Order> = arrayListOf()
    var itensPedido: MutableList<OrderItem> = arrayListOf()
    var cardapio: MutableList<FoodMenuItem> = arrayListOf()

    var id: Int = 0

    init {
        loadMockFoodMenu()
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

    private fun loadMockFoodMenu() {
        cardapio.add(
            FoodMenuItem(
                nome = "Calabresa Grande",
                descricao = "Pizza grande 8 fatias, massa tradicional, recheio calabresa",
                categoria = CategoriasPizzaria.SALGADAS,
                valor = BigDecimal(49.99)
            )
        )

        cardapio.add(
            FoodMenuItem(
                nome = "Brigadeiro pequena",
                descricao = "Pizza de 4 fatias, massa tradicional, recheio brigadeiro",
                categoria = CategoriasPizzaria.DOCES,
                valor = BigDecimal(59.99)
            )
        )

        cardapio.add(
            FoodMenuItem(
                nome = "Refrigerante 2L",
                descricao = "Coca cola, Guaraná, Fanta, Pepsi, Soda",
                categoria = CategoriasPizzaria.BEBIDAS,
                valor = BigDecimal(12.00)
            )
        )
    }

    private fun loadMockOrders() {
        pedidos.add(Order(1000, listOf(itensPedido[0], itensPedido[1]), true))
        pedidos.add(Order(1001, listOf(itensPedido[0], itensPedido[2]), true))
        pedidos.add(Order(1002, listOf(itensPedido[1], itensPedido[1]), true))
        pedidos.add(Order(1003, listOf(itensPedido[1], itensPedido[2]), true))
        pedidos.add(Order(1006, listOf(itensPedido[2], itensPedido[2]), false))
        pedidos.add(Order(1007, listOf(itensPedido[0]), false))
        pedidos.add(Order(1008, listOf(itensPedido[1]), false))
        pedidos.add(Order(1009, listOf(itensPedido[2]), false))
    }

    private fun loadMockItens() {
        itensPedido.add(
            OrderItem(
                quantidade = 2,
                foodMenuItem = cardapio[0]
            )
        )
        itensPedido.add(
            OrderItem(
                quantidade = 3,
                foodMenuItem = cardapio[1]
            )
        )
        itensPedido.add(
            OrderItem(
                quantidade = 1,
                foodMenuItem = cardapio[2]
            )
        )
    }


}