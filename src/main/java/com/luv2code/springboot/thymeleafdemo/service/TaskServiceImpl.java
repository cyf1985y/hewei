package com.luv2code.springboot.thymeleafdemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.TaskRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {
	private TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository theTaskRepository) {
		taskRepository = theTaskRepository;
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task findById(String theId) {
		Optional<Task> result = taskRepository.findById(theId);

		Task theTask = null;
		if (result.isPresent()) {
			theTask = result.get();
		} else {
			throw new RuntimeException("Did not find task id -" + theId);
		}
		return theTask;
	}

	@Override	
	public void save(Task theTask) {
		if(theTask.getEmpId()!=null && theTask.getEmpId()!="") {
			theTask.setEmpName(this.getEmployeesList().get(theTask.getEmpId()).toString());
		}		
		taskRepository.save(theTask);
	}

	@Override
	public void deleteById(String theId) {
		Optional<Task> result = taskRepository.findById(theId);

		Task theTask = null;
		if (result.isPresent()) {
			theTask = result.get();
		} else {
			throw new RuntimeException("Did not find task id -" + theId);
		}
		theTask.setStatus("98");
		taskRepository.save(theTask);
	}
	
	@Override
	public List<Task> findByAssignNoWithCreateDate(String date) {
		Sort sort = new Sort(Sort.Direction.ASC, "assignNo");
		return taskRepository.findByAssignNoStartingWith(date, sort);
	}

	@Override
	public List<Task> findByAssignNoWithCreateDateAndStatusNot(String date) {
		Sort sort = new Sort(Sort.Direction.ASC, "assignNo");
		return taskRepository.findByAssignNoStartingWithAndStatusNot(date, "98", sort);
	}

	@Override
	public List<Task> findByAssignDate(Date date) {
		List<Task> list = new ArrayList<Task>();
		Sort sort = new Sort(Sort.Direction.ASC, "assignStartTime");
		list.addAll(taskRepository.findByStatusAndAssignDateNot("10", date, sort));
		list.addAll(taskRepository.findByAssignDateAndStatusNot(date, "98", sort));
		list.addAll(taskRepository.findByAssignDateAndStatusNot(null, "98", sort));
		return list;
	}

	@Override
	public Map<String, String> getEmployeesList() {
		Map<String, String> empMap = new LinkedHashMap<String, String>();
		empMap.put("080", "王文達");
		empMap.put("094", "李銘偉");
		empMap.put("097", "游淳莅");
		empMap.put("098", "張逸仁");
		empMap.put("021", "李銘哲");
		empMap.put("095", "林樹賢");
		empMap.put("096", "林建豪");		
		empMap.put("067", "曾忠文");		
		empMap.put("003", "陳彥鋒");
		return empMap;
	}

}
