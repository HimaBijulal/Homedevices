package com.example.homedevices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addAppliance extends AppCompatActivity implements View.OnClickListener {

    private EditText ApplianceL;
    private Button Add,Cancel;
    private Resident r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        r= (Resident) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addappliance;
        ApplianceL = (EditText) findViewById(R.id.ApplianceLabel);

        Add = findViewById(R.id.AddAppliance);
        Cancel = findViewById(R.id.Cancel);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.AddHouseR: {
                b.Addroom(String.valueOf(HouseL.getSelectedItem()),RoomL.getText().toString());
                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);
                startActivity(intent);
                break;
                // }
            }
            case R.id.CancelRoomR: {
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);
                startActivity(intent);
            }
        }
}



}}
