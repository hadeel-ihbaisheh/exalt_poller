package com.exalt.poller.exaltpoller.webservices.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String realName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Team team;
	
	
	@OneToMany(mappedBy = "teamMember")
	private List<Answer> answers;
	
	public Member() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
