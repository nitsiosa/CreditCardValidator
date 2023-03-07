package org.nts.assignment.creditcard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.cleanser.SpaceSeparatedCreditCardNumberCleanser;
import org.nts.assignment.creditcard.exception.CreditCardValidationException;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;
import org.nts.assignment.creditcard.validator.LuhnCreditCardNumberValidator;

public class CreditCardValidatorTest {

	private CreditCardValidator validator;

	@Before
	public void setUp() {
		CreditCardNumberCleanser formatter = new SpaceSeparatedCreditCardNumberCleanser();
		CreditCardNumberValidator validator = new LuhnCreditCardNumberValidator();
		this.validator = new CreditCardValidator(formatter, validator);
	}

	@Test
	public void testValidCreditCardNumber() {
		String number = "4012 8888 8888 1881";
		boolean isValid = validator.validate(number);
		assertTrue(isValid);
	}

	@Test
	public void testInvalidCreditCardNumber() {
		String number = "4992 7398 7160 8839";
		boolean isValid = validator.validate(number);
		assertFalse(isValid);
	}

	@Test(expected = CreditCardValidationException.class)
	public void testNullCreditCardNumber() {
		validator.validate(null);
	}

	@Test(expected = CreditCardValidationException.class)
	public void testEmptyCreditCardNumber() {
		validator.validate("");
	}

	@Test
	public void testInvalidCreditCardNumberFormat() {
		String number = "4992-73ab-7160-8838";
		boolean isValid = validator.validate(number);
		assertFalse(isValid);
	}

}
