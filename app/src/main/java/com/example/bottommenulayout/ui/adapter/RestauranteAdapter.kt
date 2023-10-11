package com.example.bottommenulayout.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottommenulayout.Model.Restaurante
import com.example.bottommenulayout.databinding.AdapterRestauranteBinding

class RestauranteAdapter(var restaurantes : MutableList<Restaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.RestauranteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteHolder {
        AdapterRestauranteBinding.inflate(LayoutInflater.from(parent.context),parent,false).apply {
            return RestauranteHolder(this)
        }
    }

    override fun onBindViewHolder(holder: RestauranteHolder, position: Int) {
        restaurantes[position].apply {
            holder.binding.txtEntrega.text = "Taxa de entrega: R$ " + this.taxa.toString()
            holder.binding.txtNome.text = this.nome
            holder.binding.txtTipo.text = "Categora: " + this.tipo
        }
    }


    inner class RestauranteHolder(var binding: AdapterRestauranteBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return restaurantes.size
    }
}