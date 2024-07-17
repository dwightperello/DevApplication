package com.example.devopsapplicatioin.di

import android.content.Context
import com.example.devopsapplicatioin.data.remote.network.APIservice
import com.example.devopsapplicatioin.data.remote.network.NetworkBuilder
import com.example.devopsapplicatioin.data.remote.repository.mainItemRepositoryImpl
import com.example.devopsapplicatioin.domain.remote.repository.maintItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideNetworkService(@ApplicationContext context: Context): Retrofit {
        return NetworkBuilder.create(
            "http://192.168.1.12:8089",
            context.cacheDir,
            (10 * 1024 * 1024).toLong()
        )
    }

    @Provides
    @Singleton
    fun provideAPICalls(retrofit: Retrofit): APIservice {
        return NetworkBuilder.provideAPICalls(retrofit = retrofit)
    }

    @Provides
    @Singleton
    fun provideMainItemService(apIservice: APIservice): maintItemRepository = mainItemRepositoryImpl(apIservice)
}