package com.elektraexample.pokemon_elektra.domain.repository


import com.elektraexample.pokemon_elektra.data.network.model.response.PokemonListResponse
import com.elektraexample.pokemon_elektra.domain.PokemonDetail
import io.reactivex.Single


interface PockemonRepository {
    fun getListPokemons(): Single<PokemonListResponse>
    fun getDetailPokemon( idPokemon:String): Single<PokemonDetail>
}