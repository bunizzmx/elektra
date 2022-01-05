package com.elektraexample.pokemon_elektra.presentation.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.elektraexample.pokemon_elektra.R
import com.elektraexample.pokemon_elektra.databinding.DetallePokemonBinding
import com.elektraexample.pokemon_elektra.presentation.common.viewBinding
import com.elektraexample.pokemon_elektra.utils.Event


class DetallePockemonFragment  : Fragment() {


    private val authViewModel by activityViewModels<PokemonViewModel>()
    private val binding by viewBinding(DetallePokemonBinding::bind)
    lateinit var idPockemon :String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detalle_pokemon, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            idPockemon = DetallePockemonFragmentArgs.fromBundle(it).idPokemon.toString()
        }
        applyBinding()
        observeEvents()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun applyBinding() {
        with(binding) {
            authViewModel.getDetailPokemon(idPockemon)
        }
    }

    private fun observeEvents() {
        authViewModel.pokemonDetail.observe(viewLifecycleOwner, Event.EventObserver {
            Glide.with(requireActivity())
                .load(it.sprites.front_default)
                .into(binding.imageDetailPokemon)
            binding.nameDetail.setText(it.name)
            it.abilities.forEach {
                with(binding) {
                    binding.habilities.append(it?.ability.name+"\n")
                }
            }
            it.types.forEach {
                with(binding) {
                    binding.tipos.append(it?.type.name+"\n")
                }
            }
        })
    }

}