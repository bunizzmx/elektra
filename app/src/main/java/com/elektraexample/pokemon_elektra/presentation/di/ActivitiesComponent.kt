package com.elektraexample.pokemon_elektra.presentation.di





import com.elektraexample.pokemon_elektra.MainActivity
import com.elektraexample.pokemon_elektra.presentation.di.scope.FragmentScope
import dagger.Component



@FragmentScope
@Component(dependencies = [ApplicationComponent::class])
interface ActivitiesComponent {
    fun inject(target: MainActivity)
}