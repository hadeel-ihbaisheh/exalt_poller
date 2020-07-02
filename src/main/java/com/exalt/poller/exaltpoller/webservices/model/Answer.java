package com.exalt.poller.exaltpoller.webservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Date answerDate;
	
	private Integer answerWeight;
	
	private String factor;
	
	private String question;
	
	private String team;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member teamMember;
	
	public Member getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(Member teamMember) {
		this.teamMember = teamMember;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public Integer getAnswerWeight() {
		return answerWeight;
	}

	public void setAnswerWeight(Integer answerWeight) {
		this.answerWeight = answerWeight;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Member getUser() {
		return teamMember;
	}

	public void setUser(Member teamMember) {
		this.teamMember = teamMember;
	}

	public Answer() {
		
	}
}
