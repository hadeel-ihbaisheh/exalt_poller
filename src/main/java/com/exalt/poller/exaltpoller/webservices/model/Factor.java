package com.exalt.poller.exaltpoller.webservices.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Factor {

	@Id
	@GeneratedValue
	private String id;
	
	private String factorCode;
	
	private String factorDescription;
	
	private String factorName;
	
	private Boolean takenToday;
	
	@OneToMany(mappedBy = "factor")
	private List<Question> questions;
	
	
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFactorCode() {
		return factorCode;
	}

	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}

	public String getFactorDescription() {
		return factorDescription;
	}

	public void setFactorDescription(String factorDescription) {
		this.factorDescription = factorDescription;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public Boolean getTakenToday() {
		return takenToday;
	}

	public void setTakenToday(Boolean takenToday) {
		this.takenToday = takenToday;
	}

	protected Factor() {

	}


}
