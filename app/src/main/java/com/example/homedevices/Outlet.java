package com.example.homedevices;


import java.io.Serializable;
import java.math.BigInteger;


public class Outlet implements Serializable {
	private String label;
	private Appliance pluggedAppliance = null;

	public Outlet(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void plugAppliance(Appliance a){
		pluggedAppliance = a;
	}
	public void unplugAppliance(){
		pluggedAppliance.unplug();
		pluggedAppliance = null;
	}

	public boolean isPlugged(){
		if(pluggedAppliance ==null)
			return false;
		return true;
	}

	public int CurrentUsage;
}