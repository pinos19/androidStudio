package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private Button mOkButton;
    private TextView detailsAfficheLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());
        mOkButton=findViewById(R.id.button_ok);
        detailsAfficheLogin=findViewById(R.id.details_affiche_login);
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        detailsAfficheLogin.setText(app.getLogin());
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(DetailsActivity.this, NewsActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}