package org.example.payment;

import org.example.exception.InvalidPaymentDetailsException;

public class CreditCardPayment extends PaymentMethod{
    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public String processPayment(double amount) {
        System.out.println("We are processing the amount "+amount+" to be paid by CreditCard");
        return getPaymentStatus("Credit Card");
    }

    @Override
    public void validatePaymentDetails() throws InvalidPaymentDetailsException {
        System.out.println("Validating Credit Card Payment information");
        if (!(cardNumber.matches("\\d{16}") && cvv.matches("\\d{3}") && expiryDate.matches("\\d{2}/\\d{2}")))
            throw new InvalidPaymentDetailsException("Credit Card Details are not correct");
    }

}