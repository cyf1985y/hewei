package com.luv2code.springboot.thymeleafdemo.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="task")
public class Task {
	
	// define fields
	//安排單號	ASSIGN_NO			VARCHAR
	@Id
	@Column(name="ASSIGN_NO")
	private String assignNo;
	
	//工作單號	TASK_NO				VARCHAR
	@Column(name="TASK_NO")
	private String taskNo;
	
	//客戶代號	CUSTOMER_NO			VARCHAR
	@Column(name="CUSTOMER_NO")
	private String customerNo;
	
	//客戶名稱	CUSTOMER_NAME		VARCHAR
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	//安排日期	ASSIGN_DATE			DATE
	@Column(name="ASSIGN_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date assignDate;
	
	
	//起始時間	ASSIGN_START_TIME	TIME
	@Column(name="ASSIGN_START_TIME")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime assignStartTime;
	
	//載貨司機	EMP_ID				VARCHAR
	@Column(name="EMP_ID")
	private String empId;
	
	//司機名稱	EMP_NAME			VARCHAR
	@Column(name="EMP_NAME")
	private String empName;
	
	//車牌號碼	CAR_NO				VARCHAR
	@Column(name="CAR_NO")
	private String carNo;
	
	//狀態		STATUS				INT
	@Column(name="STATUS")
	private String status;
	
	//備註		MOMO				VARCHAR
	@Column(name="MEMO")
	private String memo;
	
	//建立人員	CREATE_ID			VARCHAR
	@Column(name="CREATE_ID")
	private String createId;
	
	//建立時間	CREATE_DATE_TIME	DATETIME
	@CreatedDate
	@Column(name="CREATE_DATE_TIME")
	private String createDateTime;
	
	//修改人員	CHANGE_ID			VARCHAR
	@Column(name="CHANGE_ID")
	private String changeId;
	
	//修改時間	CHANGE_DATE_TIME	DATETIME
	@Column(name="CHANGE_DATE_TIME")
	@LastModifiedDate
	private String changeDateTime;
	
	//秤重紀錄
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ASSIGN_NO")
	private List<TaskWeight> taskWeights;
	
	// define constructors
	public Task() {
		
	}

	public Task(String assignNo, String taskNo, String customerNo, String customerName, Date assignDate,
			LocalTime assignStartTime, String empId, String empName, String carNo, String status, String momo,
			String createId, String createDateTime, String changeId, String changeDateTime) {
		super();
		this.assignNo = assignNo;
		this.taskNo = taskNo;
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.assignDate = assignDate;
		this.assignStartTime = assignStartTime;
		this.empId = empId;
		this.empName = empName;
		this.carNo = carNo;
		this.status = status;
		this.memo = momo;
		this.createId = createId;
		this.createDateTime = createDateTime;
		this.changeId = changeId;
		this.changeDateTime = changeDateTime;
	}

	public String getAssignNo() {
		return assignNo;
	}

	public void setAssignNo(String assigNo) {
		this.assignNo = assigNo;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public LocalTime getAssignStartTime() {
		return assignStartTime;
	}

	public void setAssignStartTime(LocalTime assignStartTime) {
		this.assignStartTime = assignStartTime;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String momo) {
		this.memo = momo;
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
		System.out.print(changeDateTime);
		this.changeDateTime = changeDateTime;
	}

	public List<TaskWeight> getTaskWeights() {
		return taskWeights;
	}

	public void setTaskWeights(List<TaskWeight> taskWeights) {
		this.taskWeights = taskWeights;
	}

	@Override
	public String toString() {
		return "Task [assigNo=" + assignNo + ", taskNo=" + taskNo + ", customerNo=" + customerNo + ", customerName="
				+ customerName + ", assignDate=" + assignDate + ", assignStartTime=" + assignStartTime + ", empId="
				+ empId + ", empName=" + empName + ", carNo=" + carNo + ", status=" + status + ", momo=" + memo
				+ ", createId=" + createId + ", createDateTime=" + createDateTime + ", changeId=" + changeId
				+ ", changeDateTime=" + changeDateTime + "]";
	}

	
}
