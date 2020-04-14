

package com.example.homedevices;
import java.util.Set;
import java.util.ArrayList;
public class Room {
	public ArrayList <Outlet> listofoutlets;
	private String label;


	Room(String label) {
		label = label;
	}

	String getLabel() {
		return label;
	}

	public void GenerateReport() {
	}

	public void GetPower() {
	}
}