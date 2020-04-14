
package com.example.homedevices;

public class Admin extends User {


	public Admin(String name, int emiratesID, int phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
	}

	public void AddBuilder(FileIO file, String name, int emiratesID, int phoneNumber, String emailAddress) {
		file.addBuilder(name,emiratesID,phoneNumber,emailAddress);

	}
}