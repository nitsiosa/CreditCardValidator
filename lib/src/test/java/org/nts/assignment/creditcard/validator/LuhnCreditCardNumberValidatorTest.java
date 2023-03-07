package org.nts.assignment.creditcard.validator;

import org.junit.jupiter.api.Test;
import org.nts.assignment.creditcard.exception.CreditCardValidationException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuhnCreditCardNumberValidatorTest {

    @Test
    void testIsValidWithValidCreditCardNumber() {
        String input = "49927398716";
        LuhnCreditCardNumberValidator validator = new LuhnCreditCardNumberValidator();
        assertTrue(validator.isValid(input));
    }

    @Test
    void testIsValidWithInvalidCreditCardNumber() {
        String input = "49927398717";
        LuhnCreditCardNumberValidator validator = new LuhnCreditCardNumberValidator();
        assertFalse(validator.isValid(input));
    }

    @Test
    void testIsValidWithNullInput() {
        final LuhnCreditCardNumberValidator validator = new LuhnCreditCardNumberValidator();
        assertThrows(CreditCardValidationException.class, () -> validator.isValid(null));
    }

    @Test
    void testIsValidWithEmptyInput() {
        String input = "";
        LuhnCreditCardNumberValidator validator = new LuhnCreditCardNumberValidator();
        assertThrows(CreditCardValidationException.class, () -> validator.isValid(input));
    }
}
