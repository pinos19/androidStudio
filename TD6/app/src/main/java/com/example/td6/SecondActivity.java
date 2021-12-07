package com.example.td6;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class SecondActivity extends AppCompatActivity {
    private GithubService githubService;
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        Intent intent = getIntent();
        String repository_str="";
        if (intent.hasExtra("repository")){
            repository_str = intent.getStringExtra("repository");
        }

        githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        getReposList(repository_str);


    }
    private void getReposList(String repoString){
        Call<RepoList> call = githubService.searchRepos(repoString);
        call.enqueue(new Callback<RepoList>(){
            @Override
            public void onResponse(Call<RepoList> call, Response<RepoList> response) {
                if(!response.isSuccessful() ){
                    Log.i("ERROR CODE",String.valueOf(response.code()));
                    return;
                }
                RepoList repos = response.body();
                recyclerView = findViewById(R.id.recyclerView);
                MyAdapter myAdapter = new MyAdapter(repos,SecondActivity.this);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(SecondActivity.this));
            }
            @Override
            public void onFailure(Call<RepoList> call, Throwable t) {
                Log.i("ON FAILURE",t.getMessage());
            }
        });
    }

}
