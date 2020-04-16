package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class addbuilder extends AppCompatActivity implements View.OnClickListener, Serializable {

    private EditText Name, EmiratesID, PhoneNo, Username, Password,EmailAddress;
    private Button Add, Cancel;
    private Admin c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FileIO builderfile=new FileIO()
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbuilder);
        Name = (EditText) findViewById(R.id.edittext5);
        EmiratesID = (EditText) findViewById(R.id.editText);
        PhoneNo = (EditText) findViewById(R.id.editText2);
        Username = (EditText) findViewById(R.id.editText3);
        Password = (EditText) findViewById(R.id.editText4);
        Add = findViewById(R.id.button2);
        Cancel = findViewById(R.id.cancelbutton);
        EmailAddress=findViewById(R.id.emailbuild);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        c= (Admin) getIntent().getSerializableExtra("User");



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button2: {
                // if (Username.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                //Builder b=new Builder(Name.getText().toString(), EmiratesID.getText()., PhoneNo.getText().toString(), Username.getText().toString(), Password.getText().toString());
                //Builder c= (Builder) getIntent().getSerializableExtra("User");
                //System.out.println(c.getEmail()+"");
                c.AddBuilder(Name,EmiratesID,PhoneNo,EmailAddress,Username,Password);
                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
                break;
                // }
            }
            case R.id.CancelBuilderB: {
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            }
        }
    }
}