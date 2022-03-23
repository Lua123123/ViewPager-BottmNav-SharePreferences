package com.example.retrofitgetkotlin.view;

import com.example.retrofitgetkotlin.model.User;
import com.example.retrofitgetkotlin.model.Weather;

import java.util.ArrayList;

public interface IView {
    void onData(ArrayList<Weather> weathers);
    void postApiData(User user);
}
