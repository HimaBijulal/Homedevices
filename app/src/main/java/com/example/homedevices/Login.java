package com.example.homedevices;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login;

    static boolean flag = true;

    public Login(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (flag == true){
            //Context context= getApplicationContext();
            FileIO file= new FileIO(this);
            Global.UserList =file.readFile();
           // Admin u=new Admin("testOne","974","988","testOne@test.com","admin","admin");
           // Builder j=new Builder("Jack","435","9717","jack@test.com","jtest","jpass");
           // Builder n=new Builder("Norma","765","9716","norma@test.com","ntest","npass");
            //Builder m=new Builder("Mary","546","9715","mary@test.com","mtest","mpass");
            //j.Addhouse(new House("street1","dist 19","22","House1"));
           // j.Addhouse(new House("street2","dist 13","21","House2"));

           // Global.UserList.add(j);
           // Global.UserList.add(u);
          //  Global.UserList.add(n);
          //  Global.UserList.add(m);
            flag = false;
        }

        super.onCreate(savedInstanceState);
        //FileIO file=new FileIO ();
        //file.readFile();
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
                User c;// "class","d");
                for(int i=0;i<Global.UserList.size();i++){
                    if((Username.getText().toString().equals(Global.UserList.get(i).getUsername()))&&Password.getText().toString().equals(Global.UserList.get(i).getPassword())){
                        c=Global.UserList.get(i);

                 //Builder c =new Builder("a",1,2,"A@a.com","class","d");

                    Intent intent = new Intent(this, Dashboard.class).putExtra("User",c);
                    startActivity(intent);
                    break;
               // }
            }
        }
    }


}}}