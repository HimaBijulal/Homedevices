package com.example.homedevices;


import java.util.ArrayList;

public class Resident extends User {

	private House House;

	public com.example.homedevices.House getHouse() {
		return House;
	}

	public ArrayList<Appliance> ApplianceList;

	public void setApplianceList(ArrayList<Appliance> applianceList) {
		ApplianceList = applianceList;
	}

	public ArrayList<Appliance> getApplianceList() {
		return ApplianceList;
	}

	Resident(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
		ApplianceList = new ArrayList<Appliance>();
	}


	public void setHouse(com.example.homedevices.House house) {
		House = house;
	}
}