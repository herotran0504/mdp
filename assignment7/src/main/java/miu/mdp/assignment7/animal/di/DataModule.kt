package miu.mdp.assignment7.animal.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.assignment7.animal.data.repository.AnimalRepository
import miu.mdp.assignment7.animal.data.repository.AnimalRepositoryImpl
import miu.mdp.assignment7.animal.data.repository.SpeciesRepository
import miu.mdp.assignment7.animal.data.repository.SpeciesRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Singleton
    @Binds
    fun bindAnimalRepository(repository: AnimalRepositoryImpl): AnimalRepository

    @Singleton
    @Binds
    fun bindSpeciesRepository(repository: SpeciesRepositoryImpl): SpeciesRepository

}