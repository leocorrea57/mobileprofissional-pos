package com.example.bottommenulayout

import com.example.bottommenulayout.model.CategoriasPizzaria
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.FoodMenuItem
import com.example.bottommenulayout.model.Order
import com.example.bottommenulayout.model.OrderItem
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.math.BigDecimal

class TestesUnitarios {

    val itemCardapio1 = FoodMenuItem(
        "Pizza de calabresa",
        "Pizza salgada de 8 fatias",
        CategoriasPizzaria.SALGADAS,
        BigDecimal.TEN
    )

    val itemCardapio2 = FoodMenuItem(
        "Pizza de Frango",
        "Pizza salgada de 8 fatias",
        CategoriasPizzaria.SALGADAS,
        BigDecimal.TEN
    )

    val itemCardapio3 = FoodMenuItem(
        "Pizza de brigadeiro",
        "Pizza doce de 6 fatias",
        CategoriasPizzaria.DOCES,
        BigDecimal.TEN
    )

    var listaItensPedido : MutableList<OrderItem> = arrayListOf(
        OrderItem(1,itemCardapio1),
        OrderItem(2,itemCardapio2),
        OrderItem(3,itemCardapio3)
    )

    @Test
    fun adicaoPedido()
    {
        DataStore.pedidos.add(Order(1,listaItensPedido,true))
        assertEquals(9,DataStore.pedidos.size)
    }

    @Test
    fun remocaoPedido()
    {
        DataStore.pedidos.add(Order(1,listaItensPedido,true))
        DataStore.pedidos.removeLast()
        assertEquals(8,DataStore.pedidos.size)
    }

    @Test
    fun adicaoitemPedido()
    {
        DataStore.itensPedido.add(OrderItem(2,itemCardapio1))
        assertEquals(4,DataStore. itensPedido.size)
    }

    @Test
    fun remocaoItemPedido()
    {
        DataStore.itensPedido.add(OrderItem(2,itemCardapio1))
        DataStore.itensPedido.removeLast()
        assertEquals(3,DataStore.itensPedido.size)
    }

    @Test
    fun adicaoItemCardpaio()
    {
        val itemCardapio = FoodMenuItem(
            "Pizza de calabresa",
            "Pizza salgada de 8 fatias",
            CategoriasPizzaria.SALGADAS,
            BigDecimal.TEN
        )
        DataStore.cardapio.add(itemCardapio)
        assertEquals(4,DataStore.cardapio.size)
    }

    @Test
    fun remocaoItemCardapio()
    {
        val itemCardapio = FoodMenuItem(
            "Pizza de calabresa",
            "Pizza salgada de 8 fatias",
            CategoriasPizzaria.SALGADAS,
            BigDecimal.TEN
        )
        DataStore.cardapio.add(itemCardapio)
        DataStore.cardapio.removeLast()
        assertEquals(3,DataStore.cardapio.size)
    }

}