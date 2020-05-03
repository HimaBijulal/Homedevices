package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private Button add_builder,add_house,del_house,add_room,del_room,Logoff,add_outlet,del_outlet,view_report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        User c= (User) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_copy);
        add_builder = findViewById(R.id.addbuilder_button);
        add_house = findViewById(R.id.addhouse_button);
        del_house = findViewById(R.id.delhouse_button);
        add_room = findViewById(R.id.addroom_button);
        del_room=findViewById(R.id.delroom_button);
        Logoff = findViewById(R.id.etLogOffButton);
        add_outlet = findViewById(R.id.addoutlet_button);
        del_outlet = findViewById(R.id.deloutlet_button);
        view_report=findViewById(R.id.ViewReport);
        Logoff.setOnClickListener(this);

        if(c instanceof Admin){
            add_builder.setOnClickListener(this);
            add_house.setVisibility(View.GONE);
            del_house.setVisibility(View.GONE);
            add_room.setVisibility(View.GONE);
            del_room.setVisibility(View.GONE);
            add_outlet.setVisibility(View.GONE);
            del_outlet.setVisibility(View.GONE);


        }
        else if(c instanceof Builder){
            add_house.setOnClickListener(this);
            del_house.setOnClickListener(this);
            add_room.setOnClickListener(this);
            del_room.setOnClickListener(this);
            add_outlet.setOnClickListener(this);
            del_outlet.setOnClickListener(this);
            add_builder.setVisibility(View.GONE);
        }
        else if (!( c instanceof HouseOwner) && (c instanceof Resident)) {
            add_builder.setVisibility(View.GONE);
            add_house.setVisibility(View.GONE);
            del_house.setVisibility(View.GONE);
            add_room.setVisibility(View.GONE);
            del_room.setVisibility(View.GONE);
            add_outlet.setVisibility(View.GONE);
            del_outlet.setVisibility(View.GONE);
            view_report.setOnClickListener(this);
        }



    }
    @Override
    public void onClick(View v) {
        User c= (User) getIntent().getSerializableExtra("User");
        switch (v.getId()) {
            case R.id.addbuilder_button: {

                Intent intent = new Intent(this, addbuilder.class).putExtra("User",c);;
                startActivity(intent);
                break;

            }
            case R.id.addhouse_button:{
                Intent intent = new Intent(this, addhouse.class).putExtra("User",c);;
                startActivity(intent);
                break;
            }
            case R.id.delhouse_button:{
                Intent intent = new Intent(this, delhouse.class).putExtra("User",c);;
                startActivity(intent);
                break;
            }
            case R.id.addroom_button:{
                Intent intent = new Intent(this, addroom.class).putExtra("User",c);;
                startActivity(intent);
                break;
            }
            case R.id.delroom_button:{
                Intent intent = new Intent(this, delroom.class).putExtra("User",c);;
                startActivity(intent);
                break;
            }
            case R.id.etLogOffButton:{
                Intent intent = new Intent(this, Login.class).putExtra("User",c);
                startActivity(intent);
                break;
            }
            case R.id.addoutlet_button:{
                Intent intent = new Intent(this, addoutlet.class).putExtra("User",c);
                startActivity(intent);
                break;
            }
            case R.id.deloutlet_button:{
                Intent intent = new Intent(this, deloutlet.class).putExtra("User",c);
                startActivity(intent);
                break;
            }
            case R.id.ViewReport:{
                Intent intent = new Intent(this, viewReport.class).putExtra("User",c);
                startActivity(intent);
                break;
            }
        }
    }
}
