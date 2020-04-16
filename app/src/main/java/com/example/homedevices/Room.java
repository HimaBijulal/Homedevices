

package com.example.homedevices;
import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
public class Room  implements Serializable{
	public ArrayList <Outlet> listofoutlets;
	private String label;


	Room(String label) {
		this.label = label;
	}

	String getLabel() {
		return label;
	}

	public void GenerateReport() {
	}

	public void GetPower() {
	}
}