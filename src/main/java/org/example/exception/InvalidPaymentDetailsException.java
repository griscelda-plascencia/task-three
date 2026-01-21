package org.example.exception;

public class InvalidPaymentDetailsException extends Exception {
    public InvalidPaymentDetailsException(String message){
        super(message);
    }
    public InvalidPaymentDetailsException(){}
}
