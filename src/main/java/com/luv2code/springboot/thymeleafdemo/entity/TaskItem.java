package com.luv2code.springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task_item")
public class TaskItem {
	
	// define fields	
	// 安排單號	ASSIGN_NO			VARCHAR		12
	@Id
	@Column(name="ASSIGN_NO")
	private String assigNo;
	
	// 項目代號	ITEM_NO				VARCHAR		10
	@Column(name="ITEM_NO")
	private String itemNo;
	
	// 項目名稱	ITEM_NAME			VARCHAR		30
	@Column(name="ITEM_NAME")
	private String itemName;
	
	// 建立人員	CREATE_ID			VARCHAR		10
	@Column(name="CREATE_ID")
	private String createId;
	
	// 建立時間	CREATE_DATE_TIME	DATETIME	
	@Column(name="CREATE_DATE_TIME")
	private String createDateTime;
	
	// 修改人員	CHANGE_ID			VARCHAR		10
	@Column(name="CHANGE_ID")
	private String changeId;
	
	// 修改時間	CHANGE_DATE_TIME	DATETIME	
	@Column(name="CHANGE_DATE_TIME")
	private String changeDateTime;
	
	public TaskItem() {
		
	}

	public TaskItem(String assigNo, String itemNo, String itemName, String createId, String createDateTime,
			String changeId, String changeDateTime) {
		super();
		this.assigNo = assigNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.createId = createId;
		this.createDateTime = createDateTime;
		this.changeId = changeId;
		this.changeDateTime = changeDateTime;
	}

	public String getAssigNo() {
		return assigNo;
	}

	public void setAssigNo(String assigNo) {
		this.assigNo = assigNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getChangeDateTime() {
		return changeDateTime;
	}

	public void setChangeDateTime(String changeDateTime) {
		this.changeDateTime = changeDateTime;
	}

	@Override
	public String toString() {
		return "TaskItem [assigNo=" + assigNo + ", itemNo=" + itemNo + ", itemName=" + itemName + ", createId="
				+ createId + ", createDateTime=" + createDateTime + ", changeId=" + changeId + ", changeDateTime="
				+ changeDateTime + "]";
	}
}
