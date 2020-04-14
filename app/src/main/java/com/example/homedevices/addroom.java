package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addroom extends AppCompatActivity implements View.OnClickListener {

    private EditText HouseL,RoomL;
    private Button Add,Cancel;
    private Builder b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhouse);
        HouseL = (EditText) findViewById(R.id.EditText204);
        RoomL = (EditText) findViewById(R.id.editText56);
        //Label=(EditText) findViewById(R.id.editText75)
        Add = findViewById(R.id.AddRoomR);
        Cancel = findViewById(R.id.CancelRoomR);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        b= (Builder) getIntent().getSerializableExtra("User");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.AddRoomR: {
                b.Addroom(HouseL,RoomL);
                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
                break;
                // }
            }
            case R.id.CancelRoomR: {
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            }
        }
}
