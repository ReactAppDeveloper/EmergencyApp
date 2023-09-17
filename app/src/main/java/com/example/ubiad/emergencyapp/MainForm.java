package com.example.ubiad.emergencyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainForm extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainform);
        final Button si = (Button)findViewById(R.id.signin);
        final Button su = (Button)findViewById(R.id.signup);

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainForm.this, LoginActivity.class);
                MainForm.this.startActivity(i);
            }
        });
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(MainForm.this, RegisterActivity.class);
                MainForm.this.startActivity(w);
            }
        });


    }
}
