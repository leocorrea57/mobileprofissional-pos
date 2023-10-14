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
import com.example.bottommenulayout.model.FoodMenuItem
import java.math.BigDecimal

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodMenuItem: FoodMenuItem
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        registerViewModel =
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
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }

        binding.btnAdicionar.setOnClickListener {

            if (!validateFields()) {
                Toast.makeText(
                    activity,
                    "Favor preencher campos do formulário",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            foodMenuItem = FoodMenuItem(
                nome = binding.fieldNome.text.toString(),
                categoria = binding.categorySpinner.selectedItem.toString(),
                descricao = binding.fieldDesc.text.toString(),
                valor = BigDecimal(binding.fieldValor.text.toString())
            )

            registerViewModel.addFoodMenuItem(foodMenuItem)
            cleanFields()

            Toast.makeText(
                activity,
                "Item ${foodMenuItem.nome} adicionado!",
                Toast.LENGTH_LONG
            ).show()
        }

        return root
    }

    private fun cleanFields() {
        binding.fieldNome.text.clear()
        binding.fieldDesc.text.clear()
        binding.fieldValor.text.clear()
        binding.categorySpinner.setSelection(0)
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (binding.fieldNome.text.toString().isEmpty()) {
            binding.fieldNome.setError("Nome não pode ser vazio")
            isValid = false
        }

        if (binding.fieldDesc.text.toString().isEmpty()) {
            binding.fieldDesc.setError("Descrição não pode ser vazio")
            isValid = false
        }
        return isValid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}