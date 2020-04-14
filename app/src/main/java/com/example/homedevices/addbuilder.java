package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class addbuilder extends AppCompatActivity implements View.OnClickListener, Serializable {

    private EditText Name, EmiratesID, PhoneNo, Username, Password;
    private Button Add, Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbuilder);
        Name = (EditText) findViewById(R.id.editTextN);
        EmiratesID = (EditText) findViewById(R.id.editText);
        PhoneNo = (EditText) findViewById(R.id.editText2);
        Username = (EditText) findViewById(R.id.editText3);
        Password = (EditText) findViewById(R.id.editText4);
        Add = findViewById(R.id.AddBuilderB);
        Cancel = findViewById(R.id.CancelBuilderB);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        getIntent().getSerializableExtra("User");
        switch (v.getId()) {
            case R.id.AddBuilderB: {
                // if (Username.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                //Builder b=new Builder(Name.getText().toString(), EmiratesID.getText()., PhoneNo.getText().toString(), Username.getText().toString(), Password.getText().toString());
                Intent intent = getIntent();
                Builder c= (Builder) intent.getSerializableExtra("User");
                System.out.println(c.getEmail());
                startActivity(intent);


                break;
                // }
            }
            case R.id.CancelBuilderB: {
                //setContentView(R.layout.activity_cancel);// create layout with "operation cancelled"
            }
        }
    }
}