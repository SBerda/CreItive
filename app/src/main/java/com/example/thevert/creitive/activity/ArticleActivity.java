package com.example.thevert.creitive.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.thevert.creitive.Constants;
import com.example.thevert.creitive.R;
import com.example.thevert.creitive.model.Article;
import com.example.thevert.creitive.network.GetDataService;
import com.example.thevert.creitive.network.RetrofitClientCreITive;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//This Activity is used to display blog articles

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        //Network API Request
        GetDataService service = RetrofitClientCreITive.getRetrofitInstance().create(GetDataService.class);
        Call<Article> call = service.getArticle(Constants.Token,"application/json", Constants.CurrentArticle);
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
            //    Log.i("ArticleActivity","API Article request Done");
                final String reponseContent = response.body().getContent();
                //Probably not the best way to display HTML
                WebView webView =  findViewById(R.id.WebView2);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadData(reponseContent, "text/html; charset=utf-8", "UTF-8");
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
               // Log.e("ArticleActivity","Error calling API "+t.getMessage());
            }
        });



    }
}
