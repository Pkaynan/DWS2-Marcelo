package edu.ifsp.ifpizza.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

	@GetMapping("/")
	public String home() {
		return "home";
	}

}
