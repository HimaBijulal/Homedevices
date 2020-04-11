package com.example.homedevices;


import java.util.ArrayList;
import java.util.Set;


public class House {
	public House(String streetname, String district, int houseno, int ownerID) {
		Streetname = streetname;
		District = district;
		Houseno = houseno;
		OwnerID = ownerID;
	}

	public String Streetname;
	public String District;
	public int ID;
	public ArrayList<Room> Listofrooms;
	public ArrayList<Resident> ListofResidents;
	public int Houseno;
	public int OwnerID;
	public static int nextid;
	public void GenerateReport() {}
	public void GetPower() {}
}