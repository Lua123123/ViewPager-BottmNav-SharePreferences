//package com.example.retrofitgetkotlin.API
//
//import com.example.retrofitgetkotlin.Model.Weather
//import retrofit2.Call
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//
//interface APIGet {
//    @GET("location/search/?query=london")
//    suspend fun getWeatherByCity(): Call<ArrayList<Weather>>
//
//    companion object {
//        var apiGet: APIGet? = null
//        fun getInstance(): APIGet {
//            if(apiGet == null) {
//                val api = Retrofit.Builder()
//                    .baseUrl("https://www.metaweather.com/api/") // API base url
//                    .addConverterFactory(GsonConverterFactory.create()) // Factory phụ thuộc vào format JSON trả về
//                    .build()
//                apiGet = api
//                    .create(APIGet::class.java)
//            }
//            return apiGet!!
//        }
//    }
//}