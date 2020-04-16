
package com.example.homedevices;

import java.util.ArrayList;

public class Admin extends User {
	public ArrayList<Builder> ListOfBuilders;

	public Admin(String name, int emiratesID, int phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
		ListOfBuilders= new ArrayList<>();
	}

	public void AddBuilder(Builder b) {
		ListOfBuilders.add(b);
	}
}