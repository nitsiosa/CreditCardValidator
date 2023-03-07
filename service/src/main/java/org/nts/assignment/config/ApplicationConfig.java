package org.nts.assignment.config;

import org.nts.assignment.CreditCardController;
import org.nts.assignment.creditcard.beautifier.CreditCardNumberBeautifier;
import org.nts.assignment.creditcard.beautifier.CreditCardNumberCharSeperatedFormater;
import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.cleanser.SpaceSeparatedCreditCardNumberCleanser;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;
import org.nts.assignment.creditcard.validator.LuhnCreditCardNumberValidator;
import org.nts.assignment.processor.CreditCardProcessor;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig {
	@Bean
	public CreditCardNumberBeautifier defaultCreditCardNumberBeautifier() {
		return new CreditCardNumberCharSeperatedFormater(' ');
	}

	@Bean
	public CreditCardNumberCleanser spaceSeparatedCreditCardNumberCleanser() {
		return new SpaceSeparatedCreditCardNumberCleanser();
	}

	@Bean
	public CreditCardNumberValidator luhnCreditCardNumberValidator() {
		return new LuhnCreditCardNumberValidator();
	}

	@Bean
	public CreditCardProcessor creditCardProcessor(CreditCardNumberBeautifier beautifier,
			CreditCardNumberCleanser cleanser, CreditCardNumberValidator validator) {
		return new CreditCardProcessor(beautifier, cleanser, validator);
	}

	@Bean
	public CreditCardController creditCardController(CreditCardProcessor processor) {
		return new CreditCardController(processor);
	}
}
