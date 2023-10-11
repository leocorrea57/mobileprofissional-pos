package com.example.bottommenulayout.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenulayout.Model.DataStore
import com.example.bottommenulayout.Model.Restaurante
import com.example.bottommenulayout.R
import com.example.bottommenulayout.databinding.FragmentHomeBinding
import com.example.bottommenulayout.ui.adapter.RestauranteAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RestauranteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val preferences =
            context?.getSharedPreferences(getString(R.string.file_preferences), Context.MODE_PRIVATE)

        val aa = preferences?.getString(getString(R.string.rest),null)

        if (aa != null) {
            Log.i("taag",aa)
        }

        val gson = Gson()

        if(aa != null) {
            val objectList = gson.fromJson(aa, Array<Restaurante>::class.java).asList().let {
                DataStore.setLists(it.toMutableList())
            } ?: kotlin.run {

            }
        }




        LinearLayoutManager(this.context).apply {
            this.orientation = LinearLayoutManager.VERTICAL
            binding.revRestaurantes.layoutManager = this
            adapter = RestauranteAdapter(DataStore.restaurantes)
            binding.revRestaurantes.adapter = adapter
        }







        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}