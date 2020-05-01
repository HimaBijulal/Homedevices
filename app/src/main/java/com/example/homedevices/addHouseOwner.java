package com.example.homedevices;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class addHouseOwner extends AppCompatActivity implements View.OnClickListener, Serializable {

    private EditText Name, EmiratesID, PhoneNo, Username, Password,EmailAddress;
    private Button Add, Cancel;
    private Spinner HouseL;
    private Builder c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addHouseOwner);
        Name = (EditText) findViewById(R.id.edittext5);
        EmiratesID = (EditText) findViewById(R.id.editText);
        PhoneNo = (EditText) findViewById(R.id.editText2);
        Username = (EditText) findViewById(R.id.editText3);
        Password = (EditText) findViewById(R.id.editText4);
        Add = findViewById(R.id.button2);
        Cancel = findViewById(R.id.cancelbutton);
        HouseL = (Spinner) findViewById(R.id.spinner0);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, c.getHouseLabels());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HouseL.setAdapter(dataAdapter);
        EmailAddress=findViewById(R.id.emailbuild);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        HouseL.setOnItemSelectedListener(new addHouseOwner.CustomOnItemSelectedListener());
        c= (Builder) getIntent().getSerializableExtra("User");



    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button2: {

                //boolean NF,IDF,PF,UF,PWF,EF;
                Builder b;
                if(!User.isValidName(Name.getText().toString()))
                    System.out.println("NameError");
                else if(!User.isValidID(EmiratesID.getText().toString()))
                    System.out.println("IDError");
                else if(!User.isValidPhoneNum(PhoneNo.getText().toString()))
                    System.out.println("PhoneNumError");
                else if(!User.isValidEmail(EmailAddress.getText().toString()))
                    System.out.println("EmailError");
                else if(!User.isValidUsername(Username.getText().toString()))
                    System.out.println("UsernameError");
                else if(!User.isValidPassword(Password.getText().toString()))
                    System.out.println("PasswordError");
                else
                    c.addHouseOwner(String.valueOf(HouseL.getSelectedItem()),new HouseOwner(Name.getText().toString(), EmiratesID.getText().toString(),
                            PhoneNo.getText().toString(), EmailAddress.getText().toString(),
                            Username.getText().toString(), Password.getText().toString()));


                //Add builder object to list of builders
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);;
                startActivity(intent);
                break;
                // }
            }
            case R.id.cancelbutton: {
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);;

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