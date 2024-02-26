package com.felipesutter.RestAPIWithSpringBoot3;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesutter.RestAPIWithSpringBoot3.exceptions.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		if (numberTwo.equals("0")) {
			throw new UnsupportedMathOperationException("Not possible to divide for 0.");
		}

		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;

		String number = strNumber.replace(",", ".");

		if (isNumeric(number))
			return Double.parseDouble(number);

		return 0D;
	}
	
	private boolean isNumeric(String strNumber) {
	    if (strNumber == null)
	        return false;

	    String number = strNumber.replace(",", ".");

	    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}


}
