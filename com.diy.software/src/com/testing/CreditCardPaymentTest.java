/**
 * 
 */
package com.diy.software.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import com.diy.hardware.*;
import com.diy.hardware.external.CardIssuer;
import com.diy.simulation.Customer;
import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.Card.CardData;
import com.diy.hardware.DoItYourselfStation;
import com.diy.software.*;
import com.diy.software.CreditCardPayment;
import com.diy.software.ScanItem;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Tests cases for pay by credit
 *
 */
public class CreditCardPaymentTest {
	DoItYourselfStation DIY = new DoItYourselfStation();
	CreditCardPayment payment =  new CreditCardPayment();
	String pin;
	Card card;
	Customer customer;
	int cost;
 	Calendar expiry = new GregorianCalendar();
	
	 @Before
	    public void setup() throws Exception {
		 	DIY.plugIn();
		 	DIY.turnOn();
		 	customer = new Customer();
		 	pin = new String("1234").intern();
			card  = new Card("Visa", "1234567", "John", "123", "1234", true, true);  
			expiry.set(2155, 0, 1);
			payment.bank.addCardData("1234567", "John", expiry, "123", 1000);
			customer.wallet.cards.add(card);   
			cost = 20;
    }
	 
	 @After
	 	public void tearDown() throws Exception	{
		 cost = 20;
	 }
	
	@Test
	public void testCard() {
		assertTrue(payment.payWithCredit(pin, card, cost));
	}
	
	@Test
	public void testNullCard() {
		card = null;
		boolean nullExe = false;
		try{
			assertFalse(payment.payWithCredit(pin, card, cost));
		}
		catch (NullPointerException c){
			nullExe = true;
		}
		assertTrue(nullExe);
	}

	@Test
	public void testIncorrectPin() {
		assertFalse(payment.payWithCredit("0000", card, cost));
	}
	
	@Test
	public void testCardAboveLimit() {
		cost = 1000000;
		assertFalse(payment.payWithCredit(pin, card, cost));
	}
	
}
