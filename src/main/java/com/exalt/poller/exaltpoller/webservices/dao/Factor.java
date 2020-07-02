package com.exalt.poller.exaltpoller.webservices.dao;

public class Factor {

	private String factor;

	private double mean;

	private double std;

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getStd() {
		return std;
	}

	public void setStd(double std) {
		this.std = std;
	}

	public Factor(String factor, double mean, double std) {
		super();
		this.factor = factor;
		this.mean = mean;
		this.std = std;
	}

	

}
