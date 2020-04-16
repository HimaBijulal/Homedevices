package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addhouse extends AppCompatActivity implements View.OnClickListener {

    private EditText District,StreetName,HouseNo,Label;
    private Button Add,Cancel;
    private Builder b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhouse);
        District = (EditText) findViewById(R.id.EditText203);
        StreetName = (EditText) findViewById(R.id.editText);
        HouseNo = (EditText) findViewById(R.id.editText5);
        Label=(EditText) findViewById(R.id.editText2);
        Add = findViewById(R.id.AddHouseR);
        Cancel = findViewById(R.id.CancelRoomR);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        b= (Builder) getIntent().getSerializableExtra("User");
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.AddHouseR: {
                b.Addhouse(new House(StreetName.getText().toString(),District.getText().toString(),Integer.parseInt(HouseNo.getText().toString()),Label.getText().toString()));
                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);;
                startActivity(intent);
                break;
                // }
            }
            case R.id.CancelRoomR: {
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);;
                startActivity(intent);
            }
        }
    }


}
