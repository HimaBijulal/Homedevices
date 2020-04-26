package com.example.homedevices;

import java.util.ArrayList;

public class Global{
    public static ArrayList<User> UserList;


    public static boolean isuniqeID(String s){
        for(User user: UserList){
            if(user.getEmiratesID().equals(s))
                return false;
        }
        return true;
    }
    public static boolean isuniqeUsername(String s){
        for(User user:UserList) {
            if (user.getUsername().equals(s))
                return false;
        }
        return true;
    }
}
