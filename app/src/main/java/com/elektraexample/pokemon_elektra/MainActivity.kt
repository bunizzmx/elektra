package com.elektraexample.pokemon_elektra
import android.os.Bundle
import androidx.activity.viewModels
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository
import com.elektraexample.pokemon_elektra.presentation.base.BaseViewModelActivity
import com.elektraexample.pokemon_elektra.presentation.di.DaggerActivitiesComponent
import com.elektraexample.pokemon_elektra.presentation.ui.PokemonViewModel
import javax.inject.Inject

class MainActivity :  BaseViewModelActivity<PokemonViewModel>()  {

    override val baseViewModel: PokemonViewModel
        get() = authViewModel

    @Inject
    lateinit var core: PockemonRepository
    private val authViewModel by viewModels<PokemonViewModel> {
        com.elektraexample.pokemon_elektra.presentation.di.ViewModelFactory(
            core,
            this,
            intent.extras
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjection()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initInjection() {
        val component = DaggerActivitiesComponent.builder()
            .applicationComponent(App.applicationComponent)
            .build()
        component.inject(this)
    }
}