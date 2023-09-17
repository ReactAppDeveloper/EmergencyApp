package com.example.ubiad.emergencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etAge = (EditText)findViewById(R.id.etAge);
        final EditText etName = (EditText)findViewById(R.id.etName);
        final EditText etUsername = (EditText)findViewById(R.id.etUsername);
        final EditText etPassword = (EditText)findViewById(R.id.etPassword);
        final Button bRegister = (Button)findViewById(R.id.bRegister);
        final Button w = (Button)findViewById(R.id.signin);

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(i);
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String age = (etAge.getText().toString());

                Response.Listener<String> responseListener  = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                              JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    RegisterActivity.this.startActivity(intent);
                                }
                            }catch(JSONException e){
                                e.printStackTrace();
                            }
                        }
                    };
                if (etName.getText().length()==0){
                    etName.setError("Please");
                }
                else if(etUsername.getText().length()==0)
                {
                    etUsername.setError("Please");
                } else if(etAge.getText().length()==0)
                {
                    etAge.setError("Please");
                }else if (etPassword.getText().length()==0)
                {
                    etPassword.setError("Please");
                }
                else
                {
                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
                }
            }
        });
    }
}



