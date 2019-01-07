package com.example.consocio.bibliospaz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public static BibliospazApi init(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        String url = "https://dev.lospaz.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(BibliospazApi.class);


    }

}
