package com.exalt.poller.exaltpoller.webservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostedQuestion {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String factor;
	
	private String quesiton;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date questionDate;
	
	private String team;
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getQuesiton() {
		return quesiton;
	}

	public void setQuesiton(String quesiton) {
		this.quesiton = quesiton;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	protected PostedQuestion() {

	}
}
