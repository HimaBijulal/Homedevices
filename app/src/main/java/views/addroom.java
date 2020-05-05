package views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.homedevices.Builder;
import com.example.homedevices.R;

public class addroom extends AppCompatActivity implements View.OnClickListener {

    private EditText RoomL;
    private Spinner HouseL;
    private Button Add,Cancel;
    private Builder b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b= (Builder) getIntent().getSerializableExtra("User");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addroom);
        RoomL = (EditText) findViewById(R.id.RoomLabel);
        HouseL = (Spinner) findViewById(R.id.spinner0);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, b.getHouseLabels());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HouseL.setAdapter(dataAdapter);

        Add = findViewById(R.id.AddHouseR);
        Cancel = findViewById(R.id.CancelRoomR);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        HouseL.setOnItemSelectedListener(new CustomOnItemSelectedListener());

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


}}
