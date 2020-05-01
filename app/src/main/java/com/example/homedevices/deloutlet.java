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

public class deloutlet extends AppCompatActivity implements View.OnClickListener{
    private Spinner HouseID,RoomID,outletID;
    private Builder b;
    private Button Cancel,delete;
    private deloutlet d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b= (Builder) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deloutlet);
        Cancel = findViewById(R.id.CanceloutletR);
        delete = findViewById(R.id.deloutlet_button);
        HouseID = (Spinner) findViewById(R.id.spinner1);
        RoomID = (Spinner) findViewById(R.id.spinner2);
        outletID = (Spinner)findViewById(R.id.spinner3);
        //------------------------------------------------------------------------------
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getHouseLabels());
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HouseID.setAdapter(dataAdapter1);
        HouseID.setOnItemSelectedListener(new HouseIDListner());

        //------------------------------------------------------------------------------
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getRoomLabels(String.valueOf(HouseID.getSelectedItem())));
        //dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoomID.setAdapter(dataAdapter2);
        RoomID.setOnItemSelectedListener(new RoomIDListner());
        //--------------------------------------------------------------------------------
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getOutletLabels(String.valueOf(HouseID.getSelectedItem()),String.valueOf(RoomID.getSelectedItem())));
        outletID.setAdapter(dataAdapter3);
        outletID.setOnItemSelectedListener(new OutletIDListner());
        Cancel.setOnClickListener(this);
        delete.setOnClickListener(this);
        d=this;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.deloutlet_button: {
                b.Removeoutlet(String.valueOf(HouseID.getSelectedItem()),String.valueOf(RoomID.getSelectedItem()),String.valueOf(outletID.getSelectedItem()));
                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);
                startActivity(intent);
                break;
                // }
            }
            case R.id.CanceloutletR: {
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);
                startActivity(intent);
            }

        }




    }

    public class HouseIDListner implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            parent.getSelectedItem();
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(d,
                    android.R.layout.simple_spinner_item, b.getRoomLabels(String.valueOf(HouseID.getSelectedItem())));
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            RoomID.setAdapter(dataAdapter2);
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(d,
                    android.R.layout.simple_spinner_item, b.getOutletLabels(String.valueOf(HouseID.getSelectedItem()),String.valueOf(RoomID.getSelectedItem())));
            outletID.setAdapter(dataAdapter3);

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    }

    public class RoomIDListner implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
            parent.getSelectedItem();
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(d,
                    android.R.layout.simple_spinner_item, b.getOutletLabels(String.valueOf(HouseID.getSelectedItem()),String.valueOf(RoomID.getSelectedItem())));
            outletID.setAdapter(dataAdapter3);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    }
    public class OutletIDListner implements AdapterView.OnItemSelectedListener {

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

