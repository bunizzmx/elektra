package com.elektraexample.pokemon_elektra.presentation.di;

import com.elektraexample.pokemon_elektra.data.DataSourceModule;
import com.elektraexample.pokemon_elektra.data.network.NetworkModule;
import com.elektraexample.pokemon_elektra.domain.repository.PockemonRepository;
import com.elektraexample.pokemon_elektra.presentation.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataSourceModule.class, NetworkModule.class})
public interface ApplicationComponent {
    PockemonRepository activationCardRepository();


}

