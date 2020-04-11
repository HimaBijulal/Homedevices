package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private Button add_builder,add_house,del_house,add_room,del_room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        add_builder = findViewById(R.id.addbuilder_button);
        add_house = findViewById(R.id.addhouse_button);
        del_house = findViewById(R.id.delhouse_button);
        add_room = findViewById(R.id.addroom_button);
        del_room=findViewById(R.id.delroom_button);

        add_builder.setOnClickListener(this);
        add_house.setOnClickListener(this);
        del_house.setOnClickListener(this);
        add_room.setOnClickListener(this);
        del_room.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addbuilder_button: {

                Intent intent = new Intent(this, addbuilder.class);
                startActivity(intent);
                break;

            }
            case R.id.addhouse_button:{
                Intent intent = new Intent(this, addhouse.class);
                startActivity(intent);
                break;
            }
            case R.id.delhouse_button:{
                Intent intent = new Intent(this, delhouse.class);
                startActivity(intent);
                break;
            }
            case R.id.addroom_button:{
                Intent intent = new Intent(this, addroom.class);
                startActivity(intent);
                break;
            }
            case R.id.delroom_button:{
                Intent intent = new Intent(this, delroom.class);
                startActivity(intent);
                break;
            }
        }
    }
}
