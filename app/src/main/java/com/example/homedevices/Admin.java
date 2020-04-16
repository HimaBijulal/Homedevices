
package com.example.homedevices;

import java.util.ArrayList;

class Admin extends User {

	Admin(String name, int emiratesID, int phoneNumber, String emailAddress, String username, String password){
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
	}

	void AddBuilder(Builder b) {
		Global.UserList.add(b);
	}
}