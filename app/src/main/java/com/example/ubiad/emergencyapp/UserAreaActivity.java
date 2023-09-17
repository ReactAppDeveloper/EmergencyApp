package com.example.ubiad.emergencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        final TextView welcomeMessage = (TextView)findViewById(R.id.tvWelcomeMsg);

        Intent intent = getIntent();
        String name  = intent.getStringExtra("name");

        String message = "Welcome "+name+", ";
        welcomeMessage.setText(message);

    }
}
