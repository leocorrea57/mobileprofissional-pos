package com.example.bottommenulayout.Model

import java.math.BigDecimal

object DataStore {

    var restaurantes: MutableList<Restaurante> = arrayListOf()
    var id: Int = 0

    init {
        restaurantes.add(Restaurante("Restaurante Janta Boa", 0, "Marmita", BigDecimal.TEN))
        restaurantes.add(Restaurante("Lanchonete Sabor Rápido", 0, "Lanche", BigDecimal(12.99)))
        restaurantes.add(Restaurante("Pizza Delícia Express", 0, "Pizza", BigDecimal(0)))
        restaurantes.add(Restaurante("Fit & Fresh Delícias Saudáveis", 0, "Saudável", BigDecimal(7.49)))
        restaurantes.add(Restaurante("Delícias do Oriente", 0, "Japonesa", BigDecimal(0)))

    }

    fun addRestaurante(rest: Restaurante) {
        id++
        restaurantes.add(rest)
    }

    fun getRestaurante(at: Int): Restaurante {
        return restaurantes[at]
    }

    fun setLists(list: MutableList<Restaurante>) {
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