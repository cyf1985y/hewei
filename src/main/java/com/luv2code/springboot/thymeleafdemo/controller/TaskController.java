package com.luv2code.springboot.thymeleafdemo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Task;
import com.luv2code.springboot.thymeleafdemo.entity.TaskWeight;
import com.luv2code.springboot.thymeleafdemo.service.TaskService;
import com.luv2code.springboot.thymeleafdemo.utils.DateUtils;
import com.luv2code.springboot.thymeleafdemo.utils.Tools;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	private TaskService taskService;
	
	public TaskController(TaskService theTaskService) {
		taskService = theTaskService;
	}
	
	// add mapping for "/list"	
	@GetMapping("/list")
	public String listTasks(@RequestParam(value="date", required = false) String date,	Model theModel) throws ParseException {
		//String assignNoPrefix = "A" + DateUtils.getCurrentDateToROCNumber();
		Date queryDate = new Date();
		String strDate = DateUtils.getCurrentDate();
		if(date != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			queryDate = df.parse(date);
			strDate = date;
		}
		List<Task> theTasks = taskService.findByAssignDate(queryDate);
		
		//add to the spring model
		theModel.addAttribute("tasks", theTasks);
		theModel.addAttribute("currentDate", strDate);
		
		return "tasks/list-tasks";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bine form data
		Task theTask = new Task();
		
		theModel.addAttribute("task", theTask);
		theModel.addAttribute("empMap", taskService.getEmployeesList());
		
		return "tasks/task-form";		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("taskId") String theId,
									Model theModel) {
		// get the task from the service
		Task theTask = taskService.findById(theId);
		
		// set task as a model attribute to pre-populate the form
		theModel.addAttribute("task", theTask);
		theModel.addAttribute("empMap", taskService.getEmployeesList());
		
		// send over to our form
		return "tasks/task-form-edit";
	}
	
	@PostMapping("/save")
	public String saveTask(@ModelAttribute("task") Task theTask) {
		
		String currentDatetime = DateUtils.getCurrentDateTime();
		
		if(theTask.getAssignNo()==null || theTask.getAssignNo() =="") {
			String assignNoPrefix = "A" + DateUtils.getCurrentDateToROCNumber();
			int tempCount = taskService.findByAssignNoWithCreateDate(assignNoPrefix).size();		
			theTask.setAssignNo(assignNoPrefix + Tools.leftPad(Tools.toString(tempCount + 1), "0", 3));
			theTask.setCreateDateTime(currentDatetime);
			theTask.setCreateId("SYSTEM");
			theTask.setStatus("10");
		}
		try {
			List<TaskWeight> taskWeightList = taskService.findById(theTask.getAssignNo()).getTaskWeights();
			if(taskWeightList.size() > 0) {
				theTask.setTaskWeights(taskWeightList);
			}
		}catch(RuntimeException ex) {
			
		}
		
		theTask.setChangeDateTime(currentDatetime);
		theTask.setChangeId("SYSTEM");
		
		// save the Task
		taskService.save(theTask);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/tasks/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("taskId") String theId) {
		
		// delete the Task
		taskService.deleteById(theId);
		
		// redirect to /tasks/list
		return "redirect:/tasks/list";
	}
}
