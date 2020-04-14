package com.example.homedevices;


import java.util.ArrayList;

public class Resident extends User {

	private House House;
	public ArrayList<Appliance> ApplianceList;

	Resident(String name, int emiratesID, int phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
	}

	public void setHouse(com.example.homedevices.House house) {
		House = house;
	}
}