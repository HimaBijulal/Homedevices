
package com.example.homedevices;

public class Admin extends User {


	public Admin(String name, int emiratesID, int phoneNumber, String emailAddress) {
		super(name, emiratesID, phoneNumber, emailAddress);
	}

	public void AddBuilder(FileIO file,String name, int emiratesID, int phoneNumber, String emailAddress) {
		file.addBuilder(name,emiratesID,phoneNumber,emailAddress);

	}
}