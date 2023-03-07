package org.nts.assignment.creditcard.cleanser;

import lombok.extern.log4j.Log4j2;


/**
 * The SpaceSeparatedCreditCardNumberCleanser class is an implementation of the CreditCardNumberCleanser interface that cleanses a credit
 * card number by removing any non-numeric characters and adding space separators between groups of four digits.
 *
 * <p>The cleanse method takes a string parameter that represents the credit card number to be cleansed. It returns a string
 * that contains the cleansed version of the credit card number, with all non-numeric characters removed and space separators
 * added between groups of four digits.</p>
 *
 * <p>If the input string is null, the cleanse method returns null.</p>
 *
 * <p>This class is thread-safe and can be used by multiple threads simultaneously.</p>
 *
 * @see CreditCardNumberCleanser
 * @since 1.0
 */
@Log4j2
public class SpaceSeparatedCreditCardNumberCleanser implements CreditCardNumberCleanser {
	
    /**
     * Cleanses the given credit card number by removing any non-numeric characters and adding space separators between groups of
     * four digits.
     *
     * @param ccardNumber the credit card number to be cleansed
     * @return a string that contains the cleansed version of the credit card number, with all non-numeric characters removed and
     *         space separators added between groups of four digits
     * @since 1.0
     */
    @Override
    public String cleanse(String ccardNumber) {
    	
    	if(log.isDebugEnabled())
    			log.debug(String.format("Cleansing card number %s",ccardNumber));
       	
    	if(ccardNumber ==null)
    		return ccardNumber;
    		
    	return ccardNumber.replaceAll("\\D+", "").replaceAll("(.{4})", "$1 ").trim();
    	
    }
}
