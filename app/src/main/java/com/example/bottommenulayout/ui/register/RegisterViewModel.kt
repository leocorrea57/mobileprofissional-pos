package com.example.bottommenulayout.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.model.CategoriasPizzaria
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.FoodMenuItem

class RegisterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    fun addFoodMenuItem(item : FoodMenuItem) {
        DataStore.cardapio.add(item)
    }
}