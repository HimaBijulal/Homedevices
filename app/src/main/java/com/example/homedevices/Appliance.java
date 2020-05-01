package com.example.homedevices;


		import java.math.BigInteger;

class Appliance extends Device {
	private String label;

	public String getLabel() {
		return label;
	}

	private Outlet ispluggedinto;

	public Appliance(String label, Outlet ispluggedinto) {
		this.label = label;
		this.ispluggedinto = ispluggedinto;
	}

	public Appliance(String label) {
		this.label = label;

	}

	public void pluginto(Outlet o){
		ispluggedinto =o;
}

	public void unplug(){
		ispluggedinto = null;

	}
	public boolean isPlugged(){
		if(ispluggedinto ==null)
			return false;
		return true;

	}
}