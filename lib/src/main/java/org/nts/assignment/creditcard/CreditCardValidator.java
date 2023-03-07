package org.nts.assignment.creditcard;

import org.nts.assignment.creditcard.beautifier.CreditCardNumberBeautifier;
import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.exception.CreditCardValidationException;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;

import lombok.extern.log4j.Log4j2;

/**
 * The CreditCardValidator class provides a method for validating credit card numbers using the Luhn algorithm.
 *
 * <p>Constructors:</p>
 * <ul>
 *   <li> {@link #CreditCardValidator(CreditCardNumberCleanser, CreditCardNumberValidator)}</li>
 *   <li> {@link #CreditCardValidator(CreditCardNumberCleanser, CreditCardNumberValidator, CreditCardNumberBeautifier)}</li>
 * </ul>
 *
 * <p>The validate method takes a string parameter that represents a credit card number, formats it using a {@link CreditCardNumberCleanser},
 * and validates it using a {@link CreditCardNumberValidator}. If a {@link CreditCardNumberBeautifier} is present, it will be used to format
 * the credit card number before validation.</p>
 *
 * <p>If the input string is null or empty, the validate method will return false.</p>
 *
 * @see CreditCardNumberCleanser
 * @see CreditCardNumberValidator
 * @see CreditCardNumberBeautifier
 * @since 1.0
 */
@Log4j2
public class CreditCardValidator {

    private final CreditCardNumberCleanser formatter;
    private final CreditCardNumberValidator validator;
    private CreditCardNumberBeautifier beautifier;

    /**
     * Constructs a new CreditCardValidator with the specified CreditCardNumberCleanser and CreditCardNumberValidator.
     *
     * @param formatter the CreditCardNumberCleanser to use for formatting credit card numbers
     * @param validator the CreditCardNumberValidator to use for validating credit card numbers
     * @since 1.0
     */
    public CreditCardValidator(CreditCardNumberCleanser formatter, CreditCardNumberValidator validator) {
        this.formatter = formatter;
        this.validator = validator;
    }

    /**
     * Constructs a new CreditCardValidator with the specified CreditCardNumberCleanser, CreditCardNumberValidator, and CreditCardNumberBeautifier.
     *
     * @param formatter the CreditCardNumberCleanser to use for formatting credit card numbers
     * @param validator the CreditCardNumberValidator to use for validating credit card numbers
     * @param beautifier the CreditCardNumberBeautifier to use for beautifying credit card numbers before validation
     * @since 1.0
     */
    public CreditCardValidator(CreditCardNumberCleanser formatter, CreditCardNumberValidator validator, CreditCardNumberBeautifier beautifier) {
        this.formatter = formatter;
        this.validator = validator;
        this.beautifier = beautifier;
    }

    /**
     * Validates the given credit card number using the Luhn algorithm.
     *
     * @param ccardNumber the credit card number to validate
     * @return true if the credit card number is valid according to the Luhn algorithm, false otherwise
     * @since 1.0
     */
    public boolean validate(String ccardNumber) {
    	
    	if(log.isDebugEnabled()) {
    		log.debug("Received {} to validate",ccardNumber);
    	}
    	
        if (ccardNumber == null || ccardNumber.isEmpty()) {
        	throw new CreditCardValidationException("Credit card number is null or empty");
        }
        
        String formattedNumber = formatter.cleanse(ccardNumber);
        
        if (beautifier != null) {
            formattedNumber = beautifier.format(formattedNumber);
        }
        
        return validator.isValid(formattedNumber);
    }
}