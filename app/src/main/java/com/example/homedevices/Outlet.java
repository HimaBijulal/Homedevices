package com.example.homedevices;


import java.io.Serializable;
import java.math.BigInteger;


public class Outlet implements Serializable {
	private String label;

	public Outlet(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public int CurrentUsage;
}