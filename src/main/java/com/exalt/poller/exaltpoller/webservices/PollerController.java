package com.exalt.poller.exaltpoller.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollerController {

	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping(path = "/hello2")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello2");
	}
	
}
