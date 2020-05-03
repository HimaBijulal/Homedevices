package com.example.homedevices;


import android.content.Context;
import android.content.res.AssetManager;

import java.util.ArrayList;
import java.util.Set;
import java.io.*;
import java.util.*;

public class FileIO {
    private ArrayList <User> UserList;
    private Context context;
    public FileIO(Context c){
        context=c;
    }
    public void openFile() {
        try {

            BufferedReader br= new BufferedReader (new FileReader("UserList.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("File could not be found");
        }
    }
    public ArrayList<User> readFile() {

        try {
            UserList=new ArrayList<>();

           // BufferedReader br= new BufferedReader (new FileReader("UserList.txt"));
            InputStream is = context.getAssets().open("UserList.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String line= null;
            String type, username, password;
            String name, email;
            String phone, emirates, id;
            while((line=br.readLine()) != null) {

                String barrier[]=line.split("\t");
                type=barrier[0];
                name=barrier[1];
                emirates=barrier[2];
                phone=barrier[3];
                email=barrier[4];
                username=barrier[5];
                password=barrier[6];
                //User us= new User(name, emirates,phone,email) ;
                if(type.equals("A"))
                {
                    UserList.add (new Admin(name,emirates,phone,email,username,password));
                }
                else if(type.equals("H"))
                {
                    UserList.add (new HouseOwner(name,emirates,phone,email,username,password));
                }
                else if(type.equals("B"))
                {
                    UserList.add (new Builder(name,emirates,phone,email,username,password));
                }
                else if(type.equals("R"))
                {
                    UserList.add (new Resident(name,emirates,phone,email,username,password));
                }

            }
            br.close();

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in initializing userlist");
        }

        try {
            InputStream is = context.getAssets().open("HouseList.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String Busername, Husername, Rusername, line;
            String street, district, label;
            String houseno;
            while((line=br.readLine()) != null)
            {
                String barrier[]=line.split("\t");
                Busername= barrier[0];
                Husername= barrier[1];
                Rusername= barrier[2];
                street= barrier[3];
                district= barrier[4];
                houseno=barrier[5];
                label=barrier[6];
                House h=new House(street, district, houseno, label);
                String resident[]=Rusername.split(",");



                for(User u: UserList)
                {
                    if(u.getUsername().equals(Busername))
                        ((Builder) u).Addhouse(h);
                    else if(u.getUsername().equals(Husername))
                        ((Resident) u).setHouse(h);
                    else for(String s: resident)
                        {
                            if(u.getUsername().equals(s))
                                ((Resident) u).setHouse(h);
                        }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in initializing houselist");
        }

        try {
            InputStream is = context.getAssets().open("RoomList.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String Busername, line;
            String label, roomlabel;
            int houseno, i=0;
            while((line=br.readLine()) != null)
            {
                String barrier[]=line.split("\t");
                Busername= barrier[0];
                label=barrier[1];
                roomlabel=barrier[2];


                for(User u: UserList)
                {
                    if(u.getUsername().equals(Busername))
                        ((Builder) u).Addroom(label,roomlabel);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in initializing roomlist");
        }


        /*try {
            BufferedReader br= new BufferedReader (new FileReader("BuilderList.txt"));

            String line;
            String name, email, Busername, password;
            int emirates, phone;
            while((line=br.readLine()) != null)
            {
                String barrier[]=line.split("\t");
                name= barrier[0];
                emirates=Integer.parseInt(barrier[1]);
                phone=Integer.parseInt(barrier[2]);
                email=barrier[3];
                Busername=barrier[4];
                password=barrier[5];
                for(User u: UserList)
                {
                    if(u instanceof Admin)
                        ((Admin) u).AddBuilder(new Builder(name,emirates,phone, email, Busername, password));
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in initializing Builderlist");
        }*/



        return UserList;
    }
    void addBuilder(String name, int emiratesID, int phoneNumber, String emailAddress){
        //UserList.add(new Builder(name,emiratesID,phoneNumber,emailAddress));
    }

    public void getUserList(){}//at the start of the code
    public void saveToFile(){}
    public void setHouseList(){}
    public void setOutletList(){}
    public void setRoomList(){}
    public void setUserList(){}
    public void setApplianceList(){}
    public void getApplianceList(){}
    public void getHouseList(){}
    public void getRoomList(){}
    public void getOutletList(){}
}