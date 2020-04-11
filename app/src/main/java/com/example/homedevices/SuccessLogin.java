package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SuccessLogin extends AppCompatActivity {

    private TextView Sucess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Sucess=(TextView)findViewById(R.id.etSucess);


    }
}
