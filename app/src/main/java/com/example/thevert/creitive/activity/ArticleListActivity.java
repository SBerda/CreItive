package com.example.thevert.creitive.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.example.thevert.creitive.R;
import com.example.thevert.creitive.adapter.CustomAdapter;
import com.example.thevert.creitive.model.BlogList;
import com.example.thevert.creitive.network.GetDataService;
import com.example.thevert.creitive.network.RetrofitClientCreITive;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    public static Intent a1; //Definitely a bad practice, I need to improve this in future, this intent is used in CustomAdapter in the OnClick.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(ArticleListActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        GetDataService service = RetrofitClientCreITive.getRetrofitInstance().create(GetDataService.class);

        Call<List<BlogList>> call = service.getBlogs("application/json", "eaf57e2cb62755db708144c93b1f319dcda89871");
        call.enqueue(new Callback<List<BlogList>>() {

            @Override
            public void onResponse(Call<List<BlogList>> call, Response<List<BlogList>> response) {
                progressDoalog.dismiss();
                Log.i("MainActivity","Network API Call success");
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<BlogList>> call, Throwable t) {
                progressDoalog.dismiss();
                Log.e("MainActivity","Network API Call fail "+t.getMessage());
                Toast.makeText(ArticleListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<BlogList> blogList) {
        Log.i("MainActivity","Generating DataList");
        recyclerView = findViewById(R.id.customRecyclerView);
        a1= new Intent(this, ArticleActivity.class);
        adapter = new CustomAdapter(this,blogList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ArticleListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
