package dev.leotoloza.avengersapp.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.leotoloza.avengersapp.data.repository.CharactersRepositoryImpl
import dev.leotoloza.avengersapp.domain.repository.CharactersRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
     @Binds
     @Singleton
     abstract fun bindCharactersRepository(
         charactersRepositoryImpl: CharactersRepositoryImpl
     ): CharactersRepository
}