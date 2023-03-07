package org.nts.assignment.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.nts.assignment.creditcard.beautifier.CreditCardNumberBeautifier;
import org.nts.assignment.creditcard.cleanser.CreditCardNumberCleanser;
import org.nts.assignment.creditcard.validator.CreditCardNumberValidator;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardProcessorTest {

    @Mock
    private CreditCardNumberBeautifier beautifier;

    @Mock
    private CreditCardNumberCleanser cleanser;

    @Mock
    private CreditCardNumberValidator validator;

    @InjectMocks
    private CreditCardProcessor processor;

    @Test
    public void testProcessValid() {
        String ccardNumber = "4992-7398-716";
        String expectedResult = "4992 7398 716";
        when(cleanser.cleanse(ccardNumber)).thenReturn(ccardNumber);
        when(beautifier.format(ccardNumber)).thenReturn(expectedResult);
        when(validator.isValid(ccardNumber)).thenReturn(true);
        String result = processor.process(ccardNumber);
        assertEquals("4992 7398 716 is valid", result);
    }

    @Test
    public void testProcessInvalid() {
        String ccardNumber = "4992-7398-716-abc";
        when(cleanser.cleanse(ccardNumber)).thenReturn(ccardNumber);
        when(beautifier.format(ccardNumber)).thenReturn(ccardNumber);
        when(validator.isValid(ccardNumber)).thenReturn(false);
        String result = processor.process(ccardNumber);
        assertNotEquals("4992 7398 716 abc is valid", result);
    }
}
