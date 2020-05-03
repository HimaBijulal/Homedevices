package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

    public class viewReport extends AppCompatActivity implements View.OnClickListener{

    private Spinner HouseID,RoomID,outletID;
    private Resident b;
    private viewReport d;
    private Button generate,cancel;
    private TextView power;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_report);


        b= (Resident) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        HouseID = (Spinner) findViewById(R.id.housespinner);
        RoomID = (Spinner) findViewById(R.id.roomspinner);
        outletID = (Spinner)findViewById(R.id.outletspinner);
        generate= (Button) findViewById(R.id.Generate);
        cancel =(Button)findViewById(R.id.cancelPower);
        //------------------------------------------------------------------------------
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getHouseLabel());
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HouseID.setAdapter(dataAdapter1);
        HouseID.setOnItemSelectedListener(new viewReport.HouseIDListner());

        //------------------------------------------------------------------------------
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getRoomLabels());
        //dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoomID.setAdapter(dataAdapter2);
        RoomID.setOnItemSelectedListener(new viewReport.RoomIDListner());
        //--------------------------------------------------------------------------------
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getPluggedOutletLabels(String.valueOf(RoomID.getSelectedItem())));
        outletID.setAdapter(dataAdapter3);
        outletID.setOnItemSelectedListener(new viewReport.OutletIDListner());

        generate.setOnClickListener(this);
        cancel.setOnClickListener(this);
        d=this;
    }
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.Generate: {
                    double usage=b.GenerateReport(String.valueOf(RoomID.getSelectedItem()),String.valueOf(outletID.getSelectedItem()));
                    //Add builder object to list of builders
                    power.setText(Double.toString(usage) +" KWh");
                    Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);
                    startActivity(intent);
                    break;
                    // }
                }
                case R.id.cancelPower: {
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
                        android.R.layout.simple_spinner_item, b.getRoomLabels());
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                RoomID.setAdapter(dataAdapter2);
                ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(d,
                        android.R.layout.simple_spinner_item, b.getPluggedOutletLabels(String.valueOf(RoomID.getSelectedItem())));
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
                        android.R.layout.simple_spinner_item, b.getPluggedOutletLabels(String.valueOf(RoomID.getSelectedItem())));
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

