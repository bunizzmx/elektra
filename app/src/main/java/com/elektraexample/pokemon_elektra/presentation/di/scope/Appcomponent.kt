package com.elektraexample.pokemon_elektra.presentation.di.scope

import com.elektraexample.pokemon_elektra.data.DataSourceModule
import com.elektraexample.pokemon_elektra.data.network.NetworkModule
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository
import com.elektraexample.pokemon_elektra.presentation.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataSourceModule::class, NetworkModule::class])
interface Appcomponent {
    fun activationCardRepository(): PockemonRepository?
}