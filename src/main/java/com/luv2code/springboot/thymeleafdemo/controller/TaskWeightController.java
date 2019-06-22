package com.luv2code.springboot.thymeleafdemo.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.luv2code.springboot.thymeleafdemo.service.TaskWeightService;
import com.luv2code.springboot.thymeleafdemo.utils.DateUtils;
import com.luv2code.springboot.thymeleafdemo.utils.Tools;

@Controller
@RequestMapping("/taskWeight")
public class TaskWeightController {

	private TaskWeightService taskWeightService;

	private TaskService taskService;

	public TaskWeightController(TaskWeightService theTaskWeightService, TaskService theTaskService) {
		taskWeightService = theTaskWeightService;
		taskService = theTaskService;
	}

	// add mapping for "/showForm"
	@GetMapping("/showForm")
	public String listTasks(@RequestParam(value = "assignNo") String assignNo, Model theModel) throws ParseException {

		Task theTask = taskService.findById(assignNo);

		List<TaskWeight> taskWeightlist = theTask.getTaskWeights();

		if (taskWeightlist.size() == 0) {
			taskWeightlist.add(insertTaskWeight(assignNo));
		}

		// add to the spring model
		theModel.addAttribute("task", theTask);
		theModel.addAttribute("empMap", taskService.getEmployeesList());
		theModel.addAttribute("itemMap", this.getItemList());

		return "taskWeight/taskWeight-form-edit";
	}
	
	@PostMapping("/newTaskWeight")
	public String newTask(@RequestParam(value = "assignNo") String assignNo, Model theModel) throws ParseException {
		insertTaskWeight(assignNo);
		Task theTask = taskService.findById(assignNo);

		// add to the spring model
		theModel.addAttribute("task", theTask);
		theModel.addAttribute("empMap", taskService.getEmployeesList());
		theModel.addAttribute("itemMap", this.getItemList());
		return "taskWeight/taskWeight-form-edit";
	}

	@PostMapping("/save")
	public String saveTask(@ModelAttribute("task") Task theTask) {
		String currentDatetime = DateUtils.getCurrentDateTime();
		theTask.setChangeDateTime(currentDatetime);
		theTask.setChangeId("SYSTEM");
		for (TaskWeight theTaskWeight : theTask.getTaskWeights()) {
			theTaskWeight.setChangeDateTime(currentDatetime);
			theTaskWeight.setChangeId("SYSTEM");
		}
		taskService.save(theTask);
		return "redirect:/tasks/list";
	}
	
	@PostMapping("/taskWeightComplete")
	public String taskWeightComplete(@ModelAttribute("task") Task theTask) {
		String currentDatetime = DateUtils.getCurrentDateTime();
		theTask.setStatus("60");
		theTask.setChangeDateTime(currentDatetime);
		theTask.setChangeId("SYSTEM");
		for (TaskWeight theTaskWeight : theTask.getTaskWeights()) {
			theTaskWeight.setChangeDateTime(currentDatetime);
			theTaskWeight.setChangeId("SYSTEM");
		}
		taskService.save(theTask);
		return "redirect:/tasks/list";
	}

	public Map<String, String> getItemList() {
		Map<String, String> itemMap = new HashMap<String, String>();
		itemMap.put("000", "綜合");
		itemMap.put("001", "保特瓶");
		itemMap.put("002", "鋁罐");
		itemMap.put("003", "鐵罐");
		itemMap.put("004", "紙餐具");
		itemMap.put("005", "鉛蓄電池");
		itemMap.put("006", "雜塑膠");
		return itemMap;
	}
	
	private TaskWeight insertTaskWeight(String assignNo) {
		String currentDatetime = DateUtils.getCurrentDateTime();
		String weightNoPrefix = "W" + DateUtils.getCurrentDateToROCNumber();
		int tempCount = taskWeightService.findByWeightNoStartingWith(weightNoPrefix).size();

		// 若工作單未建立秤重紀錄，新增一筆秤重紀錄
		TaskWeight theTaskWeight = new TaskWeight();
		theTaskWeight.setAssignNo(assignNo);
		theTaskWeight.setWeightNo(weightNoPrefix + Tools.leftPad(Tools.toString(tempCount + 1), "0", 3));
		theTaskWeight.setCreateId("SYSTEM");
		theTaskWeight.setCreateDateTime(currentDatetime);
		theTaskWeight.setChangeId("SYSTEM");
		theTaskWeight.setChangeDateTime(currentDatetime);

		taskWeightService.save(theTaskWeight);
		return theTaskWeight;
	}
}
