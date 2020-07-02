package com.exalt.poller.exaltpoller.webservices.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Statistics {
	
	private List<Factor> factors;
	
	public Statistics() {
	}

	public Statistics(List<Factor> factors) {
		super();
		this.factors = factors;
	}

	public List<Factor> getFactors() {
		return factors;
	}

	public void setFactors(List<Factor> factors) {
		this.factors = factors;
	}
	
	

}
