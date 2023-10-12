package com.example.bottommenulayout.ui.orders

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.Order

class OrdersViewModel : ViewModel() {
    fun getListPendentes(): MutableList<Order> {
        return DataStore.pedidos.filter { !it.status }.take(4).toMutableList()
    }

    fun getListFinalizados(): MutableList<Order> {
        return DataStore.pedidos.filter { it.status }.take(4).toMutableList()
    }

    fun loadData(context: Context) {
//        val preferences =
//            context.getSharedPreferences(context.getString(R.string.file_preferences), Context.MODE_PRIVATE)
//
//        val restaurantsList = preferences?.getString(context.getString(R.string.rest), null)
//
//        val gson = Gson()
//
//        if (restaurantsList != null) {
//            gson.fromJson(restaurantsList, Array<Restaurante>::class.java).asList().let {
//                DataStore.setLists(it.toMutableList())
//            }
//        }
    }
}