package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.TaskWeight;

public interface TaskWeightRepository extends JpaRepository<TaskWeight, String> {
	public List<TaskWeight> findByWeightNoStartingWith(String date, Sort sort);
	
	public List<TaskWeight> findByAssignNoOrderByCreateDateTime(String assignNo);	
}
