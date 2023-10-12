package com.example.bottommenulayout.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottommenulayout.model.Order
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.OrderViewholderBinding
import java.text.NumberFormat

class OrderAdapter(private var pedidos: MutableList<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        OrderViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return OrderHolder(this)
        }
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        if (position == pedidos.lastIndex)
            holder.bind(pedidos[position], false)
        else
            holder.bind(pedidos[position], true)
    }


    inner class OrderHolder(private var binding: OrderViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(pedido: Order, divider: Boolean) {
            val numberFormat = NumberFormat.getCurrencyInstance() //utilizado para formatar o valor em R$

            binding.textNumeroPedido.text = "#${pedido.numero}"
            binding.textQuantidadeItens.text = "${pedido.totalItens} ${if (pedido.totalItens != 1) "itans" else "item"}"
            binding.textValor.text = numberFormat.format(pedido.valorTotal)

            if (pedido.status) {
                binding.iconStatus.setImageResource(R.drawable.ic_outline_check_circle)
                binding.iconStatus.setColorFilter(itemView.resources.getColor(R.color.status_green, null))
            } else {
                binding.iconStatus.setImageResource(R.drawable.ic_access_time)
                binding.iconStatus.setColorFilter(itemView.resources.getColor(R.color.status_orange, null))
            }

            if (divider) binding.divider.visibility = View.VISIBLE else binding.divider.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return pedidos.size
    }
}