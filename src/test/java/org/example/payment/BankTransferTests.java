package org.example.payment;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidPaymentDetailsException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class BankTransferTests {
    PaymentProcessor paymentProcessor = new PaymentProcessor();

    @Test
    public void validatingCorrectBankTransferPayment() throws InvalidPaymentDetailsException, InsufficientFundsException {

        BankTransfer bankTransfer = new BankTransfer("1234567890","Bank of Java");
        paymentProcessor.process(bankTransfer, 123456.0);

        List<String> result = paymentProcessor.getTransactionHistory();
        assertTrue(result.stream().anyMatch(s -> s.contains("The transaction registered")));
        assertTrue(result.stream().anyMatch(s -> s.contains("Bank Transfer")));
    }

    @Test
    public void validatingIncorrectCreditCardPayment() throws InvalidPaymentDetailsException, InsufficientFundsException {
        BankTransfer bankTransfer = new BankTransfer("abc1234567","");
        try {
            paymentProcessor.process(bankTransfer, 123456.0);
            fail("Expected InvalidPaymentDetailsException to be thrown");
        } catch (InvalidPaymentDetailsException e) {
            assertEquals("Bank Account Details are not correct", e.getMessage());
        } catch (Exception e) {
            fail("Expected InvalidPaymentDetailsException, but got: " + e);
        }
    }
}
