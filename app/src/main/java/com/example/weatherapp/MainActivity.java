package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.WeatherClient;
import com.example.weatherapp.Retrofit.WeatherServiceAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


     private TextView textViewCity, textViewTemp, textViewHumidity, textViewWindSpeed;
     ImageView imageViewSearch;
     EditText editTextCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCity = (TextView) findViewById(R.id.textViewCity);
        textViewTemp = (TextView) findViewById(R.id.textViewTemp);
        textViewHumidity = (TextView) findViewById(R.id.textViewHumidity);
        textViewWindSpeed = (TextView) findViewById(R.id.textViewWindSpeed);
        imageViewSearch = (ImageView) findViewById(R.id.imageViewSearch);
        editTextCity = (EditText) findViewById(R.id.editTextCity);

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getCurrentWeatherData(editTextCity.getText().toString().trim());

                textViewCity.setText("" + editTextCity.getText().toString());
            }
        });

        editTextCity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                editTextCity.setHint("");
            }
        });
    }

    private void getCurrentWeatherData(String name){

       WeatherServiceAPI weatherServiceAPI = WeatherClient.getRetrofit().create(WeatherServiceAPI.class);

        Call<ApiClient> call = weatherServiceAPI.getCurrentWeatherData(name);

        call.enqueue(new Callback<ApiClient>() {
            @Override
            public void onResponse(Call<ApiClient> call, Response<ApiClient> response) {

                if (response.code() == 200) {

                    textViewTemp.setText("Температура: " + response.body().getWeatherResponse().getTemp() + " °C");
                    textViewHumidity.setText("Влажность: " + response.body().getWeatherResponse().getHumidity() + " %");
                    textViewWindSpeed.setText("Скорость ветра: " + response.body().getWindResponse().getSpeed() + " м/с");


                }
            }

            @Override
            public void onFailure(Call<ApiClient> call, Throwable t) {

            }
        });
    }
}