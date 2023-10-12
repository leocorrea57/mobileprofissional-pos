package com.example.bottommenulayout.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.Model.DataStore
import com.example.bottommenulayout.Model.Restaurante
import com.example.bottommenulayout.R
import com.google.gson.Gson
import java.math.BigDecimal

class HomeViewModel : ViewModel() {
    fun getListDestaques(): MutableList<Restaurante> {
        return DataStore.restaurantes.take(4).toMutableList()
    }

    fun getListFreteGratis(): MutableList<Restaurante> {
        return DataStore.restaurantes.filter { (it.taxa == BigDecimal.ZERO || it.taxa == BigDecimal(0)) }.take(4).toMutableList()
    }

    fun loadData(context: Context) {
        val preferences =
            context.getSharedPreferences(context.getString(R.string.file_preferences), Context.MODE_PRIVATE)

        val restaurantsList = preferences?.getString(context.getString(R.string.rest), null)

        val gson = Gson()

        if (restaurantsList != null) {
            gson.fromJson(restaurantsList, Array<Restaurante>::class.java).asList().let {
                DataStore.setLists(it.toMutableList())
            }
        }
    }
}