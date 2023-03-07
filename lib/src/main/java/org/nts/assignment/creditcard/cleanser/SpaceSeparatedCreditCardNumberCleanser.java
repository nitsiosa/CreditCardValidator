package org.nts.assignment.creditcard.cleanser;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpaceSeparatedCreditCardNumberCleanser implements CreditCardNumberCleanser {
    @Override
    public String cleanse(String ccardNumber) {
    	
    	if(log.isDebugEnabled())
    			log.debug(String.format("Cleansing card number %s",ccardNumber));
       	
    	if(ccardNumber ==null)
    		return ccardNumber;
    		
    	return ccardNumber.replaceAll("\\D+", "").replaceAll("(.{4})", "$1 ").trim();
    	
    }
}
