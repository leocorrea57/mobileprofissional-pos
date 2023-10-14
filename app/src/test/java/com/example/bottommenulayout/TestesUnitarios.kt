package com.example.bottommenulayout

import com.example.bottommenulayout.model.*
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.math.BigDecimal

class TestesUnitarios {

    private val itemCardapio1 = FoodMenuItem(
        id = 1,
        nome = "Pizza de calabresa",
        descricao = "Pizza salgada de 8 fatias",
        categoria = CategoriasPizzaria.SALGADAS,
        valor = BigDecimal.TEN
    )

    private val itemCardapio2 = FoodMenuItem(
        id = 2,
        nome = "Pizza de Frango",
        descricao = "Pizza salgada de 8 fatias",
        categoria = CategoriasPizzaria.SALGADAS,
        valor = BigDecimal.TEN
    )

    private val itemCardapio3 = FoodMenuItem(
        id = 3,
        nome = "Pizza de brigadeiro",
        descricao = "Pizza doce de 6 fatias",
        categoria = CategoriasPizzaria.DOCES,
        valor = BigDecimal.TEN
    )

    private var listaItensPedido: MutableList<OrderItem> = arrayListOf(
        OrderItem(1, 1, itemCardapio1),
        OrderItem(2, 1, itemCardapio2),
        OrderItem(3, 1, itemCardapio3)
    )

    @Test
    fun adicaoPedido() {
        DataStore.orders.add(Order(1, listaItensPedido, true))
        assertEquals(9, DataStore.orders.size)
    }

    @Test
    fun remocaoPedido() {
        DataStore.orders.add(Order(1, listaItensPedido, true))
        DataStore.orders.removeLast()
        assertEquals(8, DataStore.orders.size)
    }

    @Test
    fun adicaoitemPedido() {
        DataStore.orderItems.add(OrderItem(2, 1, itemCardapio1))
        assertEquals(4, DataStore.orderItems.size)
    }

    @Test
    fun remocaoItemPedido() {
        DataStore.orderItems.add(OrderItem(2, 1, itemCardapio1))
        DataStore.orderItems.removeLast()
        assertEquals(3, DataStore.orderItems.size)
    }

    @Test
    fun adicaoItemCardapio() {
        DataStore.addFoodMenuItem(
            FoodMenuItem(
                nome = "Pizza de calabresa",
                descricao = "Pizza salgada de 8 fatias",
                categoria = CategoriasPizzaria.SALGADAS,
                valor = BigDecimal.TEN
            )
        )
        assertEquals(4, DataStore.foodMenu.size)
    }

    @Test
    fun remocaoItemCardapio() {
        val itemCardapio = FoodMenuItem(
            nome = "Pizza de calabresa",
            descricao = "Pizza salgada de 8 fatias",
            categoria = CategoriasPizzaria.SALGADAS,
            valor = BigDecimal.TEN
        )
        DataStore.addFoodMenuItem(itemCardapio)
        DataStore.deleteFoodMenuItem(itemCardapio.id)
        assertEquals(3, DataStore.foodMenu.size)
    }

}