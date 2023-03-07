package org.nts.assignment.creditcard.cleanser;

import lombok.extern.log4j.Log4j2;

/**
 * The DefaultCreditCardNumberCleanser class is an implementation of the CreditCardNumberCleanser interface that removes any non-numeric
 * characters from a credit card number.
 *
 * <p>The cleanse method takes a string parameter that represents the credit card number to be cleansed. It returns a string
 * that contains the cleansed version of the credit card number, with all non-numeric characters removed.</p>
 *
 * <p>If the input string is null, the cleanse method returns null.</p>
 *
 * <p>This class is thread-safe and can be used by multiple threads simultaneously.</p>
 *
 * @see CreditCardNumberCleanser
 * @since 1.0
 */
@Log4j2
public class DefaultCreditCardNumberCleanser implements CreditCardNumberCleanser {
	
    /**
     * Cleanses the given credit card number by removing any non-numeric characters.
     *
     * @param ccardNumber the credit card number to be cleansed
     * @return a string that contains the cleansed version of the credit card number, with all non-numeric characters removed
     * @since 1.0
     */
    @Override
    public String cleanse(String ccardNumber) {
		
    	if(log.isDebugEnabled()) {
			log.debug(String.format("Cleansing card number %s",ccardNumber));
    	}
        return ccardNumber.replaceAll("\\D+", "");
    }
}