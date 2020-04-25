
package com.example.homedevices;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Builder extends User {


	private ArrayList <House> Listofhouses;


	Builder(String name,  int emiratesID, int phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
		Listofhouses = new ArrayList<House>();
	}


	public void Addhouse(House house) {
		Listofhouses.add(house);
	}

	public void Removehouse(String label) {
		for (House house:Listofhouses)
			if(house.getLabel().equals(label) ){
				Listofhouses.remove(house);
				break;
			}

	}
	public void Addroom(String Houselabel,String Roomlabel) {
		for (House house:Listofhouses)
			if(house.getLabel().equals(Houselabel)) {
				house.addRoom(Roomlabel);
				break;
			}
	}
	public void Removeroom(String Houselabel,String Roomlabel) {
		for (House house:Listofhouses)
			if(house.getLabel().equals(Houselabel)) {
				house.delRoom(Roomlabel);
				break;
			}
	}
	public List<String> getHouseLabels(){
		List<String> arr= new ArrayList<String>();
		for(int i=0;i<Listofhouses.size();i++){
			arr.add(Listofhouses.get(i).getLabel());
		}
		return arr;

	}
	public List<String> getRoomLabels(String HouseLabel){
		for(House house: Listofhouses){
			if(house.getLabel().equals(HouseLabel)){
				return house.getRoomabels();
			}
		}

		return null;
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