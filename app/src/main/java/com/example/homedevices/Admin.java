
package com.example.homedevices;

import java.util.ArrayList;

class Admin extends User {

	private ArrayList <User>UserList;
	Admin(String name, int emiratesID, int phoneNumber, String emailAddress, String username, String password, ArrayList<User> UserList) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
		this.UserList = UserList;
	}

	void AddBuilder(Builder b) {
		UserList.add(b);
	}
}