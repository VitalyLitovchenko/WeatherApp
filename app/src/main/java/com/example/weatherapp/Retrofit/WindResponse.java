package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class WindResponse {

    @SerializedName("speed")
    public float speed;

    @SerializedName("deg")
    public float deg;

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public float getSpeed() {
            return speed;
        }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
