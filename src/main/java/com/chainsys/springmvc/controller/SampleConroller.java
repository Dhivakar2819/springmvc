package com.chainsys.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleConroller {
	@RequestMapping("/")
	public String index() {
		return "index"; // index is the name of the view
		// Runtime will search for index.jsp in webapp/WEP-INF/views folder
	}
	@PostMapping("/print")
	public String print(@RequestParam("userName") String uName,Model model) {
		model.addAttribute("userName",uName); // to share data from the controller to view
		return "print";
		// Runtime will search for print.jsp in webapp/WEP-INF/views folder
	}
}
