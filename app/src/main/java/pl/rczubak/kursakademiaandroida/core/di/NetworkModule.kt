package pl.rczubak.kursakademiaandroida.core.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.rczubak.kursakademiaandroida.BuildConfig
import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
    }

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
    }

    single { get<Retrofit>().create(RickAndMortyApi::class.java) }
}