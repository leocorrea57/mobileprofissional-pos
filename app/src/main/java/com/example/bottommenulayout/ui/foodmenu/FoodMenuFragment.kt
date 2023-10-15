package com.example.bottommenulayout.ui.foodmenu

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenulayout.databinding.FragmentFoodmenuBinding
import com.example.bottommenulayout.model.FoodMenuItem
import com.example.bottommenulayout.ui.adapter.FoodMenuItemAdapter

class FoodMenuFragment : Fragment() {

    private lateinit var binding: FragmentFoodmenuBinding
    private lateinit var foodMenuViewModel: FoodMenuViewModel
    private lateinit var adapter: FoodMenuItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        foodMenuViewModel = ViewModelProvider(this)[FoodMenuViewModel::class.java]
        binding = FragmentFoodmenuBinding.inflate(inflater, container, false)
        setContent()
        setListeners()
        return binding.root
    }

    private fun setContent() {
        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerCardapio.layoutManager = this
            adapter = FoodMenuItemAdapter(::deleteListener, ::editListener)
            adapter.updateList(foodMenuViewModel.getFoodMenuItens())
            binding.recyclerCardapio.adapter = adapter
        }
    }

    private fun setListeners() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText.toString())
                return true
            }

        })
    }

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

    @SuppressLint("NotifyDataSetChanged")
    private fun editListener(item: FoodMenuItem) {
        val intent = Intent(activity, EditFoodMenuItemActivity::class.java)
        intent.putExtra(EditFoodMenuItemActivity.ITEM_EXTRA, item)
        startForResult.launch(intent)
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(requireContext(), "Item alterado com sucesso.", Toast.LENGTH_SHORT).show()
            setContent()
        }
    }
}