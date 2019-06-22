package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.TaskWeightRepository;
import com.luv2code.springboot.thymeleafdemo.entity.TaskWeight;

@Service
public class TaskWeightServiceImpl implements TaskWeightService{
	private TaskWeightRepository taskWeightRepository;
	
	@Autowired
	public TaskWeightServiceImpl(TaskWeightRepository theTaskWeightRepository) {
		taskWeightRepository = theTaskWeightRepository;
	}
	
	@Override
	public List<TaskWeight> findByAssignNo(String assignNo) {
		return taskWeightRepository.findByAssignNoOrderByCreateDateTime(assignNo);
	}

	@Override
	public List<TaskWeight> findByWeightNoStartingWith(String preStr) {
		Sort sort = new Sort(Sort.Direction.ASC, "weightNo");
		return taskWeightRepository.findByWeightNoStartingWith(preStr, sort);
	}

	@Override
	public void save(TaskWeight theTaskWeight) {
		taskWeightRepository.save(theTaskWeight);		
	}
}
