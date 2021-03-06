package com.example.homedevices;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resident extends User implements Serializable {

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
	public List<String> getPluggedOutletLabels(String Room){

		Room r =House.getRoom(Room);
		if(r ==null)
			return new ArrayList<String>();
		return r.getpluggedOutletLabels();


	}
	public Appliance getAppliance(String label)
	{
		for( Appliance appliance : ApplianceList)
		{
			if(appliance.getLabel().equals(label))
				return appliance;
		}
		return null;
	}
	public void setAppliance(String label, double p, double time )
	{
		for(int i=0;i<ApplianceList.size();i++){
			if(ApplianceList.get(i).getLabel().equals(label))
				ApplianceList.get(i).setPower(p);
				ApplianceList.get(i).setTimePlugged(time);
		}
	}
	public void linkAppliance(String RoomID,String OutletID,String ApplianceID) throws InterruptedException {
		Room r = House.getRoom(RoomID);
		Outlet o =r.getOutlet(OutletID);
		Appliance a = null;
		for(Appliance app: ApplianceList)
			if(app.getLabel().equals(ApplianceID))
				a= app;
		o.plugAppliance(a);
		a.pluginto(o);

	}
	public List<String> getHouseLabel(){
		List<String> arr= new ArrayList<String>();

		arr.add(House.getLabel());

		return arr;

	}
	public Resident(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password) {
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
	public double GenerateReport(String room, String outlet) {
		Outlet o=House.getRoom(room).getOutlet(outlet);
		double x= o.CurrentUsage();
		// TODO Auto-generated method stub
		return x;

	}

	public void setHouse(com.example.homedevices.House house) {
		House = house;
	}
}