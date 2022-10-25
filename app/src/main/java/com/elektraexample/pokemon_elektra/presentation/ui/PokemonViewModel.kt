package  com.elektraexample.pokemon_elektra.presentation.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
@Inject constructor(  private val pokemonRepository: PockemonRepository) :BaseViewModel() {

    private val disposable = CompositeDisposable()

    private val _pokemons = MutableLiveData<Event<ArrayList<Pokemon>>>()
    val pokemons get() = _pokemons

    private val _pokemonDetail = MutableLiveData<Event<PokemonDetail>>()
    val pokemonDetail get() = _pokemonDetail

    private val _loginError = MutableLiveData<Event<String>>()
    val loginError get() = _loginError

    internal fun getDetailPokemon(idPokemon:String) {

        val task = pokemonRepository.getDetailPokemon(idPokemon)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val subscriber = task.subscribe({
               onSuccessfulDetail(it)

        }, {
            onFailedList(it.message!!)
        })
        disposable.add(subscriber)
    }



    internal fun getListPokemons() {
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

        })
        disposable.add(subscriber)
    }


    private fun onFailedList(response: String) {

        _loginError.postValue(Event(response))
    }


    private fun onSucessfulList(response: PokemonListResponse) {

        _pokemons.postValue(Event(response.results))
    }

    private fun onSuccessfulDetail(response: PokemonDetail) {

        _pokemonDetail.postValue(Event(response))
    }

}