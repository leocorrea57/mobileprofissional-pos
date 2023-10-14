package com.example.bottommenulayout.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.FragmentRegisterBinding
import com.example.bottommenulayout.model.DataStore
import com.example.bottommenulayout.model.FoodMenuItem
import com.example.bottommenulayout.model.Restaurante
import com.example.bottommenulayout.ui.foodmenu.FoodMenuViewModel
import java.math.BigDecimal

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private var position = -1
    private lateinit var foodMenuItem : FoodMenuItem
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinner = binding.categorySpinner

        this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.itens_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears.
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner.
                spinner.adapter = adapter
            }
        }

        binding.btnAdicionar.setOnClickListener {

            //val value = binding.fieldValor.get

            foodMenuItem = FoodMenuItem(
                nome = binding.fieldNome.text.toString(),
                categoria = binding.categorySpinner.selectedItem.toString(),
                descricao = binding.fieldDesc.text.toString(),
                valor = BigDecimal.TEN // Deu errado -> binding.fieldValor.text.toString().toBigDecimal()
            )

            registerViewModel.addFoodMenuItem(foodMenuItem)

            Toast.makeText(
                activity,
                "Item ${binding.fieldNome.text.toString()} adicionado!",
                Toast.LENGTH_LONG
            ).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}