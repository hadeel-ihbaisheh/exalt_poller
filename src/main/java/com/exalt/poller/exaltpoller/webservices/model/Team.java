package com.exalt.poller.exaltpoller.webservices.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String teamName; 
	
	@OneToMany(mappedBy = "team")
	private List<Member> members;
	
	@JsonIgnore
	private String webhookURL;

	public Team(Integer id, String teamName, String webhookURL, List<Member> members) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.webhookURL = webhookURL;
		this.members = members;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getWebhookURL() {
		return webhookURL;
	}

	public void setWebhookURL(String webhookURL) {
		this.webhookURL = webhookURL;
	}

	
	
	
	protected Team() {
		
	}

}
