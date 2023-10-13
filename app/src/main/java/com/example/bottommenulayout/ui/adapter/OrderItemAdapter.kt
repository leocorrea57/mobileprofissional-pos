package com.example.bottommenulayout.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottommenulayout.databinding.OrderItemViewholderBinding
import com.example.bottommenulayout.model.OrderItem
import java.text.NumberFormat

class OrderItemAdapter(private var itensPedido: MutableList<OrderItem>) :
    RecyclerView.Adapter<OrderItemAdapter.OrderItemHolder>() {
    var showQuantidade: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemHolder {
        OrderItemViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return OrderItemHolder(this)
        }
    }

    override fun onBindViewHolder(holder: OrderItemHolder, position: Int) {
        if (position == itensPedido.lastIndex)
            holder.bind(itensPedido[position], false, showQuantidade)
        else
            holder.bind(itensPedido[position], true, showQuantidade)
    }


    inner class OrderItemHolder(private var binding: OrderItemViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: OrderItem, divider: Boolean, showQuantidade: Boolean) {
            val numberFormat = NumberFormat.getCurrencyInstance() //utilizado para formatar o valor em R$

            binding.textNome.text = item.foodMenuItem.nome
            binding.textDescricao.text = item.foodMenuItem.descricao
            binding.textValor.text = numberFormat.format(item.valorTotalItem)

            if (divider) binding.divider.visibility = View.VISIBLE else binding.divider.visibility = View.GONE
            if (showQuantidade) binding.textQuantidade.visibility = View.VISIBLE else binding.textQuantidade.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return itensPedido.size
    }
}