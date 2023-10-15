package com.example.bottommenulayout.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.FragmentRegisterBinding
import com.example.bottommenulayout.model.CategoriasPizzaria
import com.example.bottommenulayout.model.FoodMenuItem
import java.math.BigDecimal

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    private lateinit var foodMenuItem: FoodMenuItem
    private lateinit var registerViewModel: RegisterViewModel

    private var selectedCategoryItem = CategoriasPizzaria.SALGADAS
    private var hasCategorySelection = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        ArrayAdapter.createFromResource(requireContext(), R.array.itens_array, R.layout.list_item).also { adapter ->
            adapter.setDropDownViewResource(R.layout.list_item)
            (binding.categorySpinner.editText as AutoCompleteTextView).setAdapter(adapter)
        }

        setListeners()
        return binding.root
    }

    private fun setListeners() {
        (binding.categorySpinner.editText as AutoCompleteTextView).setOnItemClickListener { parent, view, position, id ->
            selectedCategoryItem = (binding.categorySpinner.editText as AutoCompleteTextView).adapter.getItem(position).toString()
            hasCategorySelection = true
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
                nome = binding.fieldNome.editText?.text.toString(),
                categoria = selectedCategoryItem,
                descricao = binding.fieldDesc.editText?.text.toString(),
                valor = BigDecimal(binding.fieldValor.editText?.text.toString())
            )

            registerViewModel.addFoodMenuItem(foodMenuItem)
            cleanFields()

            Toast.makeText(
                activity,
                "Item ${foodMenuItem.nome} adicionado!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun cleanFields() {
        binding.fieldNome.editText?.text?.clear()
        binding.fieldDesc.editText?.text?.clear()
        binding.fieldValor.editText?.text?.clear()
        (binding.categorySpinner.editText as AutoCompleteTextView).threshold = 0
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (binding.fieldNome.editText?.text.toString().isEmpty()) {
            binding.fieldNome.setError("Nome não pode ser vazio")
            isValid = false
        } else {
            binding.fieldNome.isErrorEnabled = false
        }

        if (binding.fieldDesc.editText?.text.toString().isEmpty()) {
            binding.fieldDesc.setError("Descrição não pode ser vazio")
            isValid = false
        } else {
            binding.fieldDesc.isErrorEnabled = false
        }

        if (!hasCategorySelection) {
            binding.categorySpinner.setError("Selecione uma categoria")
            isValid = false
        } else {
            binding.categorySpinner.isErrorEnabled = false
        }

        return isValid
    }
}