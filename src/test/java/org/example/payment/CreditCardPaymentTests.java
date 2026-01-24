package org.example.payment;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidPaymentDetailsException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CreditCardPaymentTests {
    PaymentProcessor paymentProcessor = new PaymentProcessor();

    @Test
    public void shouldProcessValidCreditCardPayment() throws InvalidPaymentDetailsException, InsufficientFundsException {

        CreditCardPayment creditCardPayment = new CreditCardPayment("4111111111111111","12/25","123");
        paymentProcessor.process(creditCardPayment, 123456.0);
        List<String> result = paymentProcessor.getTransactionHistory();

        assertTrue(result.stream().anyMatch(s -> s.contains("The transaction registered")));
        assertTrue(result.stream().anyMatch(s -> s.contains("Credit Card")));

    }

    @Test
    public void shouldThrowExceptionForInvalidCreditCardPayment() {
        CreditCardPayment creditCardPayment = new CreditCardPayment("1234567890123456","01/20","abc");
        try {
            paymentProcessor.process(creditCardPayment, 123456.0);
            fail("Expected InvalidPaymentDetailsException to be thrown");
        } catch (InvalidPaymentDetailsException e) {
            assertEquals("Credit Card Details are not correct", e.getMessage());
        } catch (Exception e) {
            fail("Expected InvalidPaymentDetailsException, but got: " + e);
        }
    }
}
