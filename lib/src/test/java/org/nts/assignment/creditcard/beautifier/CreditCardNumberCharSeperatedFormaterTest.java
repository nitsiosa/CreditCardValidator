package org.nts.assignment.creditcard.beautifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreditCardNumberCharSeperatedFormaterTest {

    @Mock
    private CreditCardNumberBeautifier beautifier;

    public CreditCardNumberCharSeperatedFormaterTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFormat() {
        String input = "49927398716";
        CreditCardNumberCharSeperatedFormater formatter = new CreditCardNumberCharSeperatedFormater('-');
        String expectedOutput = "4992-7398-716";
        String actualOutput = formatter.format(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFormatWithNullInput() {
        CreditCardNumberCharSeperatedFormater formatter = new CreditCardNumberCharSeperatedFormater('-');
        assertNull(formatter.format(null));
    }

    @Test
    void testFormatWithCustomDelimiter() {
        String input = "49927398716";
        CreditCardNumberCharSeperatedFormater formatter = new CreditCardNumberCharSeperatedFormater('*');
        String expectedOutput = "4992*7398*716";
        String actualOutput = formatter.format(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
