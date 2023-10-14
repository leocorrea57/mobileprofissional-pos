package com.example.bottommenulayout.ui.foodmenu

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenulayout.databinding.FragmentSearchBinding
import com.example.bottommenulayout.model.FoodMenuItem
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
            val adapter = FoodMenuItemAdapter(::deleteListener, {})
            adapter.updateList(foodMenuViewModel.getFoodMenuItens())
            binding.recyclerCardapio.adapter = adapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deleteListener(item: FoodMenuItem) {
        val builder = AlertDialog.Builder(requireContext())
        builder
            .setTitle("Excluir item")
            .setMessage("Deseja excluir este item do cardápio?")
            .setNegativeButton("Cancelar") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Excluir") { dialog, which ->
                foodMenuViewModel.deleteItem(item.id).let {
                    if (it) {
                        Toast.makeText(requireContext(), "Item excluído.", Toast.LENGTH_SHORT).show()
                        setContent()
                    } else {
                        Toast.makeText(requireContext(), "Não foi possível excluir o item.", Toast.LENGTH_SHORT).show()
                    }
                }
            }.show()
    }

}