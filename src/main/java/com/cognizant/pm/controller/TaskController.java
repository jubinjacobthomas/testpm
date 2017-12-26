package com.cognizant.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.pm.dao.Task;
import com.cognizant.pm.repository.TaskRepository;

@Controller
@RequestMapping(path="/task")
public class TaskController {
	
	@Autowired 
	TaskRepository taskRepo;
	
	@PostMapping(path="/add")
	public @ResponseBody Task addNewTask (@RequestBody Task task) {
		return taskRepo.save(task);
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Task> getAllUsers() {
		return taskRepo.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody Task updateUser(@RequestBody Task task){
		
		Task t = taskRepo.findOne(task.getTaskId());
		t.setParentId(task.getParentId());
		t.setProjectId(task.getProjectId());
		t.setTask(task.getTask());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		return taskRepo.save(t);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable("id") Integer id){
         taskRepo.delete(id);
	     return "return";
		
	}

}
