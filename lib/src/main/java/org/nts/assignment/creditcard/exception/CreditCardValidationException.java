package org.nts.assignment.creditcard.exception;

public class CreditCardValidationException extends RuntimeException {

	private static final long serialVersionUID = -746898951405755468L;

	public CreditCardValidationException() {
        super();
    }
	public CreditCardValidationException(String message) {
        super(message);
    }
}