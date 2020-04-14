

package com.example.homedevices;


abstract class User {
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
}
