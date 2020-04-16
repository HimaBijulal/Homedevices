package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login;
    private ArrayList<User> UserList;

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
        Admin u=new Admin("testOne",974,988,"testOne@test.com","testOne","password",UserList);
        Builder j=new Builder("Jack",435,9717,"jack@test.com","jtest","jpass");
        Builder n=new Builder("Norma",765,9716,"norma@test.com","ntest","npass");
        Builder m=new Builder("Mary",546,9715,"mary@test.com","mtest","mpass");
        UserList.add(j);
        UserList.add(u);
        UserList.add(n);
        UserList.add(m);
        j.Addhouse(new House("street2","dist 13",21,"House2"));
        m.Addhouse(new House("street1","dist 19",22,"House1"));

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etLoginButton: {
               // if (Username.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                User c;// "class","d");
                for(int i=0;i<UserList.size();i++){
                    if((Username.getText().toString()==UserList.get(i).getUsername())&&Password.getText().toString()==UserList.get(i).getPassword()){
                        c=UserList.get(i);
                        Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);
                        startActivity(intent);
                    }
                }
                //Builder c =new Builder("a",1,2,"A@a.com","class","d");
                //m.Addhouse(new House("street1","dist 19",22,"House1"));
                //j.Addhouse(new House("street2","dist 13",21,"House2"));

                System.out.println("NoBlahPls");
                    System.out.println("Blah");
                    System.out.println("Hello");
                    break;
               // }
            }
        }
    }


}