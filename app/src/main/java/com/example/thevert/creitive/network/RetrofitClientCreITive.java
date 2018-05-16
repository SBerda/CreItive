package com.example.thevert.creitive.network;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClientCreITive {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://blogsdemo.creitiveapps.com";

    public static Retrofit getRetrofitInstance() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        OkHttpClient client = httpClient.build();

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
