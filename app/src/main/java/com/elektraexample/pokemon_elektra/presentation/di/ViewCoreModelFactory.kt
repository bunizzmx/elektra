package  com.elektraexample.pokemon_elektra.presentation.di

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.elektraexample.pokemon_elektra.data.repository.PokemonRequestRepository
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository
import com.elektraexample.pokemon_elektra.presentation.ui.PokemonViewModel


@Suppress("UNCHECKED_CAST")
class ViewCoreModelFactory(
    private val core: PockemonRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?
) :
    AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel?> create(key: String, clazz: Class<T>, state: SavedStateHandle): T {
        val viewModel: ViewModel = if (clazz == PokemonViewModel::class.java) {
            PokemonViewModel(core)
        } else {
            throw RuntimeException("Unsupported view model class: $clazz")
        }
        return viewModel as T
    }
}