package com.elektraexample.pokemon_elektra.presentation.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elektraexample.pokemon_elektra.R
import com.elektraexample.pokemon_elektra.domain.Pokemon
import com.elektraexample.pokemon_elektra.presentation.ui.listeners.OpenPockemonListener


class AdapterPockemones (context :Context, listener : OpenPockemonListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    lateinit  var listener : OpenPockemonListener
    val TYPE_POKEMON :Int =0
    lateinit var context:Context
    lateinit var pokemons:ArrayList<Pokemon>
    init {
        this.context = context
        this.listener = listener
        this.pokemons = arrayListOf()
    }




    private fun getInflatedView(parent: ViewGroup, resourceLayout: Int): View? {
        return LayoutInflater
            .from(parent.context)
            .inflate(resourceLayout, parent, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var  view: View?
        view = getInflatedView(parent, R.layout.item_pockemon)
        return   PokemonHolder(view!!)


    }

    override fun getItemViewType(position: Int): Int {
        return TYPE_POKEMON
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewType : Int = getItemViewType(position)
        when(viewType){
            TYPE_POKEMON -> {
                val n: PokemonHolder = holder as PokemonHolder
                n.name.setText(pokemons.get(position).name)
                //AL PARECER EL SERVICIO NO ME REGRESA LA IMAGEN DE LA LISTA
                /*Glide.with(context)
                    .load(pokemons.get(position).url)
                    .into(n.image)*/
                n.root_element.setOnClickListener {
                    val arr = pokemons.get(position).url.split("pokemon/").toTypedArray()
                    listener.open(arr[1])
                }
            }
        }
    }

    override fun getItemCount(): Int {
            return  pokemons.size
    }

    class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit  var name: TextView
        lateinit  var image: ImageView
        lateinit  var root_element: LinearLayout

        init {
            root_element = itemView.findViewById(R.id.root_element)
            image = itemView.findViewById(R.id.image_pokemon)
            name = itemView.findViewById(R.id.name_pokemon)
        }
    }
}