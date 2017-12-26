package com.cognizant.pm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/hero") // Th
public class HeroController {
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Hero> getAllUsers() {
		// This returns a JSON or XML with the users
		List<Hero> hero = new ArrayList<>();
		
		Hero h1 = new Hero();
		h1.setId(1);
		h1.setName("jane");
		hero.add(h1);
		
		Hero h2 = new Hero();
		h2.setId(2);
		h2.setName("john");
		hero.add(h2);
		
		return hero;
	}

}
