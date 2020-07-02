package com.exalt.poller.exaltpoller.webservices.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer priority;
	
	private String questionText;
	
	@ElementCollection
	private List<String> answerOptions;
	

	@ManyToOne(fetch = FetchType.LAZY)
	private Factor factor;
	
	protected Question() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}
	
}
