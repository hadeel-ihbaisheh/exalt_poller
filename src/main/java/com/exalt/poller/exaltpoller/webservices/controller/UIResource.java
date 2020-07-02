package com.exalt.poller.exaltpoller.webservices.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exalt.poller.exaltpoller.webservices.dao.Cell;
import com.exalt.poller.exaltpoller.webservices.dao.Column;
import com.exalt.poller.exaltpoller.webservices.dao.Factor;
import com.exalt.poller.exaltpoller.webservices.dao.RecentQuestionInfo;
import com.exalt.poller.exaltpoller.webservices.dao.Row;
import com.exalt.poller.exaltpoller.webservices.dao.Statistics;
import com.exalt.poller.exaltpoller.webservices.dao.Table;
import com.exalt.poller.exaltpoller.webservices.dao.VotingInfo;
import com.exalt.poller.exaltpoller.webservices.model.Answer;
import com.exalt.poller.exaltpoller.webservices.model.PostedQuestion;
import com.exalt.poller.exaltpoller.webservices.model.Team;
import com.exalt.poller.exaltpoller.webservices.model.repository.IAnswerRepository;
import com.exalt.poller.exaltpoller.webservices.model.repository.IPostedQuestionRepository;
import com.exalt.poller.exaltpoller.webservices.model.repository.ITeamRepository;

@RestController
public class UIResource {

	@Autowired
	private IAnswerRepository answerRepository;
	
	@Autowired
	private IPostedQuestionRepository postedQuestionRepository;
	
	@Autowired
	private ITeamRepository teamRepository;
	

	
	@GetMapping(path = "/teams")
	public List<Team> getTeams(){
		return teamRepository.findAll();
	}
	
	@GetMapping(path = "/votingInfo/{team}")
	public List<VotingInfo> votingInfo(@PathVariable String team) {
		

		
		
		 List<VotingInfo> votes = answerRepository.retrieveVotingInfo(team);
		 return votes;
		 
	}
	
	
	@GetMapping(path = "/recentQuestionInfo/{team}")
	public RecentQuestionInfo RecentQuestionInfo(@PathVariable String team) {
		RecentQuestionInfo recentQuestionInfo = new RecentQuestionInfo();
		
		List<PostedQuestion> lastPostedQuestion = postedQuestionRepository.findAfterDate(new Date(System.currentTimeMillis()-24*60*60*1000), team);
		
		
		//# of posted answers
        long answerCount = answerRepository.findAllByTeam(team).size();
		//# of members
		long membersCount = postedQuestionRepository.findByTeam(team).size();
		
		
		recentQuestionInfo.setFactor(lastPostedQuestion.get(0).getFactor());
		recentQuestionInfo.setPostedQuestionCount(lastPostedQuestion.size()+"");
		recentQuestionInfo.setQuestion(lastPostedQuestion.get(0).getQuesiton());
		recentQuestionInfo.setTime(lastPostedQuestion.get(0).getQuestionDate());
		
		String votingRate = "0";
		if(answerCount>0) {
			votingRate = ((answerCount / membersCount) * 100) + "";
		}
		recentQuestionInfo.setVotingRate(votingRate);
		return recentQuestionInfo;
		
	}
	
	@GetMapping(path = "/overallStatus/{team}")
	public void overallStatus(@PathVariable String team) {
		//return testTable();
	}
	
	@GetMapping(path = "factorInfo/{team}/{factor}")
	public void factorInfo(@PathVariable String team, @PathVariable String factor) {
		//return testTable();
	}
	
	
	
	
	
	
}
