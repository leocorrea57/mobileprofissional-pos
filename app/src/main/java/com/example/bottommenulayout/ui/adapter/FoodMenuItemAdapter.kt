package com.example.bottommenulayout.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottommenulayout.databinding.FoodMenuItemBinding
import com.example.bottommenulayout.model.FoodMenuItem
import java.text.NumberFormat
import java.util.*

class FoodMenuItemAdapter(
    private val deleteListener: (FoodMenuItem) -> Unit,
    private val editListener: (FoodMenuItem) -> Unit
) :
    RecyclerView.Adapter<FoodMenuItemAdapter.FoodMenuItemHolder>() {
    private var cardapio = mutableListOf<FoodMenuItem>()
    private var cardapioCopy = mutableListOf<FoodMenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodMenuItemHolder {
        FoodMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return FoodMenuItemHolder(this, deleteListener, editListener)
        }
    }

    override fun onBindViewHolder(holder: FoodMenuItemHolder, position: Int) {
        if (position == cardapio.lastIndex)
            holder.bind(cardapio[position], false)
        else
            holder.bind(cardapio[position], true)
    }


    inner class FoodMenuItemHolder(
        private var binding: FoodMenuItemBinding,
        val deleteListener: (FoodMenuItem) -> Unit,
        val editListener: (FoodMenuItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: FoodMenuItem, divider: Boolean) {
            val numberFormat = NumberFormat.getCurrencyInstance() //utilizado para formatar o valor em R$

            binding.textNome.text = item.nome
            binding.textDescricao.text = item.descricao
            binding.textValor.text = numberFormat.format(item.valor)
            binding.textCategoria.text = item.categoria

            if (divider) binding.divider.visibility = View.VISIBLE else binding.divider.visibility = View.GONE

            binding.buttonDelete.setOnClickListener { deleteListener(item) }
            binding.buttonEdit.setOnClickListener { editListener(item) }

        }
    }

    override fun getItemCount(): Int {
        return cardapio.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<FoodMenuItem>, filter: Boolean = false) {
        cardapio = list.toMutableList()
        cardapioCopy = cardapio
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filter(text: String) {
        cardapio = if (text.isEmpty()) {
            cardapioCopy
        } else {
            cardapioCopy.filter { it.nome.contains(text, ignoreCase = true) }.toMutableList()
        }
        notifyDataSetChanged()
    }
}