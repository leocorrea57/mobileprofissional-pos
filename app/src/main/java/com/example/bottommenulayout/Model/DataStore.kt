package com.example.bottommenulayout.Model

import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import java.math.BigDecimal

object DataStore {

    var restaurantes :MutableList<Restaurante> = arrayListOf()
    var id : Int = 0

    init {
        restaurantes.add(Restaurante("Restaurante Janta Boa",0,"Marmita",BigDecimal.TEN))
    }

    fun addRestaurante(rest : Restaurante)
    {
        id++
        restaurantes.add(rest)
    }

    fun getRestaurante(at : Int) : Restaurante
    {
        return restaurantes[at]
    }

    fun setLists(list:MutableList<Restaurante>){
        restaurantes = list
//        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)

        // creating a variable for editor to
//        // store data in shared preferences.
//        val editor = sharedPreferences.edit()
//        val gson = Gson()
//        val json = gson.toJson(list)//converting list to Json
//        editor.putString("LIST",json)
//        editor.commit()
    }

}