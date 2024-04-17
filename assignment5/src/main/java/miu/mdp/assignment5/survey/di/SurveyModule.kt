package miu.mdp.assignment5.survey.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.assignment5.survey.data.Repository
import miu.mdp.assignment5.survey.data.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface SurveyModule {

    @Singleton
    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository

}
