Payment Processing Automation Testing Framework
Overview
This project is a Java-based automation testing framework designed to demonstrate solid Object-Oriented Programming (OOP) principles and best practices. It simulates a payment processing system with support for multiple payment methods and robust exception handling, accompanied by comprehensive automated tests.

Project Structure
src/
  main/
    java/
      org.example/
        payment/
          PaymentMethod.java
          PaymentProcessor.java
          CreditCardPayment.java
          BankTransfer.java
          PayPalPayment.java
        exception/
          InvalidPaymentDetailsException.java
          InsufficientFundsException.java
  test/
    java/
      org.example.payment/
        CreditCardPaymentTests.java
        BankTransferTests.java
        PaypalPaymentTests.java
        
Key Features
OOP Principles: Uses abstraction, encapsulation, and inheritance for payment methods.
Extensible Design: Easily add new payment types by extending PaymentMethod.
Custom Exceptions: Domain-specific exceptions for invalid details and insufficient funds.
Automated Testing: JUnit-based tests for both positive and negative scenarios.
Clear Separation: Production code and test code are separated for maintainability.

How to Run the Tests

Clone the repository:
git clone <your-repo-url>
cd task-three

Build the project and run tests (using Maven):
mvn clean test
Or, run tests from your IDE (IntelliJ IDEA, Eclipse, etc.) by right-clicking the test classes or methods.

Adding a New Payment Method
Create a new class in org.example.payment that extends PaymentMethod.
Implement the required methods (processPayment, validatePaymentDetails).
Add tests for the new payment method in src/test/java/org.example.payment.

Example: Processing a Credit Card Payment

PaymentProcessor processor = new PaymentProcessor();
CreditCardPayment payment = new CreditCardPayment("4111111111111111", "12/25", "123");
String log = processor.process(payment, 100.0);
System.out.println(log);
