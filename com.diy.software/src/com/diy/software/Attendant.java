package com.diy.software;

import com.GUI.AttendantCheckoutStationGUI;

public class Attendant 
{
	private AttendantCheckoutStationGUI GUI;
	
	public Attendant(AttendantCheckoutStationGUI GUI) 
	{
		this.GUI = GUI;
	}
	
	public void signalWeightDisc()
	{
		GUI.displayWeightDiscrepancy();
	}

}
