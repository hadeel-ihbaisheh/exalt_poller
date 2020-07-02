package com.exalt.poller.exaltpoller.webservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIController {
	@GetMapping("/test")
	public String homePage(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
