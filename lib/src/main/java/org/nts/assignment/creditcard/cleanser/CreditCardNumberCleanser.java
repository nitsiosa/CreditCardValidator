package org.nts.assignment.creditcard.cleanser;

import org.nts.assignment.creditcard.beautifier.CreditCardNumberBeautifier;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;

/**
 * The CreditCardNumberCleanser interface defines the contract for objects that can cleanse a credit card number by removing any
 * non-digit characters.
 *
 * <p>A CreditCardNumberCleanser implementation takes a credit card number in any format (with or without separator characters)
 * and returns a cleansed version of the number with only the digits included. The cleansing process might involve removing
 * whitespace, hyphens, or any other non-digit characters.</p>
 *
 * <p>The cleanse method takes a string parameter that represents the credit card number to be cleansed. It returns a string
 * that contains the cleansed version of the credit card number. If the input string is null, the implementation should return
 * the same value.</p>
 *
 * <p>Implementations of this interface should be stateless and thread-safe.</p>
 *
 * @see CreditCardNumberBeautifier
 * @see CreditCardNumberValidator
 * @since 1.0
 */

public interface CreditCardNumberCleanser {

    /**
     * Cleanses the given credit card number by removing any non-digit characters.
     *
     * @param number the credit card number to be cleansed
     * @return a string that contains the cleansed version of the credit card number
     * @since 1.0
     */
    String cleanse(String number);
}

