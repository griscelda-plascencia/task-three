package org.example.payment;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidPaymentDetailsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles payment processing and transaction logging.
 */
public class PaymentProcessor{
    private final List<String> history = new ArrayList<>();
    /**
     * Processes a payment and returns a transaction log.
     * @param paymentMethod the payment method to use
     * @param amount the amount to pay
     * @throws InvalidPaymentDetailsException if payment details are invalid
     * @throws InsufficientFundsException if funds are insufficient
     */
    void process(PaymentMethod paymentMethod, double amount) throws InvalidPaymentDetailsException, InsufficientFundsException {

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

        createTransactionLog(amount, statusTransaction);
    }

    private void createTransactionLog(double amount, String statusTransaction){
        String toBeRegistered = String.format(
                "The transaction registered: The paid amount is: %.2f and the status of the transaction is: %s",
                amount, statusTransaction);
        this.history.add(toBeRegistered);
    }

    /**
     *  @return a list with the history of the transaction
     */
    public List<String> getTransactionHistory(){
        return this.history;
    }

}
