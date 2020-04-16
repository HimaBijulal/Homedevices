package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class delroom extends AppCompatActivity implements View.OnClickListener{
    private Spinner HouseID,RoomID;
    private Builder b;
    private Button Cancel,delete;
    private delroom d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b= (Builder) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delroom);
        Cancel = findViewById(R.id.CancelRoomR);
        delete = findViewById(R.id.delroom_button);
        HouseID = (Spinner) findViewById(R.id.spinner1);
        RoomID = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getHouseLabels());
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HouseID.setAdapter(dataAdapter1);
        HouseID.setOnItemSelectedListener(new delroom.CustomOnItemSelectedListener());

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getRoomLabels(String.valueOf(HouseID.getSelectedItem())));
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoomID.setAdapter(dataAdapter2);
        RoomID.setOnItemSelectedListener(new delroom.CustomOnItemSelectedListener2());
        Cancel.setOnClickListener(this);
        delete.setOnClickListener(this);
        d=this;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.delroom_button: {
                b.Removeroom(String.valueOf(HouseID.getSelectedItem()),String.valueOf(RoomID.getSelectedItem()));
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

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            parent.getSelectedItem();
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(d,
                    android.R.layout.simple_spinner_item, b.getRoomLabels(String.valueOf(HouseID.getSelectedItem())));
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            RoomID.setAdapter(dataAdapter2);

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    }

    public class CustomOnItemSelectedListener2 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    }


}

