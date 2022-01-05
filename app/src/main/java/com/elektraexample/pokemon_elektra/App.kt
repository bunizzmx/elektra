package  com.elektraexample.pokemon_elektra

import android.app.Application
import com.elektraexample.pokemon_elektra.data.DataSourceModule
import com.elektraexample.pokemon_elektra.data.network.NetworkModule
import com.elektraexample.pokemon_elektra.presentation.di.ApplicationComponent
import com.elektraexample.pokemon_elektra.presentation.di.DaggerApplicationComponent
import com.elektraexample.pokemon_elektra.presentation.di.module.ApplicationModule


class App : Application() {
    companion object {
        var applicationComponent: ApplicationComponent? = null
            private set


    }

    override fun onCreate() {
        super.onCreate()
        configureDagger()
    }



    private fun configureDagger() {
       applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .dataSourceModule(DataSourceModule())
            .networkModule(NetworkModule("https://pokeapi.co/api/v2/"))
            .build()
    }


}