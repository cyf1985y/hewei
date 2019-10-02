package com.luv2code.springboot.thymeleafdemo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.luv2code.springboot.thymeleafdemo.entity.Task;

public interface TaskService {
	
	public List<Task> findAll();
	
	public List<Task> findByAssignNoWithCreateDate(String date);
	
	public List<Task> findByAssignNoWithCreateDateAndStatusNot(String date);
	
	public List<Task> findByAssignDate(Date date);

	public Task findById(String theId);

	public void save(Task theTask);

	public void deleteById(String theId);
	
	public Map<String, String> getEmployeesList();
}
