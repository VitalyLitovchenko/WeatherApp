package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class ApiClient {

    @SerializedName("main")
    private WeatherResponse weatherResponse;

    @SerializedName("wind")
    private WindResponse windResponse;

    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }

    public void setWeatherResponse(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public WindResponse getWindResponse() {
        return windResponse;
    }

    public void setWindResponse(WindResponse windResponse) {
        this.windResponse = windResponse;
    }
}


