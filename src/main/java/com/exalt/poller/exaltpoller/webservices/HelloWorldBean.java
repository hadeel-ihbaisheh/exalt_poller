package com.exalt.poller.exaltpoller.webservices;

public class HelloWorldBean {

	private String message;
	public HelloWorldBean(String message) {
		this.setMessage(message);
	}
	public HelloWorldBean() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
