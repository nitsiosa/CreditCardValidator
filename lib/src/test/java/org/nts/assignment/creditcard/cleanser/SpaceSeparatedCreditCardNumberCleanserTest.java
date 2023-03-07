package org.nts.assignment.creditcard.cleanser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SpaceSeparatedCreditCardNumberCleanserTest {

    @Test
    void testCleanse() {
        String input = "4992-7398-716";
        SpaceSeparatedCreditCardNumberCleanser cleanser = new SpaceSeparatedCreditCardNumberCleanser();
        String expectedOutput = "49927398716";
        String actualOutput = cleanser.cleanse(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testCleanseWithNullInput() {
        SpaceSeparatedCreditCardNumberCleanser cleanser = new SpaceSeparatedCreditCardNumberCleanser();
        assertNull(cleanser.cleanse(null));
    }

    @Test
    void testCleanseWithEmptyInput() {
        String input = "";
        SpaceSeparatedCreditCardNumberCleanser cleanser = new SpaceSeparatedCreditCardNumberCleanser();
        assertEquals("", cleanser.cleanse(input));
    }

    @Test
    void testCleanseWithInvalidInput() {
        String input = "12#4 5 6 7!89*0";
        SpaceSeparatedCreditCardNumberCleanser cleanser = new SpaceSeparatedCreditCardNumberCleanser();
        assertEquals("124567890", cleanser.cleanse(input));
    }
}

