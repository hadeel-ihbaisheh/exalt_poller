package com.exalt.poller.exaltpoller.webservices.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exalt.poller.exaltpoller.webservices.model.PostedQuestion;
import com.exalt.poller.exaltpoller.webservices.model.repository.IPostedQuestionRepository;



@RestController
public class PostedQuestionResource {
	
	@Autowired
	private IPostedQuestionRepository postedQuestionRepository;
	/*
	@GetMapping(path = "/recentQuestionInfo/{team}")
	public List<PostedQuestion> recentQuestionInfo(@PathVariable String team) {
		
		return postedQuestionRepository.findAfterDate(new Date(System.currentTimeMillis()-24*60*60*1000), team);
//		return postedQuestionRepository.findByTeam(team);
		
	}
	*/

}
