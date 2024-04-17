package miu.mdp.assignment6.sport.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SportsModule {

    @Singleton
    @Provides
    fun provideGlideRequestManager(context: Context): RequestManager = Glide.with(context)

}
