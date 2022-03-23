package com.example.retrofitgetkotlin.Koin

class KoinRepository(val apiInterface: ApiInterface) {
    suspend fun getAllApi() = apiInterface.getWeatherByCity()
}