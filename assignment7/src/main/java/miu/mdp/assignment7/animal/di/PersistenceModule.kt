package miu.mdp.assignment7.animal.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.assignment7.animal.persistence.database.AnimalDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) = AnimalDatabase.getInstance(context)

    @Provides
    fun provideAnimalDao(database: AnimalDatabase) = database.animalDao()

    @Provides
    fun provideSpeciesDao(database: AnimalDatabase) = database.speciesDao()
}
