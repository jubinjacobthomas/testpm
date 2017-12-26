package com.cognizant.pm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pm.dao.Project;
import com.cognizant.pm.model.ProjectResponse;
import com.cognizant.pm.repository.ProjectRepository;
import com.cognizant.pm.repository.TaskRepository;

@RestController
@RequestMapping(path="/project")
public class ProjectController {

	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired 
	TaskRepository taskRepo;
	
	@PostMapping()
	public @ResponseBody Project addProject(@RequestBody Project project){
		return projectRepository.save(project);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody List<ProjectResponse> getAllProject() {
		
		 Iterable<Project> projectList =  projectRepository.findAll();
		
		 List<ProjectResponse> projectResponseList = new ArrayList<>();
		 for(Project project: projectList){
			 ProjectResponse p = new ProjectResponse();
			 p.setProjectId(project.getProjectId());
			 p.setProject(project.getProject());
			 p.setStartDate(project.getStartDate());
			 p.setEndDate(project.getEndDate());
			 p.setPriority(project.getPriority());
			 p.setTaskNumber(taskRepo.findAllByProjectId(project.getProjectId()).size());
			 
			 projectResponseList.add(p);
		 }
		return projectResponseList;
	}
	
}
