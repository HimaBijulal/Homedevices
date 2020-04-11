

package com.example.homedevices;


public abstract class User {
private String Name;
private int EmiratesID;
private int ID;
private static int nextID=1;
private int PhoneNumber;
private String EmailAddress;

public User(String name, int emiratesID, int phoneNumber, String emailAddress) {
		Name = name;
		EmiratesID = emiratesID;
		PhoneNumber = phoneNumber;
		EmailAddress = emailAddress;
		ID = nextID;
		nextID++;

		}
		}