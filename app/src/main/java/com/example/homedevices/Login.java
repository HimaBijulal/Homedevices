package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FileIO file=new FileIO ();
        file.readFile();
        setContentView(R.layout.activity_login);
        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = findViewById(R.id.etLoginButton);
        Login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etLoginButton: {
               // if (Username.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                Builder c =new Builder("a",1,2,"A@a.com","class","d");
                c.Addhouse(new House("street1","dist 19",22,"House1"));
                c.Addhouse(new House("street2","dist 13",21,"House2"));
                Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);
                startActivity(intent);
                System.out.println("NoBlahPls");
                    System.out.println("Blah");
                    System.out.println("Hello");
                    break;
               // }
            }
        }
    }


}