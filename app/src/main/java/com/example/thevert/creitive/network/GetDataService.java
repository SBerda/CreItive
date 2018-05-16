package com.example.thevert.creitive.network;

import com.example.thevert.creitive.model.LoginCredentials;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface GetDataService {

    @POST("/login")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    Call<ResponseBody> loginWithCredentials(@Body LoginCredentials data);

}


