package com.elektraexample.pokemon_elektra.data.network




import com.elektraexample.pokemon_elektra.data.network.model.response.PokemonListResponse
import com.elektraexample.pokemon_elektra.domain.PokemonDetail
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ServiceApi {
    @GET("pokemon/")
    fun getListPokemons( ): Single<Response<PokemonListResponse>>

    @GET("pokemon/{id}")
    fun getDetailPockemon(  @Path("id") user: String ): Single<Response<PokemonDetail>>
}
