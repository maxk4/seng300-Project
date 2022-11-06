package com.diy.software;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStation;
import com.diy.hardware.external.ProductDatabases;
import com.jimmyselectronics.OverloadException;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodedItem;

public class ScanItem {
	
	// Class Variables
	public DoItYourselfStation station;		
	public float totalPrice = 0; 			// Maybe we have this value in a different class? 
	public boolean blocked = false;			// This one too? Used to tell system to block further customer interactions
	public boolean customerSession = true;	// Move this one somewhere too? Used to tell system if there is a customer session
	public Attendant attendant;
	
	
	// Constructor
	public ScanItem(DoItYourselfStation station, Attendant attendant) {
		this.station = station;
		this.attendant = attendant;
	}
	
	
	// Method that scans an item 
	public boolean scanItems(BarcodedItem item)  {
		
		if (station.scanner.scan(item) && customerSession && !blocked) {
			blocked = true;

			Barcode barcode = item.getBarcode();
			double weight = item.getWeight();
			double baggingAreaWeight;
			
			try 
			{
				baggingAreaWeight = station.baggingArea.getCurrentWeight();
				
				BarcodedProduct product = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcode);
				double expectedWeight = product.getExpectedWeight() + baggingAreaWeight;
				long price = product.getPrice();
				
				totalPrice += price;
				
				System.out.println("Please Place The Item In The Bagging Area");
				
				station.baggingArea.add(item);
				
				try 
				{
					testWeightDiscrepancy(weight+baggingAreaWeight, expectedWeight, station.baggingArea.getSensitivity());
				} 
				catch (WeightDiscrepancyException e) 
				{
					attendant.signalWeightDisc();
				}
			} 
			catch (OverloadException e) 
			{
				//Alert the Attendant
			}
			return true;
		}
		
		blocked = false;
		return false;
	}
	
	
	public void testWeightDiscrepancy(double actualWeight, double expectedWeight, double sens) throws WeightDiscrepancyException{
		
		// Checks if new weight is equal to expected weight with regards to sensitivity
		if ((actualWeight < expectedWeight - sens) || (actualWeight > expectedWeight + sens)) {
			blocked = true;
			// System.out.println("Bagging Area Weight Discrepancy Detected...");

			// Signal attendant I/O about weight discrepancy

			// Assuming the boolean will be checked by customerIO and attendantIO and then one of the 3 options occur??
			
			// 3 Options
			// 1. Customer removes or adds item in response, notify system of weight change
			// 2. Customer I/O Signals about Do Not Place Item in Bagging Area request
			// 3. Attendant I/O Signals the System of weight discrepancy approval
			
			throw new WeightDiscrepancyException();
		}
	}
}
