package com.example.td6;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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
    private TextView textViewResult;
    private GithubService githubService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textViewResult =findViewById(R.id.text_view_result);

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
                    textViewResult.setText("Code : "+response.code());
                    return;
                }
                RepoList repos = response.body();
                int taille = repos.getSize();
                for(int i=0;i<taille;i++){
                    Repo repo = repos.getItems(i);
                    String content="";
                    content += "ID : "+repo.getId() + "\n";
                    content += "Name : "+repo.getName() +"\n";
                    content += "Full nam : "+repo.getFull_name()+"\n\n";
                    textViewResult.append(content);

                }
            }
            @Override
            public void onFailure(Call<RepoList> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

}
