package com.vahid.cryptocurency.di

import com.vahid.cryptocurency.common.Constants
import com.vahid.cryptocurency.data.remote.CoinApi
import com.vahid.cryptocurency.data.repository.CoinRepositoryImp
import com.vahid.cryptocurency.domain.repository.Coinrepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): Coinrepository {
        return CoinRepositoryImp(api)
    }

}