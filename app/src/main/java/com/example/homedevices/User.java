

package com.example.homedevices;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;

abstract class User implements Serializable {
	private String Name;
	private String EmiratesID;
	private String PhoneNumber;
	private String EmailAddress;
	private String Username;
	private String Password;

	User(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password) {
		Name = name;
		EmiratesID = emiratesID;
		PhoneNumber = phoneNumber;
		EmailAddress = emailAddress;
		Username = username;
		Password = password;
	}
	public String getEmail(){
		return EmailAddress;
	}
	public String getUsername() {
		return Username;
	}
	public String getPassword() {
		return Password;
	}
	public String getEmiratesID() {
		return EmiratesID;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public String getName() {
		return Name;
	}
	@RequiresApi(api = Build.VERSION_CODES.N)
	public static boolean isValidName(String s){
		if(s.length() <= 32 && s.matches("^[ A-Za-z]+$"))
			return true;
		return false;
	}
	public static boolean isValidID(String s){
		if(s.length() ==15 && s.matches("\\d+")&&Global.isuniqeID(s))
			return true;
		return false;
	}
	public static boolean isValidPhoneNum(String s){
		if(s.length() ==10 && String.valueOf(s).matches("\\d+"))
			return true;
		return false;

	}
	public static boolean isValidEmail(String s){
		if(s.contains("@")&&s.contains("."))
			return true;
		return false;
	}
	public static boolean isValidUsername(String s){
		if(s.length() <= 32&& s.matches("^[a-zA-Z0-9]*$")&&Global.isuniqeUsername(s))
			return true;
		return false;

	}
	public static boolean isValidPassword(String s){
		if(s.length() >=8 && s.length()<=32)
			return true;
		return false;

	}
}
