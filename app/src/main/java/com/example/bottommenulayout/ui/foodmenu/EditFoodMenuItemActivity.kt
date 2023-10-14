package com.example.bottommenulayout.ui.foodmenu

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.ActivityEditFoodMenuItemBinding
import com.example.bottommenulayout.model.FoodMenuItem
import java.math.BigDecimal

class EditFoodMenuItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditFoodMenuItemBinding
    private lateinit var foodMenuViewModel: FoodMenuViewModel
    private lateinit var itemExtra: FoodMenuItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditFoodMenuItemBinding.inflate(LayoutInflater.from(this))
        foodMenuViewModel = ViewModelProvider(this)[FoodMenuViewModel::class.java]
        setListeners()
        setItem()
        setContentView(binding.root)
    }

    private fun setItem() {
        if (intent.hasExtra(ITEM_EXTRA)) {
            itemExtra = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(ITEM_EXTRA, FoodMenuItem::class.java) as FoodMenuItem
            } else {
                intent.getSerializableExtra(ITEM_EXTRA) as FoodMenuItem

            }

            binding.apply {
                fieldNome.setText(itemExtra.nome)
                fieldDesc.setText(itemExtra.descricao)
                fieldValor.setText(itemExtra.valor.toEngineeringString())
                ArrayAdapter.createFromResource(
                    this@EditFoodMenuItemActivity,
                    R.array.itens_array,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.categorySpinner.adapter = adapter
                    binding.categorySpinner.setSelection(adapter.getPosition(itemExtra.categoria))
                }
            }
        }
    }

    private fun setListeners() {
        binding.btnAdicionar.setOnClickListener {

            if (!validateFields()) {
                Toast.makeText(
                    this,
                    "Favor preencher campos do formulário",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            itemExtra.apply {
                nome = binding.fieldNome.text.toString()
                categoria = binding.categorySpinner.selectedItem.toString()
                descricao = binding.fieldDesc.text.toString()
                valor = BigDecimal(binding.fieldValor.text.toString())
            }

            if (foodMenuViewModel.editItem(itemExtra)) {
                setResult(RESULT_OK)
                finish()
            } else {
                finish()
            }
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (binding.fieldNome.text.toString().isEmpty()) {
            binding.fieldNome.error = "Nome não pode ser vazio"
            isValid = false
        }

        if (binding.fieldDesc.text.toString().isEmpty()) {
            binding.fieldDesc.error = "Descrição não pode ser vazio"
            isValid = false
        }

        return isValid
    }

    companion object {
        const val ITEM_EXTRA = "item_food_menu_extra"
    }
}