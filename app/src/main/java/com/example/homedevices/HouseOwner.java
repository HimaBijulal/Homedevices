package com.example.homedevices;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HouseOwner extends Resident {

	HouseOwner(String name, String emiratesID, String phoneNumber, String emailAddress, String username, String password) {
		super(name, emiratesID, phoneNumber, emailAddress, username, password);
	}
	public void addResidant(Resident r){
		Global.UserList.add(r);
		r.setHouse(getHouse());

	}
	public List<String> getResidants(){
		List<String> arr= new ArrayList<String>();
		if(Global.UserList==null) return arr;
		for(User user: Global.UserList) {
			if (user instanceof Resident && !(user instanceof HouseOwner))
				if (((Resident) user).getHouse() == getHouse())
					arr.add(user.getUsername());
		}
		return arr;


	}
	public void Viewhousereport() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void Viewroomreport() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	public void Addappliance() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void Deleteappliance() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void changeownership(String username) {
		for(User user: Global.UserList){
			if(user.getUsername().equals(username)){
				Resident r = new Resident(getName(),getEmiratesID(),getPhoneNumber(),getEmail(),getUsername(),getPassword());
				r.setHouse(getHouse());
				r.setApplianceList(getApplianceList());
				HouseOwner o = new HouseOwner(user.getName(),user.getEmiratesID(),user.getPhoneNumber(),user.getEmail(),user.getUsername(),user.getPassword());
				o.setHouse(getHouse());
				o.setApplianceList(((Resident)user).getApplianceList());
				Global.UserList.remove(user);
				Global.UserList.remove(this);
				Global.UserList.add(o);
				Global.UserList.add(r);

			}


		}

	}
}