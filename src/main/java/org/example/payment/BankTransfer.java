package org.example.payment;

import org.example.exception.InvalidPaymentDetailsException;

public class BankTransfer extends PaymentMethod{
    private final String accountNumber;
    private final String bankName;

    public BankTransfer(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    String processPayment(double amount) {
        System.out.println("We are processing the amount to be paid by Bank Transfer" + amount);
        return getPaymentStatus("Bank Transfer");
    }

    @Override
    public void validatePaymentDetails() throws InvalidPaymentDetailsException {
        System.out.println("Validating Bank Transfer Payment information");
        if (!accountNumber.matches("\\d{10}") && bankName.isEmpty())
            throw new InvalidPaymentDetailsException("Bank Account Details are not correct");

    }
}