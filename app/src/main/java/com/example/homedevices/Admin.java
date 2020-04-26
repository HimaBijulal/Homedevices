
package com.example.homedevices;

class Admin extends User {

	Admin(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password){
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
	}

	void AddBuilder(Builder b) {
		Global.UserList.add(b);
	}
}