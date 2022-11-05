package com.diy.software;

import com.GUI.AttendantCheckoutStationGUI;

public class Attendant 
{
	/*GUI Reference */
	private AttendantCheckoutStationGUI GUI;
	
	public Attendant(AttendantCheckoutStationGUI GUI) 
	{
		this.GUI = GUI;
	}
	
	/*Signals to the GUI that a weight discrepancy has occurred */
	public void signalWeightDisc()
	{
		GUI.displayWeightDiscrepancy();
	}

}
