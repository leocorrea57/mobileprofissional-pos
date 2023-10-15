package com.example.bottommenulayout.ui.foodmenu

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.ActivityEditFoodMenuItemBinding
import com.example.bottommenulayout.model.CategoriasPizzaria
import com.example.bottommenulayout.model.FoodMenuItem
import java.math.BigDecimal

class EditFoodMenuItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditFoodMenuItemBinding
    private lateinit var foodMenuViewModel: FoodMenuViewModel
    private lateinit var itemExtra: FoodMenuItem
    private var selectedCategoryItem = CategoriasPizzaria.SALGADAS
    private var hasCategorySelection = false


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
                fieldNome.editText?.setText(itemExtra.nome)
                fieldDesc.editText?.setText(itemExtra.descricao)
                fieldValor.editText?.setText(itemExtra.valor.toEngineeringString())

                ArrayAdapter.createFromResource(this@EditFoodMenuItemActivity, R.array.itens_array, R.layout.list_item).also { adapter ->
                    adapter.setDropDownViewResource(R.layout.list_item)
                    (binding.categorySpinner.editText as AutoCompleteTextView).setAdapter(adapter)
                    (binding.categorySpinner.editText as AutoCompleteTextView).setText(itemExtra.categoria, false)

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
                nome = binding.fieldNome.editText?.text.toString()
                categoria = selectedCategoryItem
                descricao = binding.fieldDesc.editText?.text.toString()
                valor = BigDecimal(binding.fieldValor.editText?.text.toString())
            }

            if (foodMenuViewModel.editItem(itemExtra)) {
                setResult(RESULT_OK)
                finish()
            } else {
                finish()
            }
        }

        (binding.categorySpinner.editText as AutoCompleteTextView).setOnItemClickListener { parent, view, position, id ->
            selectedCategoryItem = (binding.categorySpinner.editText as AutoCompleteTextView).adapter.getItem(position).toString()
            hasCategorySelection = true
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (binding.fieldNome.editText?.text.toString().isEmpty()) {
            binding.fieldNome.error = "Nome não pode ser vazio"
            isValid = false
        }

        if (binding.fieldDesc.editText?.text.toString().isEmpty()) {
            binding.fieldDesc.error = "Descrição não pode ser vazio"
            isValid = false
        }

        return isValid
    }

    companion object {
        const val ITEM_EXTRA = "item_food_menu_extra"
    }
}