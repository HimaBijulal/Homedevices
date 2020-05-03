package com.example.homedevices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class linkAppliance extends AppCompatActivity implements View.OnClickListener{
    private Spinner OutletID,RoomID,ApplianceID;
    private Resident r;
    private Button Cancel,link;
    private linkAppliance d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        r= (Resident) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkappliance);
        Cancel = findViewById(R.id.Cancel);
        link = findViewById(R.id.link);
        RoomID = (Spinner) findViewById(R.id.spinner0);
        OutletID = (Spinner) findViewById(R.id.spinner1);
        ApplianceID = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, r.getRoomLabels());
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoomID.setAdapter(dataAdapter1);
        RoomID.setOnItemSelectedListener(new linkAppliance.CustomOnItemSelectedListener());

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, r.getUnpluggedOutletLabels(String.valueOf(RoomID.getSelectedItem())));
        RoomID.setAdapter(dataAdapter2);
        RoomID.setOnItemSelectedListener(new linkAppliance.CustomOnItemSelectedListener2());

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, r.getUnpluggedApplianceLabels());
        ApplianceID.setAdapter(dataAdapter3);
        ApplianceID.setOnItemSelectedListener(new linkAppliance.CustomOnItemSelectedListener2());


        Cancel.setOnClickListener(this);
        link.setOnClickListener(this);
        d=this;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.link: {
                try {
                    r.linkAppliance(String.valueOf(RoomID.getSelectedItem()),String.valueOf(OutletID.getSelectedItem()),String.valueOf(ApplianceID.getSelectedItem()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(this, Dashboard.class).putExtra("User",r);
                startActivity(intent);
                break;
            }
            case R.id.Cancel: {
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",r);
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
                    android.R.layout.simple_spinner_item, r.getUnpluggedOutletLabels(String.valueOf(RoomID.getSelectedItem())));
            RoomID.setAdapter(dataAdapter2);
            RoomID.setOnItemSelectedListener(new linkAppliance.CustomOnItemSelectedListener2());

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

