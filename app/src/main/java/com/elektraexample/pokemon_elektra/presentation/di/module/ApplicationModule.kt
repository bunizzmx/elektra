package com.elektraexample.pokemon_elektra.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context { return context }
}