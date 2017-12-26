package com.example.pm.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parent_Task {

	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer parent_id;
	
	private String parent_task;

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getParent_task() {
		return parent_task;
	}

	public void setParent_task(String parent_task) {
		this.parent_task = parent_task;
	}
	

}
