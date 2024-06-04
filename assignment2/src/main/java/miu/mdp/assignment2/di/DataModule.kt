package miu.mdp.assignment2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.assignment2.data.ChemicalRepository
import miu.mdp.assignment2.data.ChemicalRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindChemicalRepository(repository: ChemicalRepositoryImpl): ChemicalRepository

}