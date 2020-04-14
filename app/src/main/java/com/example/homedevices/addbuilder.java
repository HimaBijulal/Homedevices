package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addbuilder extends AppCompatActivity implements View.OnClickListener{

    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbuilder);
        cancel = findViewById(R.id.cancelbutton);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etLoginButton: {
                // if (Username.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
                break;
                // }
            }
        }
    }
}
