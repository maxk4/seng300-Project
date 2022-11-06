package com.testing;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import com.jimmyselectronics.OverloadException;
import com.GUI.AttendantCheckoutStationGUI;
import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStation;
import com.diy.hardware.external.ProductDatabases;
import com.diy.software.Attendant;
import com.diy.software.ScanItem;
import com.diy.software.WeightDiscrepancyException;
import com.diy.simulation.Customer;
import com.jimmyselectronics.necchi.BarcodeScanner;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;

import ca.ucalgary.seng300.simulation.NullPointerSimulationException;

import com.jimmyselectronics.Item;
import com.jimmyselectronics.necchi.Barcode;
import java.util.Calendar;

public class ScanItemTest {
	
	private BarcodeScanner barcodeScanner;
	DoItYourselfStation DIY = new DoItYourselfStation();
	public BarcodedItem item;
	
	//Setting up test Attendant and GUI
	AttendantCheckoutStationGUI attendantGUI  = new AttendantCheckoutStationGUI();
	Attendant attendant = new Attendant(attendantGUI);
	
    ScanItem Item = new ScanItem(DIY, attendant);
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
		
		barcodeScanner.plugIn();
	 	barcodeScanner.turnOn();
	 	
	 	//Setting up test product and item 1
		Barcode barcodeOne = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four }); // 1234
		
		item = new BarcodedItem(barcodeOne,10);
		BarcodedProduct itemOneProduct = new BarcodedProduct(barcodeOne,"ITEM 1",5,11);
		
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeOne, itemOneProduct);
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
	 	
	 	boolean scanned = false;
	 	 while(!scanned) 
	 	 {
	        scanned = Item.scanItems(item);
	 	 }
        assertTrue(scanned);
    }
    
 // Testing if item is null 
    @Test (expected = NullPointerSimulationException.class)
    public void testNullItem() {
    	DIY.plugIn();
	 	DIY.turnOn();
	 	item = null; 
	 	Item.scanItems(item);
    }
    
 // Testing for weight discrepancy
    @Test
    public void testWeightDiscrepancy() {
        DIY.plugIn();
         DIY.turnOn();
         
         Item.scanItems(item);
         assertTrue(attendant.WeightDisc); 
    }
}


     

