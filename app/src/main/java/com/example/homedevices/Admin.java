
package com.example.homedevices;

public class Admin extends User {

	public Admin(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password){
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
	}

	public void AddBuilder(Builder b) {
		Global.UserList.add(b);
	}
}