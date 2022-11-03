package com.diy.software;

import com.diy.hardware.*;

/**
 * Implements the use case: pay by credit
 */
public class CreditCardPayment {
    /**
     * @param pin
     * @param card
     */
    // Signals the insertion of a credit card and PIN
    static void payWithCredit(String pin, Card card) {

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

    static CardIssuer bank = new CardIssuer();
    double amountDue = totalPrice;

}
