package org.nts.assignment.creditcard.beautifier;

import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;

/**
 * The CreditCardNumberBeautifier interface defines the contract for objects
 * that can format a credit card number into a more user-friendly
 * representation.
 *
 * <p>
 * A CreditCardNumberBeautifier implementation takes a credit card number in its
 * raw form and returns a formatted version of the number. The formatting might
 * include adding separator characters or grouping the digits of the number in a
 * certain way.
 * </p>
 *
 * <p>
 * The format method takes a string parameter that represents the credit card
 * number to be beautified. It returns a string that contains the formatted
 * version of the credit card number. If the input string is null or empty, the
 * implementation should return the same value.
 * </p>
 *
 * <p>
 * Implementations of this interface should be stateless and thread-safe.
 * </p>
 *
 * @see CreditCardNumberCleanser
 * @see CreditCardNumberValidator
 * @since 1.0
 */
public interface CreditCardNumberBeautifier {
	/**
	 * Formats the given credit card number into a more user-friendly
	 * representation.
	 *
	 * @param number the credit card number to be beautified
	 * @return a string that contains the formatted version of the credit card
	 *         number
	 * @since 1.0
	 */
	String format(String number);
}
