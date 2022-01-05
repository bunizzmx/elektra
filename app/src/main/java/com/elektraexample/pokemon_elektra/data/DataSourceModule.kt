package com.elektraexample.pokemon_elektra.data

import com.elektraexample.pokemon_elektra.data.repository.PokemonRequestRepository
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideAuthRepository(repository: PokemonRequestRepository): PockemonRepository {  return repository }




}