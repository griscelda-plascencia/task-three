package org.example.payment;

import org.example.exception.InvalidPaymentDetailsException;

public class PayPalPayment extends PaymentMethod{
    private final String email;
    private final String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    String processPayment(double amount) {
        System.out.println("We are processing the amount to be paid by Paypal" + amount);
        return getPaymentStatus("PayPal");
    }

    @Override
    public void validatePaymentDetails() throws InvalidPaymentDetailsException {
        System.out.println("Validating Paypal Payment information");

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new InvalidPaymentDetailsException("Paypal Details are not correct");
    }

}