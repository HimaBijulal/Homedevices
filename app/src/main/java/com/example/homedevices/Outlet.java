package com.example.homedevices;


import java.io.Serializable;
import java.math.BigInteger;


public class Outlet implements Serializable {
	private String label;
	private Appliance pluggedAppliance = null;
	private double power=5.0;
	//private double timePlugged=0.0;
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

	public void setPower(double power) {
		this.power = power;
	}

	public double CurrentUsage(/*Outlet o*/) {
		double power = 0.0;
		Appliance a = pluggedAppliance;
		if (this.isPlugged()) {
			a.getLabel();
			power = a.getPower() * a.getTimePlugged();
		}
		return power;
	}
}