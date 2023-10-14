package com.example.bottommenulayout.ui.foodmenu

import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.FoodMenuItem

class FoodMenuViewModel : ViewModel() {

    fun getFoodMenuItens(): List<FoodMenuItem> {
        return DataStore.foodMenu
    }

    fun deleteItem(id: Int): Boolean = DataStore.deleteFoodMenuItem(id)
}