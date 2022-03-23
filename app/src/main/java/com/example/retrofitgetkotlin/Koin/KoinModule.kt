package com.example.retrofitgetkotlin.Koin

import com.example.retrofitgetkotlin.model.Engineer
import com.example.retrofitgetkotlin.model.Motor
import com.example.retrofitgetkotlin.viewmodel.MainViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val repositoryModule = module {

    fun provideApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    single { provideApi(get()) }

}

val callApi = module {
    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/api/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}

val koinRepository = module {
    single {
        KoinRepository(get())
    }
}

//provide dependency
val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val motorEngineer = module {
    single {
        Motor(get())
    }

    factory {
        Engineer()
    }
}



