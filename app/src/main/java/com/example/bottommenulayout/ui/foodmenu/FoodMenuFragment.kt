package com.example.bottommenulayout.ui.foodmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.databinding.FragmentSearchBinding

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

        return binding.root
    }
}