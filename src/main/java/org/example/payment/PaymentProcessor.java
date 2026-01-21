package org.example.payment;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidPaymentDetailsException;
/**
 * Handles payment processing and transaction logging.
 */
public class PaymentProcessor{
    /**
     * Processes a payment and returns a transaction log.
     * @param paymentMethod the payment method to use
     * @param amount the amount to pay
     * @return transaction log string
     * @throws InvalidPaymentDetailsException if payment details are invalid
     * @throws InsufficientFundsException if funds are insufficient
     */
    public String process(PaymentMethod paymentMethod, double amount) throws InvalidPaymentDetailsException, InsufficientFundsException {

        try {
            paymentMethod.validatePaymentDetails();
        } catch (InvalidPaymentDetailsException e) {
            throw new InvalidPaymentDetailsException(e.getMessage());
        }

        String statusTransaction;
        try {
           statusTransaction = paymentMethod.processPayment(amount);
        } catch (InsufficientFundsException e) {
            throw new InsufficientFundsException(e.getMessage());
        }

        return createTransactionLog(amount, statusTransaction);
    }

    private String createTransactionLog(double amount, String statusTransaction){
        return String.format(
                "The transaction registered: The paid amount is: %.2f and the status of the transaction is: %s",
                amount, statusTransaction
        );
    }
}
