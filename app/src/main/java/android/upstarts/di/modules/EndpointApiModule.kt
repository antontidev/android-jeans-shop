package android.upstarts.di.modules

import android.upstarts.domain.EndpointApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class EndpointApiModule {
    @Provides
    @Singleton
    fun provideEndpointApi(): EndpointApi = Retrofit.Builder()
        .baseUrl("https://static.upstarts.work/tests/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EndpointApi::class.java)
}