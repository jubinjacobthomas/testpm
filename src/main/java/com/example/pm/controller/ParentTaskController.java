package com.example.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pm.dao.Parent_Task;
import com.example.pm.repository.ParentTaskRepository;

@Controller
@RequestMapping(path="/demo")
public class ParentTaskController {

	@Autowired
	private ParentTaskRepository repo;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Parent_Task> getAllUsers() {
		// This returns a JSON or XML with the users
		return repo.findAll();
	}
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String taske,@RequestParam int id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Parent_Task task = new Parent_Task();
		task.setParent_id(id);
		task.setParent_task(taske);
		repo.save(task);
		return "Saved";
	}
}
