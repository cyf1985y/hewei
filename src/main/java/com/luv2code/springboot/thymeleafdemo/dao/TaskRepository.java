package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.luv2code.springboot.thymeleafdemo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, String> {
	
	public List<Task> findByAssignDate(String date);
	
	public List<Task> findByAssignDateAndStatusNot(String date, String status);
	
	public List<Task> findByAssignNoStartingWith(String date, Sort sort);
	
	public List<Task> findByAssignNoStartingWithAndStatusNot(String date, String status, Sort sort);
	
	public List<Task> findByAssignDateAndStatusNot(Date date, String status, Sort sort);
	
	public List<Task> findByStatusAndAssignDateNot(String status, Date date, Sort sort);
	
	@Modifying
	@Transactional
	public void deleteByAssignNo(String assignNo);
}
