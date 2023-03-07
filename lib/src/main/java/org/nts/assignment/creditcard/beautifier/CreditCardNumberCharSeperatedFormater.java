package org.nts.assignment.creditcard.beautifier;

import lombok.extern.log4j.Log4j;

@Log4j
public class CreditCardNumberCharSeperatedFormater implements CreditCardNumberBeautifier {

	private final char delimiter;

	public CreditCardNumberCharSeperatedFormater(char delimiter) {
		this.delimiter = delimiter;
	}

	@Override
	public String format(String ccardNumber) {
		
		if(log.isDebugEnabled())
			log.debug(String.format("Formating card number %s",ccardNumber));
		
		if (ccardNumber == null)
			return null;
		return ccardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
	}

}
