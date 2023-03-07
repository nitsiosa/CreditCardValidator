package org.nts.assignment.processor.exception;

public class CreditCardProcessingException  extends RuntimeException {
	private static final long serialVersionUID = -746898951405755468L;

	public CreditCardProcessingException() {
        super();
	}
	
	public CreditCardProcessingException(String message) {
        super(message);
    }
}
