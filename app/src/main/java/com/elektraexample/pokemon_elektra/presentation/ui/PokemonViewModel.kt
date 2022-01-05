package  com.elektraexample.pokemon_elektra.presentation.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.elektraexample.pokemon_elektra.data.network.model.response.PokemonListResponse
import com.elektraexample.pokemon_elektra.domain.Pokemon
import com.elektraexample.pokemon_elektra.domain.PokemonDetail


import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository
import com.elektraexample.pokemon_elektra.utils.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


import javax.inject.Inject

class PokemonViewModel
@Inject constructor(  private val pokemonRepository: PockemonRepository) : BaseViewModel() {

    private val disposable = CompositeDisposable()

    private val _pokemons = MutableLiveData<Event<ArrayList<Pokemon>>>()
    val pokemons get() = _pokemons

    private val _pokemonDetail = MutableLiveData<Event<PokemonDetail>>()
    val pokemonDetail get() = _pokemonDetail



    private val _loginError = MutableLiveData<Event<String>>()
    val loginError get() = _loginError

    init {

    }


    internal fun getDetailPokemon(idPokemon:String) {
        showLoading()
        val task = pokemonRepository.getDetailPokemon(idPokemon)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val subscriber = task.subscribe({
                Log.e("LOGIN_STATUIS","correcto")
               onSuccessfulDetail(it)

        }, {
            Log.e("LOGIN_STATUIS","error" + it.message)
            onFailedList(it.message!!)
        })
        disposable.add(subscriber)
    }



    internal fun getListPokemons() {
        showLoading()
        val task = pokemonRepository.getListPokemons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val subscriber = task.subscribe({
            if(it.results.size> 0) {
                onSucessfulList(it)
            }else{
                onFailedList("Error en el servidor")
            }
        }, {
            serviceError(it.message!!)
        })
        disposable.add(subscriber)
    }


    private fun onFailedList(response: String) {
        hideLoading()
        _loginError.postValue(Event(response))
    }


    private fun onSucessfulList(response: PokemonListResponse) {
        hideLoading()
        _pokemons.postValue(Event(response.results))
    }

    private fun onSuccessfulDetail(response: PokemonDetail) {
        hideLoading()
        _pokemonDetail.postValue(Event(response))
    }




}