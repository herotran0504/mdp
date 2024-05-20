package miu.mdp.extra.di

import miu.mdp.extra.data.MessageRepository
import miu.mdp.extra.data.MessageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindMessageRepository(repository: MessageRepositoryImpl): MessageRepository

}