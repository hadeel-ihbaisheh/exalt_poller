package com.exalt.poller.exaltpoller.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exalt.poller.exaltpoller.webservices.model.Answer;
import com.exalt.poller.exaltpoller.webservices.model.repository.IAnswerRepository;

@RestController
public class AnswerResource {

	@Autowired
	private IAnswerRepository answerRepository;
	
	@GetMapping(path = "/jpa/answers")
	public List<Answer> retreiveAllAnswers(){
		return answerRepository.findAll();
	}
	 @GetMapping("/statistics2/{team}")
	  public List<Answer> getALLStatistics_For_Team(@PathVariable String team) {
		//  @PathVariable String team
		List<Answer> Team_answers=  answerRepository.GetALL_Team_Answers();
		//List<Answer> Team_answers=  answer_repository.findAll(); 
		
		  return Team_answers ;
		  
		  
		  
		  
		  
		  
	  }
}
