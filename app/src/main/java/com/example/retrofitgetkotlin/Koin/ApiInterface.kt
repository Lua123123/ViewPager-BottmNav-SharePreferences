package com.example.retrofitgetkotlin.Koin

import com.example.retrofitgetkotlin.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import java.util.ArrayList

interface ApiInterface {
    @GET("location/search/?query=london")
    suspend fun getWeatherByCity(): Response<ArrayList<Weather>>
}