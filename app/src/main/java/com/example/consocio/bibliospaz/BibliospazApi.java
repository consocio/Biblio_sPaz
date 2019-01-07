package com.example.consocio.bibliospaz;

import com.example.consocio.bibliospaz.Utils.Login;
import com.example.consocio.bibliospaz.Utils.Me;
import com.example.consocio.bibliospaz.Utils.Refresh;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BibliospazApi {

    @Headers({"Accept: application/json"})
    @POST("v1/auth/login")
    Call<Login> newLogin(@Body Login login);

    @POST("v1/auth/me")
    Call<Me> getUserInfo(
            @Header("Authorization") String token
    );

    @POST("v1/auth/refresh")
    Call<Refresh> refreshUser(
            @Header("Authorization") String token
    );


}
