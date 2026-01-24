package org.example.payment;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidPaymentDetailsException;
import org.junit.Test;

import java.io.ObjectInputValidation;
import java.util.List;

import static org.junit.Assert.*;

public class PaypalPaymentTests {
    PaymentProcessor paymentProcessor = new PaymentProcessor();

    @Test
    public void shouldProcessValidPayPalPayment() throws InvalidPaymentDetailsException, InsufficientFundsException {

        PayPalPayment payPalPayment = new PayPalPayment("user@example.com","securePassword123");
        paymentProcessor.process(payPalPayment, 123456.0);
        List<String> result = paymentProcessor.getTransactionHistory();

        assertTrue(result.stream().anyMatch(s -> s.contains("The transaction registered")));
        assertTrue(result.stream().anyMatch(s -> s.contains("PayPal")));
    }

    @Test
    public void shouldThrowExceptionForInvalidPayPalPayment() {
        PayPalPayment payPalPayment = new PayPalPayment("invalidEmailFormat","pass");

        try {
            paymentProcessor.process(payPalPayment, 123456.0);
            fail("Expected InvalidPaymentDetailsException to be thrown");
        } catch (InvalidPaymentDetailsException e) {
            assertEquals("Paypal Details are not correct", e.getMessage());
        } catch (Exception e) {
            fail("Expected InvalidPaymentDetailsException, but got: " + e);
        }

    }
}
