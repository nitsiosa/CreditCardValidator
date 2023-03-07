package org.nts.assignment.creditcard;

import org.nts.assignment.creditcard.beautifier.CreditCardNumberBeautifier;
import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreditCardValidator {

    private final CreditCardNumberCleanser formatter;
    private final CreditCardNumberValidator validator;
    private 	  CreditCardNumberBeautifier beautifier;

    public CreditCardValidator(CreditCardNumberCleanser formatter, CreditCardNumberValidator validator) {
        this.formatter 	= formatter ;
        this.validator 	= validator ;
    }
    
    public CreditCardValidator(CreditCardNumberCleanser formatter, CreditCardNumberValidator validator,CreditCardNumberBeautifier beautifier) {
        this.formatter  = formatter ;
        this.validator  = validator ;
        this.beautifier = beautifier;
    }

    public boolean validate(String ccardNumber) {
        String formattedNumber = formatter.cleanse(ccardNumber);
        
        if(log.isDebugEnabled()) {
    		log.debug("Validating credit card with number {}",(formattedNumber!=null&&beautifier!=null)?beautifier.format(formattedNumber):formattedNumber);
        }
        return validator.isValid(formattedNumber);
    }
}


