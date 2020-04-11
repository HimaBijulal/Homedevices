

package com.example.homedevices;
import java.util.Set;
import java.util.ArrayList;
public class Room {
	private int ID;

	int getID() {
		return ID;
	}

	public ArrayList <Outlet> listofoutlets;
	private String Name;
	private House house;
	private static int nextid;

	Room(String name) {
		Name = name;
		ID = nextid++;
	}

	public void GenerateReport() {
	}

	public void GetPower() {
	}
}