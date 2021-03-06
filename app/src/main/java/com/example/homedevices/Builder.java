
package com.example.homedevices;
import java.util.ArrayList;
import java.util.List;

public class Builder extends User {


	private ArrayList <House> Listofhouses;


	public Builder(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password) {
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

	public List<String> getOutletLabels(String HouseLabel,String roomLabel){
		for(House house: Listofhouses){
			if(house.getLabel().equals(HouseLabel))
				for(Room room: house.getListofrooms())
					if(room.getLabel().equals(roomLabel))
						return room.getoutletLabels();

		}

		return null;
	}

	public boolean AddOutlet(String HouseLabel,String RoomLabel, String outletLabel) {
		for(House house: Listofhouses){
			if (house.getLabel().equals(HouseLabel))
				return house.addoutlet(RoomLabel,outletLabel);

		}
		return false;
	}
	public Outlet getOutlet(String HouseLabel, String RoomLabel, String outletLabel) {
		for (House house : Listofhouses)
			if (house.getLabel().equals(HouseLabel))
				for (Room room : house.getListofrooms())
					if (room.getLabel().equals(RoomLabel))
						for (Outlet outlet : room.getListofoutlets())
							if (outlet.getLabel().equals(outletLabel))
								return outlet;

		return null;
	}

	public void Removeoutlet(String HouseLabel,String RoomLabel, String outletLabel) {
		for(House house: Listofhouses){
			if (house.getLabel().equals(HouseLabel))
				 house.delOutlet(RoomLabel,outletLabel);
		}
	}
	public void addHouseOwner(String HouseLabel,HouseOwner o){
		Global.UserList.add(o);
		for(House house: Listofhouses){
			if (house.getLabel().equals(HouseLabel)){
				o.setHouse(house);
			}

		}
	}
	//public void GenerateReport() {
	//}
	public void Addresident() {
	}
	public void Generatereport() {
		ArrayList powerC=new ArrayList<Character>();
		for (House house:Listofhouses){
			if (house.isOccupied(house)) {
				powerC.add(house.getLabel());
				powerC.add(house.getPower());
			}
		}

	}

	public Object GetPower() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
	public static boolean isUniqueLabel(Builder b, String s){
	    for(House h:b.Listofhouses){
	        if(h.getLabel().equals(s))
	            return false;
        }
	    return true;
    }
}