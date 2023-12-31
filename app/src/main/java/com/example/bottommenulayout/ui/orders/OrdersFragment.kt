package com.example.bottommenulayout.ui.orders

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.Model.DataStore
import com.example.bottommenulayout.Model.Restaurante
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.FragmentOrdersBinding
import com.google.gson.Gson

class OrdersFragment : Fragment() {

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    private var position = -1
    private var restaurante = Restaurante()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(OrdersViewModel::class.java)

        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnAdicionar.setOnClickListener {

            restaurante.nome = binding.fieldNome.text.toString()
            restaurante.tipo = binding.fieldTipo.text.toString()
            restaurante.taxa = binding.fieldTaxa.text.toString().toBigDecimal()

            val preferences =
                context?.getSharedPreferences(getString(R.string.file_preferences), Context.MODE_PRIVATE)

            DataStore.addRestaurante(restaurante)

            preferences?.edit()?.apply() {
                val gson = Gson()
                val json = gson.toJson(
                    DataStore.restaurantes
                )
                putString(getString(R.string.rest), json)
                commit()
            }

            Toast.makeText(
                activity,
                "Restaurante ${binding.fieldNome.text.toString()} adicionado!",
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