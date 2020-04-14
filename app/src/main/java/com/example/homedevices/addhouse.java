package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addhouse extends AppCompatActivity implements View.OnClickListener {

    private EditText District,StreetName,HouseNo;
    private Button Add,Cancel;
    private Builder b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhouse);
        District = (EditText) findViewById(R.id.EditText203);
        StreetName = (EditText) findViewById(R.id.editText);
        HouseNo = (EditText) findViewById(R.id.editText2);
        //Label=(EditText) findViewById(R.id.editText75)
        Add = findViewById(R.id.AddHouseH);
        Cancel = findViewById(R.id.CancelHouseH);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        b= (Builder) getIntent().getSerializableExtra("User");
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.AddHouseH: {
                b.Addhouse(StreetName,District,HouseNo,Label);
                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
                break;
                // }
            }
            case R.id.CancelHouseHB: {
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            }
        }
    }


}
