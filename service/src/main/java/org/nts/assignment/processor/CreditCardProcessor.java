package org.nts.assignment.processor;

import org.nts.assignment.creditcard.beautifier.CreditCardNumberBeautifier;
import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.exception.CreditCardValidationException;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;

public class CreditCardProcessor {

    private final CreditCardNumberBeautifier beautifier;
    private final CreditCardNumberCleanser cleanser;
    private final CreditCardNumberValidator validator;

    public CreditCardProcessor(CreditCardNumberBeautifier beautifier,
                               CreditCardNumberCleanser cleanser,
                               CreditCardNumberValidator validator) {
        this.beautifier = beautifier;
        this.cleanser = cleanser;
        this.validator = validator;
    }

    public String process(String ccardNumber) throws CreditCardValidationException{
        String cleansed = cleanser.cleanse(ccardNumber);
        String beautified = beautifier.format(cleansed);
        boolean isValid = validator.isValid(cleansed);
        return String.format("%s is %s", beautified, isValid ? "valid" : "invalid");
    }
    
    public boolean isValid(String ccardNumber) throws CreditCardValidationException{
        String cleansed = cleanser.cleanse(ccardNumber);
        return validator.isValid(cleansed);
    }
} 