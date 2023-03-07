package org.nts.assignment.creditcard.beautifier;

import lombok.extern.log4j.Log4j;

/**
 * The CreditCardNumberCharSeperatedFormater class is an implementation of the
 * CreditCardNumberBeautifier interface that formats a credit card number by
 * adding a separator character between every group of four digits.
 *
 * <p>
 * The format method takes a string parameter that represents the credit card
 * number to be formatted. It returns a string that contains the formatted
 * version of the credit card number with the separator character added. The
 * separator character is specified in the constructor of the class.
 * </p>
 *
 * <p>
 * If the input string is null, the format method returns null.
 * </p>
 *
 * <p>
 * This class is thread-safe and can be used by multiple threads simultaneously.
 * </p>
 *
 * @see CreditCardNumberBeautifier
 * @since 1.0
 */

@Log4j
public class CreditCardNumberCharSeperatedFormater implements CreditCardNumberBeautifier {

	private final char delimiter;

	/**
	 * Creates a new CreditCardNumberCharSeperatedFormater object with the specified
	 * separator character.
	 *
	 * @param delimiter the separator character to be used when formatting the
	 *                  credit card number
	 * @since 1.0
	 */
	public CreditCardNumberCharSeperatedFormater(char delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Formats the given credit card number by adding a separator character between
	 * every group of four digits.
	 *
	 * @param ccardNumber the credit card number to be formatted
	 * @return a string that contains the formatted version of the credit card
	 *         number
	 * @since 1.0
	 */
	@Override
	public String format(String ccardNumber) {

		if (log.isDebugEnabled())
			log.debug(String.format("Formating card number %s", ccardNumber));

		if (ccardNumber == null)
			return null;
		return ccardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
	}

}
