package com.example.homedevices;


		import java.math.BigInteger;

class Appliance extends Device {
	private String label;
	private Outlet ispluggedinto;

	public Appliance(String label, Outlet ispluggedinto) {
		this.label = label;
		this.ispluggedinto = ispluggedinto;
	}
}