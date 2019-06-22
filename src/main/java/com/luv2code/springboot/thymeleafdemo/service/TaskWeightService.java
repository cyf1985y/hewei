package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.TaskWeight;

public interface TaskWeightService {
	public List<TaskWeight> findByAssignNo(String assignNo);
	
	public List<TaskWeight> findByWeightNoStartingWith(String preStr);
	
	public void save(TaskWeight theTaskWeight);
}
