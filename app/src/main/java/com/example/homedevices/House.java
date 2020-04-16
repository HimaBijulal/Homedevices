package com.example.homedevices;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class House implements Serializable {
	private  String Streetname;
	private String District;
	private int Houseno;
	private String label;
	private ArrayList<Room> Listofrooms;

	House(String streetname, String district, int houseno, String label) {
		Streetname = streetname;
		District = district;
		Houseno = houseno;
		this.label = label;
		Listofrooms = new ArrayList<Room>();
	}

	String getLabel() {
		return label;
	}

	void addRoom(String name){
		Listofrooms.add(new Room(name));
	}

	void delRoom(String label){
		for (Room room: Listofrooms)
			if(room.getLabel().equals(label)) {
				Listofrooms.remove(room);
				break;
			}
	}
	public List<String> getRoomabels(){
		List<String> arr= new ArrayList<String>();
		for(int i=0;i<Listofrooms.size();i++){
			arr.add(Listofrooms.get(i).getLabel());
		}
		return arr;

	}

	public void GenerateReport() {}
	public void GetPower() {}
}