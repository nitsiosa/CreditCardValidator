package org.nts.assignment.creditcard.validator;

import org.nts.assignment.creditcard.exception.CreditCardValidationException;

import lombok.extern.log4j.Log4j2;

/**
* The Luhn Algorithm
*
*<p>TThe formula verifies a number against its included check-digit, which is usually appended to a partial account number to generate the full account number. This account number must pass the following test:</p>
*<p>Counting from the check digit, which is the rightmost, and moving left, double the value of every second digit.
*Sum the digits of the products together with the un-doubled digits from the original number.
*If the total ends in 0 (put another way, if the total modulo 10 is congruent to 0), then the number is valid according to the Luhn formula; else it is not valid.></p>
*<p>As an illustration, if the account number is 49927398716, it will be validated as follows:</p>
*<p>Double every second digit, from the rightmost: (1×2) = 2, (8×2) = 16, (3×2) = 6, (2×2) = 4, (9×2) = 18
*Sum all digits (digits in parentheses are the products from Step 1): 6 + (2) + 7 + (1 + 6) + 9 + (6) + 7 + (4) + 9 + (1 + 8) + 4 = 70
*Take the sum modulo 10: 70 mod 10 = 0; the account number is valid. </p>
* 
* @author Andreas Nitsios
* @version 1.0
*/
@Log4j2
public class LuhnCreditCardNumberValidator implements CreditCardNumberValidator {
	
	
	/**
	 * <p>This is the implementation of the isValid of the  CreditCardNumberValidator using he Luhn Algorithm
	 * </p>
	 * @param ccardNumber String containing the credit card number 
	 * @return boolean if the credit card is valid 
	 * @since 1.0
	 */ 
    @Override
    public boolean isValid(String ccardNumber) throws CreditCardValidationException{
    	
    	if(log.isDebugEnabled()) {
			log.debug(String.format("Validating card number %s",ccardNumber));
    	}
        if (ccardNumber == null || ccardNumber.isEmpty()) {
        	
        	if(log.isDebugEnabled()) {
    			log.debug(String.format("Credit card number is null or empty: %s",ccardNumber));
        	}
        	
        	throw new CreditCardValidationException("Credit card number is null or empty");
        }

        String reversed = new StringBuilder(ccardNumber).reverse().toString().replaceAll("\\D+", "");

        int total = 0;
        for (int i = 0; i < reversed.length(); i++) {
            int digit = Character.getNumericValue(reversed.charAt(i));
            if (i % 2 == 1) {
                digit *= 2;
            }
            if (digit > 9) {
                digit -= 9;
            }
            total += digit;
        }
    
        if(log.isDebugEnabled()) {
			log.debug(String.format("Total for %s is  %s",ccardNumber,total));
        }
    
        return (total % 10) == 0;
    }
}
