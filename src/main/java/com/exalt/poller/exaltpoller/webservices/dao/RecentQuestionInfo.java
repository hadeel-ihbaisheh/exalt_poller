package com.exalt.poller.exaltpoller.webservices.dao;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class RecentQuestionInfo {

	private String factor;
	private String postedQuestionCount;
	private String question;
	private Date time;
	private String votingRate;
	
	
	public RecentQuestionInfo(String factor, String postedQuestionCount, String question, Date time,
			String votingRate) {
		super();
		this.factor = factor;
		this.postedQuestionCount = postedQuestionCount;
		this.question = question;
		this.time = time;
		this.votingRate = votingRate;
	}


	public String getFactor() {
		return factor;
	}


	public void setFactor(String factor) {
		this.factor = factor;
	}


	public String getPostedQuestionCount() {
		return postedQuestionCount;
	}


	public void setPostedQuestionCount(String postedQuestionCount) {
		this.postedQuestionCount = postedQuestionCount;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getVotingRate() {
		return votingRate;
	}


	public void setVotingRate(String votingRate) {
		this.votingRate = votingRate;
	}


	public RecentQuestionInfo() {
		
	}
}
