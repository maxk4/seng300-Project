package com.diy.software;

import java.io.IOException;

import com.diy.hardware.*;
import com.diy.hardware.external.CardIssuer;
import com.jimmyselectronics.opeechee.Card;
import com.jimmyselectronics.opeechee.Card.CardData;

/**
 * Implements the use case: pay by credit
 */
public class CreditCardPayment {
    /**
     * @param pin
     * @param card
     */
	 double amountDue;
	 static CardIssuer bank = new CardIssuer("Bank",4);
	
    // Signals the insertion of a credit card and PIN
    public void payWithCredit(String pin, Card card, double totalPrice) throws IOException 
    {

        // Validates the PIN against the credit card.
        CardData cardInsertData = card.insert(pin);
        // Signals to the Bank the details of the credit card and the amount to be
        // charged
        long authorizeHoldNumber = bank.authorizeHold(cardInsertData.getNumber(), totalPrice);
        // Signals to the Bank that the transaction identified with the hold number
        // should be posted,reducing the amount of credit available
        boolean transactionSucceded = bank.postTransaction(cardInsertData.getNumber(), authorizeHoldNumber, totalPrice);
        // If the Bank does not approve the transaction, the remaining amount due will
        // not change.
        if (transactionSucceded) {
            // Updates the amount due displayed to the customer.
            amountDue -= totalPrice;
        }
    }

    
   

}
