package com.example.thevert.creitive.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.thevert.creitive.R;
import com.example.thevert.creitive.model.BlogList;
import com.example.thevert.creitive.network.GetDataService;
import com.example.thevert.creitive.network.RetrofitClientCreITive;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        GetDataService service = RetrofitClientCreITive.getRetrofitInstance().create(GetDataService.class);

        Call<List<BlogList>> call = service.getBlogs("application/json", "eaf57e2cb62755db708144c93b1f319dcda89871");
        call.enqueue(new Callback<List<BlogList>>() {

            @Override
            public void onResponse(Call<List<BlogList>> call, Response<List<BlogList>> response) {
                Log.i("MainActivity","Network API Call success");
                Log.i("Article list", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<List<BlogList>> call, Throwable t) {
                Log.e("MainActivity","Network API Call fail "+t.getMessage());
                Toast.makeText(ArticleListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
