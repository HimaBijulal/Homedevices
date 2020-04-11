
package com.example.homedevices;
import java.util.ArrayList;
public class Builder extends User {


	private ArrayList <House> Listofhouses;

	public Builder(String name, int emiratesID, int phoneNumber, String emailAddress) {
		super(name, emiratesID, phoneNumber, emailAddress);
	}

	public void Addhouse(String streetname, String district, int houseno) {
		Listofhouses.add(new House(streetname,district,houseno));
	}
	public void Removehouse(int id) {
		for (House house:Listofhouses)
			if(house.getID() == id){
				Listofhouses.remove(house);
				break;
			}

	}
	public void Addroom(int id,String name) {
		for (House house:Listofhouses)
			if(house.getID() == id) {
				house.addRoom(name);
				break;
			}
	}
	public void Removeroom(int HouseID,int RoomID) {
		for (House house:Listofhouses)
			if(house.getID() == HouseID) {
				house.delRoom(RoomID);
				break;
			}
	}
	public void Addoutlet() {
	}
	public void Removeoutlet() {
	}
	public void GenerateReport() {
	}
	public void Addresident() {
	}
	public void Generatereport() {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
	}

	public Object GetPower() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}