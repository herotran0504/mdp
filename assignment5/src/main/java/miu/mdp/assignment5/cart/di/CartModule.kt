package miu.mdp.assignment5.cart.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.assignment5.cart.data.ProductRepository
import miu.mdp.assignment5.cart.data.ProductRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface CartModule {

    @Singleton
    @Binds
    fun bindProductRepository(repository: ProductRepositoryImpl): ProductRepository
}