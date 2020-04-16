

package com.example.homedevices;


import java.io.Serializable;

abstract class User implements Serializable {
	private String Name;
	private int EmiratesID;
	private int PhoneNumber;
	private String EmailAddress;
	private String Username;
	private String Password;

	User(String name, int emiratesID, int phoneNumber, String emailAddress, String username, String password) {
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
	public int getEmiratesID() {
		return EmiratesID;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public String getName() {
		return Name;
	}
}
