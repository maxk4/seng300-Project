package com.diy.software;

/**
 * Implements the use case: pay by credit
 */
public class creditCardPayment {
    static void payWithCredit(String pin, Card card) {
        CardInsertData cardInsertData = card.insert(pin);
    }

}