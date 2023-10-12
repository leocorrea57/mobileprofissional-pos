package com.example.bottommenulayout.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottommenulayout.databinding.FragmentRegisterBinding
import com.example.bottommenulayout.model.Restaurante

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private var position = -1
    private var restaurante = Restaurante()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        binding.btnAdicionar.setOnClickListener {
//
//            restaurante.nome = binding.fieldNome.text.toString()
//            restaurante.tipo = binding.fieldTipo.text.toString()
//            restaurante.taxa = binding.fieldTaxa.text.toString().toBigDecimal()
//
//            val preferences =
//                context?.getSharedPreferences(getString(R.string.file_preferences), Context.MODE_PRIVATE)
//
//            DataStore.addRestaurante(restaurante)
//
//            preferences?.edit()?.apply() {
//                val gson = Gson()
//                val json = gson.toJson(
//                    DataStore.restaurantes
//                )
//                putString(getString(R.string.rest), json)
//                commit()
//            }
//
//            Toast.makeText(
//                activity,
//                "Restaurante ${binding.fieldNome.text.toString()} adicionado!",
//                Toast.LENGTH_LONG
//            ).show()
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}