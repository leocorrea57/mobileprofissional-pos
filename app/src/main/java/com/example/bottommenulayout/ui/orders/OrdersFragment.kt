package com.example.bottommenulayout.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenulayout.databinding.FragmentOrdersBinding
import com.example.bottommenulayout.ui.adapter.OrderAdapter

class OrdersFragment : Fragment() {
    private lateinit var binding: FragmentOrdersBinding
    private lateinit var ordersViewModel: OrdersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        ordersViewModel = ViewModelProvider(this)[OrdersViewModel::class.java]
        setContent()

        return binding.root
    }

    private fun setContent() {
        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerPendentes.layoutManager = this
            binding.recyclerPendentes.adapter = OrderAdapter(ordersViewModel.getListPendentes())
        }

        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerFinalizados.layoutManager = this
            binding.recyclerFinalizados.adapter = OrderAdapter(ordersViewModel.getListFinalizados())
        }
    }
}