package com.example.bottommenulayout.ui.foodmenu

import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.OrderItem

class FoodMenuViewModel : ViewModel() {

    fun getFoodMenuItens(): List<OrderItem> {
        return DataStore.itensPedido
    }
}