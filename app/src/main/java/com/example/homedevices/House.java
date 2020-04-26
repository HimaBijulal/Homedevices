package com.example.homedevices;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class House implements Serializable {
	private  String Streetname;
	private String District;
	private String Houseno;
	private String label;
	private ArrayList<Room> Listofrooms;
	//Builder b;

	House(String streetname, String district, String houseno, String label) {
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isValidSName(String s){
        if(s.length() <= 32&& s.matches("^[a-zA-Z0-9]*$"))
            return true;
        return false;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isValidDistrict(String s){
        if(s.length() <= 32&& s.matches("^[a-zA-Z0-9]*$"))
            return true;
        return false;
    }
    public static boolean isValidHNo(int s){
        if(String.valueOf(s).length() <=3 && String.valueOf(s).matches("\\d+"))
            return true;
        return false;

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isValidHLabel(Builder b, String s){
        if(s.length() <= 32&& s.matches("^[a-zA-Z0-9]*$")&&Builder.isUniqueLabel(b,s))
            return true;
        return false;
    }
	public void GenerateReport() {}
	public void GetPower() {}
}