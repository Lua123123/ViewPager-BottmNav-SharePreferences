//package com.example.retrofitgetkotlin.Presenter;
//
//
//import com.example.retrofitgetkotlin.API.APIGet;
//import com.example.retrofitgetkotlin.API.APIPost;
//import com.example.retrofitgetkotlin.Model.User;
//import com.example.retrofitgetkotlin.Model.Weather;
//import com.example.retrofitgetkotlin.View.IView;
//
//import java.util.ArrayList;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class Presenter implements IPresenter {
//    private IView iView;
//
//    public Presenter(IView iView) {
//        this.iView = iView;
//    }
//
//    public void clickPostApi() {
//        User user = new User(10, 1, "Nhat Anh", "TMA Channel");
//        APIPost.apiPost.getUser.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                //Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
//                User users = response.body();
//                if (users != null) {
//                    iView.postApiData(users);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                //Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void clickCallApi() {
//        APIGet.apiGet.getWeatherByCity().enqueue(new Callback<ArrayList<Weather>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Weather>> call, Response<ArrayList<Weather>> response) {
//                //Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
//
//                ArrayList<Weather> weathers = response.body();
//                if (weathers != null && !weathers.isEmpty()) {
//                    iView.onData(weathers);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Weather>> call, Throwable t) {
//                //Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
