package com.example.homedevices;

import java.util.ArrayList;

public class Global{
    public static ArrayList<User> UserList;

    public static boolean isuniqeID(int s){
        for(User user: UserList){
            if(user.getEmiratesID() ==s)
                return false;
        }
        return true;
    }
    public static boolean isuniqeUsername(String s ){
        for(User user: UserList){
            if(user.getUsername() ==s)
                return false;
        }
        return true;
    }
}
