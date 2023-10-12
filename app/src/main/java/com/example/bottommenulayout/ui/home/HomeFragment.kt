package com.example.bottommenulayout.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenulayout.databinding.FragmentHomeBinding
import com.example.bottommenulayout.ui.adapter.RestauranteAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        homeViewModel.loadData(requireContext())

        setContent()

        return binding.root
    }

    private fun setContent() {
        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerDestaques.layoutManager = this
            binding.recyclerDestaques.adapter = RestauranteAdapter(homeViewModel.getListDestaques())
        }

        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerFrete.layoutManager = this
            binding.recyclerFrete.adapter = RestauranteAdapter(homeViewModel.getListFreteGratis())
        }
    }
}