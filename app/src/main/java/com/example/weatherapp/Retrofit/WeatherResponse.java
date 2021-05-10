package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("temp")
    public float temp;

    @SerializedName("humidity")
    public float humidity;

    @SerializedName("pressure")
    public float pressure;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

}

