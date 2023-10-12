package com.example.bottommenulayout.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottommenulayout.Model.Restaurante
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.AdapterRestauranteBinding
import java.math.BigDecimal
import java.text.NumberFormat

class RestauranteAdapter(private var restaurantes: MutableList<Restaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.RestauranteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteHolder {
        AdapterRestauranteBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return RestauranteHolder(this)
        }
    }

    override fun onBindViewHolder(holder: RestauranteHolder, position: Int) {
        holder.bind(restaurantes[position])
    }


    inner class RestauranteHolder(private var binding: AdapterRestauranteBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(restaurante: Restaurante) {
            val numberFormat = NumberFormat.getCurrencyInstance() //utilizado para formatar o valor em R$

            binding.textNome.text = restaurante.nome
            binding.textTipo.text = restaurante.tipo

            if (restaurante.taxa > BigDecimal(0)) {
                binding.textTaxa.apply {
                    text = numberFormat.format(restaurante.taxa)
                    setTextColor(itemView.resources.getColor(R.color.text_gray, null))
                    typeface = Typeface.DEFAULT
                }
            } else {
                binding.textTaxa.apply {
                    text = "Grátis"
                    setTextColor(itemView.resources.getColor(R.color.status_green, null))
                    typeface = Typeface.DEFAULT
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return restaurantes.size
    }
}