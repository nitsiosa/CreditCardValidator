package org.nts.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.nts.assignment.creditcard.exception.CreditCardValidationException;
import org.nts.assignment.processor.CreditCardProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CreditCardControllerTest {

	@Mock
	private CreditCardProcessor processor;

	@InjectMocks
	private CreditCardController controller;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		controller = new CreditCardController(processor);
	}

	@Test
	void testValidCreditCardNumber() {
		String number = "49927398716";
		when(processor.isValid(anyString())).thenReturn(true);
		ResponseEntity<String> response = controller.isValid(number);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Valid", response.getBody());
	}

	@Test
	void testInvalidCreditCardNumber() {
		String number = "49927398717";
		when(processor.isValid(anyString())).thenReturn(false);
		ResponseEntity<String> response = controller.isValid(number);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid", response.getBody());
	}

	@Test  
    void testNullCreditCardNumber() {
        when(processor.isValid(anyString())).thenThrow(new CreditCardValidationException("Credit card number is null or empty"));
        ResponseEntity<String> response = controller.isValid(null);
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
    }

	@Test
    void testEmptyCreditCardNumber() {
        when(processor.isValid(anyString())).thenThrow(new CreditCardValidationException("Credit card number is null or empty"));
        ResponseEntity<String> response = controller.isValid("");
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
    }

}
