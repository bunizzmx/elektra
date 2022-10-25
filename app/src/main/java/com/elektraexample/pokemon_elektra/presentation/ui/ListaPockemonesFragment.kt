package com.elektraexample.pokemon_elektra.presentation.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.elektraexample.pokemon_elektra.R
import com.elektraexample.pokemon_elektra.databinding.FragmentPokemonesBinding
import com.elektraexample.pokemon_elektra.presentation.common.viewBinding
import com.elektraexample.pokemon_elektra.presentation.ui.adapters.AdapterPockemones
import com.elektraexample.pokemon_elektra.presentation.ui.listeners.OpenPockemonListener
import com.elektraexample.pokemon_elektra.utils.Event

class ListaPockemonesFragment  : Fragment() {

    private var dialog: AlertDialog? = null
    private val authViewModel by activityViewModels<PokemonViewModel>()
    private val binding by viewBinding(FragmentPokemonesBinding::bind)
    lateinit var adapter : AdapterPockemones
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemones, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = AdapterPockemones(requireContext(),object  : OpenPockemonListener {
            override fun open(url: String?) {
                findNavController().navigate(ListaPockemonesFragmentDirections.actionListaPockemonesFragmentToDetallePockemonFragment(url))
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyBinding()
        observeEvents()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun applyBinding() {
        with(binding) {
            listaPokemones.adapter = adapter
            listaPokemones.layoutManager = LinearLayoutManager(context)
            authViewModel.getListPokemons()
        }
    }

    private fun observeEvents() {
        authViewModel.pokemons.observe(viewLifecycleOwner, Event.EventObserver {
            adapter.pokemons = it
            adapter.notifyDataSetChanged()
        })

    }

}