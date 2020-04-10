package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.EntityIterator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = findViewById(R.id.etLoginButton);
        Login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etLoginButton: {
               // if (Username.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                    Intent intent = new Intent(this, Success.class);
                    startActivity(intent);
                    System.out.println("NoBlahPls");
                    System.out.println("Blah");
                    System.out.println("Hello");
                    break;
               // }
            }
        }
    }


}