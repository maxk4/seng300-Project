package com.diy.software;

import com.GUI.AttendantCheckoutStationGUI;

public class Attendant 
{
	/*GUI Reference */
	private AttendantCheckoutStationGUI GUI;
	public boolean WeightDisc = false;
	
	public Attendant(AttendantCheckoutStationGUI GUI) 
	{
		this.GUI = GUI;
	}
	
	/*Signals to the GUI that a weight discrepancy has occurred */
	public void signalWeightDisc()
	{
		WeightDisc = true;
		GUI.displayWeightDiscrepancy();
	}

}
