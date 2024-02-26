package com.felipesutter.RestAPIWithSpringBoot3.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesutter.RestAPIWithSpringBoot3.converters.NumberConverter;
import com.felipesutter.RestAPIWithSpringBoot3.exceptions.UnsupportedMathOperationException;
import com.felipesutter.RestAPIWithSpringBoot3.math.SimpleMath;

@RestController
@RequestMapping("/math")
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	private SimpleMath math = new SimpleMath();

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.multiplication(NumberConverter.convertToDouble(numberOne),
				NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {

		if (!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.squareRoot(NumberConverter.convertToDouble(number));
	}

}
