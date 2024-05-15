package miu.mdp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import miu.mdp.core.provider.DispatchProvider
import miu.mdp.core.provider.DispatchProvidersImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface CoreModule {

    @Binds
    fun bindDispatchProvider(provider: DispatchProvidersImpl): DispatchProvider

}