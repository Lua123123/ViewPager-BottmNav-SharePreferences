package com.example.retrofitgetkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitgetkotlin.API.APIPost
import com.example.retrofitgetkotlin.Koin.KoinRepository
import com.example.retrofitgetkotlin.model.User
import com.example.retrofitgetkotlin.model.Weather
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val koinRepository: KoinRepository) : ViewModel() {
    //chứa dứ liệu
    //thông qua viewmodel để share dữ liệu giữa các màn hình
    val mWeathers = MutableLiveData<ArrayList<Weather>>()
    val mUsers = MutableLiveData<User>()

    //COROUTINES
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null

    //xử lý một ngoại lệ bằng cách sử dụng một trình xử lý ngoại lệ coroutine chung
    // gọi là CoroutineExceptionHandler
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun mutableLiveDataClickCallApi() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            var s: Response<ArrayList<Weather>> = koinRepository.getAllApi()
            withContext(Dispatchers.Main){
                val weathers = s.body()
                if (weathers != null && !weathers.isEmpty()) {
                    mWeathers.postValue(weathers!!)
                    loading.value = false
                } else {
                    onError("Error : ${s.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun mutableLiveDataClickPostApi() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            clickPostApi()
        }
    }

    fun clickPostApi() {
        val user = User(10, 1, "Nhat Anh", "TMA Channel")
        APIPost.apiPost.getUser(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val users = response.body()
                if (users != null) {
                    mUsers.postValue(users!!)
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
    }
}