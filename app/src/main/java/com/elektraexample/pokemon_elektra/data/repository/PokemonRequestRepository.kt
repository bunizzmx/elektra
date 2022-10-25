package com.elektraexample.pokemon_elektra.data.repository



import com.elektraexample.pokemon_elektra.data.network.ServiceApi
import com.elektraexample.pokemon_elektra.data.network.model.PokemonListRequest
import com.elektraexample.pokemon_elektra.data.network.model.response.PokemonListResponse
import com.elektraexample.pokemon_elektra.domain.PokemonDetail
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRequestRepository
@Inject constructor(
    private val apiInvex: ServiceApi,
) : PockemonRepository {





    override fun getListPokemons(): Single<PokemonListResponse> {
        return apiInvex.getListPokemons().map { serviceResponse ->
            val response = serviceResponse.body()
            return@map response
        }
    }

    override fun getDetailPokemon(idPokemon: String): Single<PokemonDetail> {
        return apiInvex.getDetailPockemon(idPokemon).map { serviceResponse ->
            val response = serviceResponse.body()
            return@map response
        }
    }


}