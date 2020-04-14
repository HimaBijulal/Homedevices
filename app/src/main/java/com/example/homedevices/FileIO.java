package com.example.homedevices;


import java.util.ArrayList;
import java.util.Set;
import java.io.*;
import java.util.*;

public class FileIO {

    public void openFile() {
        try {
            BufferedReader br= new BufferedReader (new FileReader("UserList.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("File could not be found");
        }
    }
    public void readFileUser(ArrayList<User>list ) {

        try {
            BufferedReader br= new BufferedReader (new FileReader("UserList.txt"));
            String line= null;
            String type, username, password;
            String name, email;
            int phone, emirates, id;
            while((line=br.readLine()) != null) {

                String barrier[]=line.split("\t");
                type=barrier[0];
                name=barrier[1];
                emirates=Integer.parseInt(barrier[2]);
                id=Integer.parseInt(barrier[3]);
                phone=Integer.parseInt(barrier[4]);
                email=barrier[5];
                username=barrier[6];
                password=barrier[7];
                //User us= new User(name, emirates,phone,email) ;
                if(type.equals("A"))
                {
                    list.add (new Admin(name,emirates,phone,email,username,password));
                }
                else if(type.equals("H"))
                {
                    list.add (new HouseOwner(name,emirates,phone,email,username,password));
                }
                else if(type.equals("B"))
                {
                    list.add (new Builder(name,emirates,phone,email,username,password));
                }
                else if(type.equals("R"))
                {
                    list.add (new Resident(name,emirates,phone,email,username,password));
                }

            }
            br.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
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