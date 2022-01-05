package com.elektraexample.pokemon_elektra
import com.elektraexample.pokemon_elektra.presentation.ViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.elektraexample.pokemon_elektra.data.repository.PokemonRequestRepository
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository
import com.elektraexample.pokemon_elektra.presentation.base.BaseViewModelActivity
import com.elektraexample.pokemon_elektra.presentation.di.ActivitiesComponent
import com.elektraexample.pokemon_elektra.presentation.di.DaggerActivitiesComponent
import com.elektraexample.pokemon_elektra.presentation.di.ViewCoreModelFactory
import com.elektraexample.pokemon_elektra.presentation.ui.PokemonViewModel
import javax.inject.Inject

class MainActivity :  BaseViewModelActivity<PokemonViewModel>()  {

    override val baseViewModel: PokemonViewModel
        get() = authViewModel

    @Inject
    lateinit var core: PockemonRepository
    private val authViewModel by viewModels<PokemonViewModel> {
        ViewCoreModelFactory(core, this, intent.extras)
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