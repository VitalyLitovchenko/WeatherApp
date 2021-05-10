package com.example.weatherapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherServiceAPI {

    @GET("weather?appid=0ddd8e43e63ee6299c574365f382708b&units=metric")
    Call<ApiClient> getCurrentWeatherData(@Query("q") String name);
}
