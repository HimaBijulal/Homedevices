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

public class changeOwnership extends AppCompatActivity implements View.OnClickListener {

    private Spinner ResidentL;
    private Button Change,Cancel;
    private HouseOwner b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b= (HouseOwner) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeownership);
        ResidentL = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getResidants());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ResidentL.setAdapter(dataAdapter);

        Change = findViewById(R.id.change_button);
        Cancel = findViewById(R.id.CancelChange);
        Change.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        ResidentL.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_button: {
                b.changeownership(String.valueOf(ResidentL.getSelectedItem()));

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
            }
            case R.id.CancelChange: {
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
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    }
}


