package com.example.bottommenulayout.ui.foodmenu

import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.FoodMenuItem
import com.example.bottommenulayout.model.OrderItem

class FoodMenuViewModel : ViewModel() {

    fun getFoodMenuItens(): List<FoodMenuItem> {
        return DataStore.cardapio
    }
}