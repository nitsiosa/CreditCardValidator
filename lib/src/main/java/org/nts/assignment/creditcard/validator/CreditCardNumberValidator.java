package org.nts.assignment.creditcard.validator;

import org.nts.assignment.creditcard.exception.CreditCardValidationException;

/**
 * The CreditCardNumberValidator interface provides a method for validating
 * credit card numbers using the Luhn algorithm.
 *
 * <p>
 * The isValid method takes a string parameter that represents a credit card
 * number and returns a boolean value indicating whether the credit card number
 * is valid according to the Luhn algorithm.
 * </p>
 *
 * <p>
 * If the input string is null or empty, the isValid method will throw a
 * CreditCardValidationException.
 * </p>
 *
 * @see CreditCardValidationException
 * @since 1.0
 */
public interface CreditCardNumberValidator {

	/**
	 * Validates the given credit card number using the Luhn algorithm.
	 *
	 * @param number the credit card number to validate
	 * @return true if the credit card number is valid according to the Luhn
	 *         algorithm, false otherwise
	 * @since 1.0
	 */
	boolean isValid(String number) throws CreditCardValidationException;

}