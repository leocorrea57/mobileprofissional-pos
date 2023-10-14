package com.example.bottommenulayout.model

import java.math.BigDecimal

object DataStore {
    var orders: MutableList<Order> = arrayListOf()
    var orderItems: MutableList<OrderItem> = arrayListOf()
    var foodMenu: MutableList<FoodMenuItem> = arrayListOf()

    var id: Int = 0

    init {
        loadMockFoodMenu()
        loadMockItens()
        loadMockOrders()
    }

    private fun loadMockFoodMenu() {
        addFoodMenuItem(
            FoodMenuItem(
                nome = "Calabresa Grande",
                descricao = "Pizza grande 8 fatias, massa tradicional, recheio calabresa",
                categoria = CategoriasPizzaria.SALGADAS,
                valor = BigDecimal(49.99)
            )
        )

        addFoodMenuItem(
            FoodMenuItem(
                nome = "Brigadeiro pequena",
                descricao = "Pizza de 4 fatias, massa tradicional, recheio brigadeiro",
                categoria = CategoriasPizzaria.DOCES,
                valor = BigDecimal(59.99)
            )
        )

        addFoodMenuItem(
            FoodMenuItem(
                nome = "Refrigerante 2L",
                descricao = "Coca cola, Guaraná, Fanta, Pepsi, Soda",
                categoria = CategoriasPizzaria.BEBIDAS,
                valor = BigDecimal(12.00)
            )
        )
    }

    private fun loadMockOrders() {
        orders.add(Order(id = autoIncrementId(orders), listOf(orderItems[0], orderItems[1]), true))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[0], orderItems[2]), true))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[1], orderItems[1]), true))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[1], orderItems[2]), true))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[2], orderItems[2]), false))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[0]), false))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[1]), false))
        orders.add(Order(autoIncrementId(orders), listOf(orderItems[2]), false))
    }

    private fun loadMockItens() {
        orderItems.add(
            OrderItem(
                id = autoIncrementId(orderItems),
                quantidade = 2,
                foodMenuItem = foodMenu[0]
            )
        )
        orderItems.add(
            OrderItem(
                id = autoIncrementId(orderItems),
                quantidade = 3,
                foodMenuItem = foodMenu[1]
            )
        )
        orderItems.add(
            OrderItem(
                id = autoIncrementId(orderItems),
                quantidade = 1,
                foodMenuItem = foodMenu[2]
            )
        )
    }

    private fun autoIncrementId(list: List<ListItemObject>): Int {
        var lastId = 0

        list.forEach {
            if (it.id > lastId) lastId = it.id
        }
        lastId += 1
        return lastId
    }


    fun addFoodMenuItem(item: FoodMenuItem): Boolean {
        item.id = autoIncrementId(foodMenu)
        foodMenu.add(item)
        return true
    }

    fun editFoodMenuItem(updatedItem: FoodMenuItem): Boolean {
        foodMenu.firstOrNull { updatedItem.id == it.id }?.let {
            it.valor = updatedItem.valor
            it.categoria = updatedItem.categoria
            it.nome = updatedItem.nome
            it.descricao = updatedItem.descricao
            return true
        }
        return false
    }

    fun deleteFoodMenuItem(id: Int): Boolean {
        foodMenu.firstOrNull { id == it.id }?.let {
            foodMenu.remove(it)
            return true
        }
        return false
    }
}