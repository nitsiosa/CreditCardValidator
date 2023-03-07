package org.nts.assignment.creditcard.exception;

/**
 * The CreditCardValidationException class is a custom exception that is thrown
 * when a credit card number fails validation.
 *
 * <p>
 * This exception extends the RuntimeException class and can be thrown from any
 * method without the need for a try-catch block.
 * </p>
 *
 * <p>
 * If an error message is passed to the constructor, it will be included in the
 * exception message.
 * </p>
 *
 * @since 1.0
 */
public class CreditCardValidationException extends RuntimeException {

	private static final long serialVersionUID = -746898951405755468L;

	/**
	 * Constructs a new CreditCardValidationException with no message.
	 *
	 * @since 1.0
	 */
	public CreditCardValidationException() {
		super();
	}

	/**
	 * Constructs a new CreditCardValidationException with the specified error
	 * message.
	 *
	 * @param message the error message to include in the exception message
	 * @since 1.0
	 */
	public CreditCardValidationException(String message) {
		super(message);
	}
}