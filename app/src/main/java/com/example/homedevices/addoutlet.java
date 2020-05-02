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

public class addoutlet extends AppCompatActivity implements View.OnClickListener {
    private EditText OutletLabel;
    private Spinner HouseID,RoomID;
    private Builder b;
    private Button Cancel,add;
    private addoutlet d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b= (Builder) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoutlet);
        Cancel = findViewById(R.id.CancelOutletR);
        add = findViewById(R.id.AddOutletR);
        HouseID = (Spinner) findViewById(R.id.spinner1);
        RoomID = (Spinner) findViewById(R.id.spinner2);
        OutletLabel = (EditText)findViewById(R.id.OutletLabel);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getHouseLabels());
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HouseID.setAdapter(dataAdapter1);
        HouseID.setOnItemSelectedListener(new addoutlet.CustomOnItemSelectedListener());

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getRoomLabels(String.valueOf(HouseID.getSelectedItem())));
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoomID.setAdapter(dataAdapter2);
        RoomID.setOnItemSelectedListener(new addoutlet.CustomOnItemSelectedListener2());
        Cancel.setOnClickListener(this);
        add.setOnClickListener(this);
        d=this;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.AddOutletR: {
                        boolean sucess =b.AddOutlet(String.valueOf(HouseID.getSelectedItem()),String.valueOf(RoomID.getSelectedItem()),OutletLabel.getText().toString());
                        if(!sucess)
                            System.out.println("Label exists");


                Intent intent = new Intent(this, Dashboard.class).putExtra("User",b);
                startActivity(intent);
                break;

            }
            case R.id.CancelOutletR: {
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