package com.example.bottommenulayout.ui.foodmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenulayout.databinding.FragmentSearchBinding
import com.example.bottommenulayout.ui.adapter.FoodMenuItemAdapter

class FoodMenuFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var foodMenuViewModel: FoodMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        foodMenuViewModel = ViewModelProvider(this)[FoodMenuViewModel::class.java]
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        setContent()
        return binding.root
    }

    private fun setContent() {
        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerCardapio.layoutManager = this
            binding.recyclerCardapio.adapter = FoodMenuItemAdapter(foodMenuViewModel.getFoodMenuItens().toMutableList())
        }
    }
}