package com.testing;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import com.jimmyselectronics.OverloadException;

import com.diy.hardware.DoItYourselfStation;
import com.diy.software.ScanItem;
import com.diy.software.WeightDiscrepancyException;
import com.diy.simulation.Customer;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
import com.jimmyselectronics.Item;
import com.jimmyselectronics.necchi.Barcode;
import java.util.Calendar;

public class ScanItemTest {
	
	private BarcodeScanner barcodeScanner;
	DoItYourselfStation DIY = new DoItYourselfStation();
	public BarcodedItem item;
    ScanItem Item = new ScanItem(DIY, null);
    ArrayList<Item> itemTest;
    public Barcode barcodeTest;
	public boolean success;
    Customer customer;
    
    @Before
    public void setUp() throws Exception {
	 	barcodeScanner = new BarcodeScanner(); 
		itemTest = new ArrayList<> ();
		barcodeTest = new Barcode (new Numeral [] {Numeral.one, Numeral.two, Numeral.three, Numeral.four, Numeral.five});
		item = new BarcodedItem(barcodeTest, 28);
    }
    
    @After
	public void tearDown() throws Exception {
		item = null;
		barcodeTest = null;
		itemTest = null;	
	}
    
    @Test
    public void testScanItem() { 
    	DIY.plugIn();
	 	DIY.turnOn();
	 	assertFalse(barcodeScanner.scan(item));
    	System.out.println("Please place item in bagging area.");
    }
    
 // Testing if item is null 
    @Test
    public void testNullItem() {
    	DIY.plugIn();
	 	DIY.turnOn();
	 	item = null; 
    }
    
    // Testing for weight discrepancy
    @Test (expected = WeightDiscrepancyException.class)
    public void testWeightDiscrepancy() {
    	DIY.plugIn();
	 	DIY.turnOn();
    }
}


     

