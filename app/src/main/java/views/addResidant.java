package views;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homedevices.Builder;
import com.example.homedevices.HouseOwner;
import com.example.homedevices.R;
import com.example.homedevices.Resident;
import com.example.homedevices.User;

import java.io.Serializable;

public class addResidant extends AppCompatActivity implements View.OnClickListener, Serializable {

    private EditText Name, EmiratesID, PhoneNo, Username, Password,EmailAddress;
    private Button Add, Cancel;
    private HouseOwner c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresidant);
        Name = (EditText) findViewById(R.id.edittext5);
        EmiratesID = (EditText) findViewById(R.id.editText);
        PhoneNo = (EditText) findViewById(R.id.editText2);
        Username = (EditText) findViewById(R.id.editText3);
        Password = (EditText) findViewById(R.id.editText4);
        Add = findViewById(R.id.button2);
        Cancel = findViewById(R.id.cancelbutton);
        EmailAddress=findViewById(R.id.emailbuild);
        Add.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        c= (HouseOwner) getIntent().getSerializableExtra("User");



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
                    c.addResidant(new Resident(Name.getText().toString(), EmiratesID.getText().toString(),
                            PhoneNo.getText().toString(), EmailAddress.getText().toString(),
                            Username.getText().toString(), Password.getText().toString()));



                Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);;
                startActivity(intent);
                break;

            }
            case R.id.cancelbutton: {
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);;

                startActivity(intent);
            }
        }
    }
}