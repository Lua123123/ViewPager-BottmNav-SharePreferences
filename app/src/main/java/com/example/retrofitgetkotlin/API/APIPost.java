package com.example.retrofitgetkotlin.API;

import com.example.retrofitgetkotlin.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIPost {
    APIPost apiPost = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // API base url
            .addConverterFactory(GsonConverterFactory.create()) // Factory phụ thuộc vào format JSON trả về
            .build()
            .create(APIPost.class);

    @POST("posts")
    Call<User> getUser(@Body User user);
}
