package com.cognizant.pm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.pm.dao.Task;

public interface TaskRepository extends CrudRepository<Task,Integer>{

	List<Task> findAllByProjectId(Integer id);
	
}
