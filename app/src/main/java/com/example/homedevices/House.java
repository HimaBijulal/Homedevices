package com.example.homedevices;


import java.util.ArrayList;
import java.util.Set;


public class House {
	House(String streetname, String district, int houseno) {
		Streetname = streetname;
		District = district;
		Houseno = houseno;
		ID = nextid++;
	}

	private  String Streetname;
	private String District;
	private int ID;
	private ArrayList<Room> Listofrooms;
	private ArrayList<Resident> ListofResidents;
	private int Houseno;
	private static int nextid;

	int getID() {
		return ID;
	}
	void addRoom(String name){
		Listofrooms.add(new Room(name));
	}
	void delRoom(int ID){
		for (Room room: Listofrooms)
			if(room.getID() == ID) {
				Listofrooms.remove(room);
				break;
			}
	}

	public void GenerateReport() {}
	public void GetPower() {}
}