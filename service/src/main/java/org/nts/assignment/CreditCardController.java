package org.nts.assignment;

import org.nts.assignment.processor.CreditCardProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {

	private final CreditCardProcessor processor;

	public CreditCardController(CreditCardProcessor processor) {
		this.processor = processor;
	}

	@PostMapping("/process-credit-card")
	public ResponseEntity<String> processCreditCard(@RequestParam("ccardNumber") String ccardNumber) {
		String result = processor.process(ccardNumber);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/creditcard/validate/{number}")
	public ResponseEntity<String> validate(@PathVariable String ccardNumber) {
		boolean isValid = processor.isValid(ccardNumber);
		HttpStatus status = isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(isValid ? "Valid" : "Invalid", status);
	}

}
