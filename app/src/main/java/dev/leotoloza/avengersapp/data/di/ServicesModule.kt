package dev.leotoloza.avengersapp.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.leotoloza.avengersapp.data.service.AvengersClient
import dev.leotoloza.avengersapp.data.service.security.HashKeyBuilder
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
private const val AVENGERS_API_URL = "https://gateway.marvel.com/v1/public/"

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AVENGERS_API_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideAvengersApiClient(retrofit: Retrofit): AvengersClient {
        return retrofit.create(AvengersClient::class.java)
    }

    @Provides
    @Singleton
    fun provideHashKeyBuilder(): HashKeyBuilder{
        return HashKeyBuilder()
    }
}