package miu.mdp.assignment4.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.assignment4.data.CategoryRepository
import miu.mdp.assignment4.data.CategoryRepositoryImpl
import miu.mdp.assignment4.data.UserRepository
import miu.mdp.assignment4.data.UserRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Singleton
    @Binds
    fun bindCategoryRepository(repository: CategoryRepositoryImpl): CategoryRepository

    @Singleton
    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository
}
