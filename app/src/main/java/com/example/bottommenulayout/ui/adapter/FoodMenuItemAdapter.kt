package com.example.bottommenulayout.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottommenulayout.databinding.FoodMenuItemBinding
import com.example.bottommenulayout.model.FoodMenuItem
import java.text.NumberFormat

class FoodMenuItemAdapter(private var cardapio: MutableList<FoodMenuItem>) :
    RecyclerView.Adapter<FoodMenuItemAdapter.FoodMenuItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodMenuItemHolder {
        FoodMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return FoodMenuItemHolder(this)
        }
    }

    override fun onBindViewHolder(holder: FoodMenuItemHolder, position: Int) {
        if (position == cardapio.lastIndex)
            holder.bind(cardapio[position], false)
        else
            holder.bind(cardapio[position], true)
    }


    inner class FoodMenuItemHolder(private var binding: FoodMenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: FoodMenuItem, divider: Boolean) {
            val numberFormat = NumberFormat.getCurrencyInstance() //utilizado para formatar o valor em R$

            binding.textNome.text = item.nome
            binding.textDescricao.text = item.descricao
            binding.textValor.text = numberFormat.format(item.valor)

            if (divider) binding.divider.visibility = View.VISIBLE else binding.divider.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return cardapio.size
    }
}