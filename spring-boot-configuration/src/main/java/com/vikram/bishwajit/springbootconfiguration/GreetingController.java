package com.vikram.bishwajit.springbootconfiguration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bishwajit
 *
 */
@RestController
@RefreshScope
/**
 * You have to use @ResquestScope on the bean whose value yu need to be updated.
 * You have to do a POST request with the body {"status":"UP"} to the URL:
 * http://localhost:8080/actuator/refresh
 * The value will be updated.
 */
public class GreetingController {
	
	/**
	 * We have to use ${}, to seek any value from properties files.
	 * If key is not there, we can assign the default value, after the colon. 
	 * If key is not found in properties file, it will throw an RunTime Exception.
	 * Exception :: Error creating bean, Could not find the placeholder my.greeting.
	 */
	@Value("${my.greeting:default_values}")
	private String greeting;

	/**
	 * If we give just the values without the ${},
	 * Then the value will be assigned to the variable directly.
	 */
	@Value(" Bishwajit")
	private String firstName;
	
	/**
	 * This is for the list of values.
	 */
	@Value("${my.list.values}")
	private List<String> listValues;
	
	/**
	 * 
	 * This is for the map values.
	 */
	@Value("#{${my.map.values}}")
	private Map<String, String> mapValues;
	
	@Autowired
	private DbSetting dbSetting;
	
	@Autowired
	private Environment env;

	@GetMapping("/greeting")
	public String greet() {
		return this.greeting + firstName + listValues + mapValues + dbSetting.dispaly();
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		return env.toString();
	}
}
