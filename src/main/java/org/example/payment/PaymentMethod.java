package org.example.payment;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidPaymentDetailsException;

/**
 * Abstract base class for all payment methods.
 */
abstract class PaymentMethod {
    /**
     * Processes the payment of the given amount.
     * @param amount the amount to process
     * @return status message
     * @throws InsufficientFundsException if funds are insufficient
     */
    abstract String processPayment(double amount) throws InsufficientFundsException;

    /**
     * Validates the payment details.
     * @throws InvalidPaymentDetailsException if details are invalid
     */
    public void validatePaymentDetails() throws InvalidPaymentDetailsException {
        System.out.println("We are validating payment information is correct");
    }

    /**
     * Utility method to get payment status.
     */
    public static String getPaymentStatus(String payment){
        return "The " + payment + " payment was processed successfully";
    }

}
