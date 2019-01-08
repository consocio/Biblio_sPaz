package com.example.consocio.bibliospaz;

import com.example.consocio.bibliospaz.Models.Login;
import com.example.consocio.bibliospaz.Models.Me;
import com.example.consocio.bibliospaz.Models.Refresh;
import com.example.consocio.bibliospaz.Models.Responso;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
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
    @GET("v1/library/books")
    Call<ResponseBody> getBookResponse(
            @Header("Authorization") String token,
            @Header("Accept") String method
    );
}
