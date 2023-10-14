package com.example.bottommenulayout.ui.orders

import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.Order

class OrdersViewModel : ViewModel() {
    fun getListPendentes(): MutableList<Order> {
        return DataStore.orders.filter { !it.status }.take(4).toMutableList()
    }

    fun getListFinalizados(): MutableList<Order> {
        return DataStore.orders.filter { it.status }.take(4).toMutableList()
    }
}