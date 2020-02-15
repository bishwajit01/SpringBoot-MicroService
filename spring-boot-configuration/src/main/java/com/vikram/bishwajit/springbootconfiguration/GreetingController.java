package com.vikram.bishwajit.springbootconfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bishwajit
 *
 */
@RestController
public class GreetingController {

	@Value("${my.greeting:default_values}")
	private String greeting;

	@Value(" Bishwajit")
	private String firstName;

	@Value("${my.list.values}")
	private List<String> listValues;

	@GetMapping("/greeting")
	public String greet() {
		return this.greeting + firstName + listValues;
	}
}
