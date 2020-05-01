package com.example.homedevices;


import java.util.ArrayList;
import java.util.List;

public class Resident extends User {

	private House House;

	public com.example.homedevices.House getHouse() {
		return House;
	}

	public ArrayList<Appliance> ApplianceList;

	public void setApplianceList(ArrayList<Appliance> applianceList) {
		ApplianceList = applianceList;
	}

	public ArrayList<Appliance> getApplianceList() {
		return ApplianceList;
	}
	public List<String> getUnpluggedApplianceLabels(){
		List<String> arr= new ArrayList<String>();
		for(int i=0;i<ApplianceList.size();i++){
			if(!ApplianceList.get(i).isPlugged())
				arr.add(ApplianceList.get(i).getLabel());
		}
		return arr;

	}
	public List<String> getRoomLabels(){
		return House.getRoomabels();
	}
	public List<String> getUnpluggedOutletLabels(String Room){

		Room r =House.getRoom(Room);
		return r.getUnpluggedOutletLabels();


	}
	public void linkAppliance(String RoomID,String OutletID,String ApplianceID){
		Room r = House.getRoom(RoomID);
		Outlet o =r.getOutlet(OutletID);
		Appliance a = null;
		for(Appliance app: ApplianceList)
			if(app.getLabel().equals(ApplianceID))
				a= app;
		o.plugAppliance(a);
		a.pluginto(o);

	}

	Resident(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
		ApplianceList = new ArrayList<Appliance>();
	}
	public boolean addAppliance(String name){
		for(Appliance app: ApplianceList){
			if(app.getLabel().equals(name))
				return false;
		}
		ApplianceList.add(new Appliance(name));
		return true;
	}


	public void setHouse(com.example.homedevices.House house) {
		House = house;
	}
}