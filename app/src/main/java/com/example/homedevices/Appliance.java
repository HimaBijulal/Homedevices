package com.example.homedevices;


		import java.math.BigInteger;

class Appliance extends Device   {
	private String label;
	public String getLabel() {
		return label;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public void setTimePlugged(double timePlugged) {
		this.timePlugged = timePlugged;
	}

	private double power=5.0;
	private double timePlugged=0.0;

	private Outlet ispluggedinto;

	public Appliance(String label, Outlet ispluggedinto) {
		this.label = label;
		this.ispluggedinto = ispluggedinto;
	}

	public Appliance(String label) {
		this.label = label;
	}

	public void pluginto(Outlet o) throws InterruptedException {
		ispluggedinto =o;
		(new Thread(new thread(this))).start();



}

	public void incCounter(){
		timePlugged++;
	}


	public void unplug(){
		ispluggedinto = null;

	}
	public boolean isPlugged(){
		if(ispluggedinto ==null)
			return false;
		return true;

	}
	public double getTimePlugged(){
		return timePlugged;
	}
}