package com.exalt.poller.exaltpoller.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exalt.poller.exaltpoller.webservices.model.Factor;
import com.exalt.poller.exaltpoller.webservices.model.repository.IFactorRepository;

@RestController
public class FactorResource {

	@Autowired
	private IFactorRepository factorRepository;
	
	
	@GetMapping("/jpa/factors")
	public List<Factor> retrieveAllUsers(){
		return factorRepository.findAll();
	}
}
