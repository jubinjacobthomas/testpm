package com.cognizant.pm.model;

import java.util.Date;

public class ProjectResponse {
	
private Integer projectId;
	
	private String project;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer priority;
	
	private Integer taskNumber;
	
	private Integer completedTaskNumber;
	

	public Integer getTaskNumber() {
		return taskNumber;
	}

	public void setTaskNumber(Integer taskNumber) {
		this.taskNumber = taskNumber;
	}

	public Integer getCompletedTaskNumber() {
		return completedTaskNumber;
	}

	public void setCompletedTaskNumber(Integer completedTaskNumber) {
		this.completedTaskNumber = completedTaskNumber;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
