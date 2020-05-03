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
                String barrier[]=line.split("\\s+");
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

        try {
            InputStream is = context.getAssets().open("ApplianceList.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String Rusername, line;
            double timeplugged;
            String appliancelabel;
            double power;
            while((line=br.readLine()) != null)
            {
                String barrier[]=line.split("\\s+");
                Rusername= barrier[0];
                appliancelabel=barrier[1];
                power=Double.parseDouble(barrier[2]);
                timeplugged=Double.parseDouble(barrier[3]);


                for(User u: UserList)
                {
                    if(u.getUsername().equals(Rusername)){
                        ((Resident) u).addAppliance(appliancelabel);
                        ((Resident) u).setAppliance(appliancelabel,power,timeplugged);}

                }
            }

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in initializing Appliancelist");
        }


        try {
            InputStream is = context.getAssets().open("OutletList.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String Busername, line;
            String label, roomlabel;
            String outletlabel, appliancelabel;
            String Rusername;
            double power;
            while((line=br.readLine()) != null)
            {
                String barrier[]=line.split("\\s+");
                Busername= barrier[0];
                label=barrier[1];
                roomlabel=barrier[2];
                outletlabel=barrier[3];
                Rusername=barrier[4];
                appliancelabel=barrier[5];
                power=Double.parseDouble(barrier[6]);

                for(User u: UserList)
                {
                    if(u.getUsername().equals(Busername)) {
                        ((Builder) u).AddOutlet(label, roomlabel, outletlabel);
                        Outlet o = ((Builder) u).getOutlet(label, roomlabel, outletlabel);
                        for (User i : UserList) {
                            if (i.getUsername().equals(Rusername)) {
                                o.plugAppliance(((Resident) i).getAppliance(appliancelabel));
                                ((Resident) i).getAppliance(appliancelabel).pluginto(o);
                                o.setPower(power);
                            }
                        }

                    }

                }
            }

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("error in initializing outletlist");
        }




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