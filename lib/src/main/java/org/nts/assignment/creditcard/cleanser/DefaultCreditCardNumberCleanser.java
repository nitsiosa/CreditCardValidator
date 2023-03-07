package org.nts.assignment.creditcard.cleanser;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DefaultCreditCardNumberCleanser implements CreditCardNumberCleanser {
    @Override
    public String cleanse(String ccardNumber) {
		
    	if(log.isDebugEnabled()) {
			log.debug(String.format("Cleansing card number %s",ccardNumber));
    	}
        return ccardNumber.replaceAll("\\D+", "");
    }
}