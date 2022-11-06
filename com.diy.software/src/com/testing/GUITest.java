package com.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.LayoutManager;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.GUI.AttendantCheckoutStationGUI;
import com.GUI.CustomerCheckoutStationGUI;
import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStation;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.diy.software.Attendant;
import com.diy.software.CreditCardPayment;
import com.diy.software.ScanItem;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
import com.jimmyselectronics.opeechee.Card;


public class GUITest{

	public CustomerCheckoutStationGUI setup() {
		//Setting up test DIY station
		DoItYourselfStation DIY_Station = new DoItYourselfStation();
		DIY_Station.plugIn();	
		DIY_Station.turnOn();
		
		//Setting up test customer
		Customer customer = new Customer();
		
		//Setting up test card 
		String pin = new String("1234").intern(); 
		Card card  = new Card("Visa","1234567","John","123",pin,true,true);
		CreditCardPayment payment  = new CreditCardPayment();
	 	Calendar expiry = new GregorianCalendar();
	 	expiry.set(2024, 1, 1);
	 	
	 	//Adding the test card to the bank and customer
		payment.bank.addCardData("1234567", "John", expiry, "123", 1000);
		customer.wallet.cards.add(card);
		
		
		//Setting up test product and item 1
		Barcode barcodeOne = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four }); // 1234
		BarcodedItem itemOne = new BarcodedItem(barcodeOne,10);
		BarcodedProduct itemOneProduct = new BarcodedProduct(barcodeOne,"ITEM 1",5,11);
		
		//Setting up test product and item 2
		Barcode barcodeTwo = new Barcode(new Numeral[] { Numeral.one, Numeral.one, Numeral.three, Numeral.four }); // 1134
		BarcodedItem itemTwo  = new BarcodedItem(barcodeTwo,10);
		BarcodedProduct itemTwoProduct = new BarcodedProduct(barcodeTwo,"ITEM 2",15,12);
		
		//Setting up test product and item 3
		Barcode barcodeThree = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.one }); // 1231
		BarcodedItem itemThree  = new BarcodedItem(barcodeThree,10);
		BarcodedProduct itemThreeProduct = new BarcodedProduct(barcodeThree,"ITEM 3",25,13);
		
		//Adding test items to the customer
		customer.shoppingCart.add(itemOne);
		customer.shoppingCart.add(itemTwo);
		customer.shoppingCart.add(itemThree);
		
		//Adding test items to the product database	
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeOne, itemOneProduct);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeTwo, itemTwoProduct);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeThree, itemThreeProduct);
		
		//Setting up test Attendant and GUI
		AttendantCheckoutStationGUI attendantGUI  = new AttendantCheckoutStationGUI();
		Attendant attendant = new Attendant(attendantGUI);
		
		//Setting up ScanItem Attendant and GUI
		ScanItem scanItem = new ScanItem(DIY_Station,attendant);
		
		//Running an instance of the GUI
		return new CustomerCheckoutStationGUI(customer,scanItem,payment);
	}

	//tests scanning items button
	@Test
	public void testScanItem() {
	
			CustomerCheckoutStationGUI station = setup();
			int beforeClick = station.currentItemIndex;
			System.out.println(station.currentItemIndex);
			station.addItemButton.doClick();
			int afterClick = station.currentItemIndex;
			System.out.println(station.currentItemIndex);
			assertEquals(beforeClick, afterClick -1);
		
	}
	
	//tests when there are 0 items
	@Test
	public void testPay0Total() {
	
			CustomerCheckoutStationGUI station = setup();
			station.payByCreditButton.doClick();
			
	}
	
	//Tests payment  when there are items in the list
	@Test
	public void testPayTotal() {
	
			CustomerCheckoutStationGUI station = setup();
			station.addItemButton.doClick();
			station.payByCreditButton.doClick();
			station.customerPaymentGUI.textField.setText("1234");
			station.customerPaymentGUI.submittButton.doClick();			
			
	}


}
