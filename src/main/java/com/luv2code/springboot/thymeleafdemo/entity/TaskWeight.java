package com.luv2code.springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@IdClass(TaskWeightPK.class)
@Table(name = "taskWeight")
public class TaskWeight {
	// define fields
	// 安排單號 ASSIGN_NO VARCHAR
	@Id
	@Column(name = "ASSIGN_NO")
	private String assignNo;
	
	// 秤重單號 WEIGHT_NO VARCHAR
	@Id
	@Column(name = "WEIGHT_NO")
	private String weightNo;

	// 貨物代號 ITEM_NO VARCHAR
	@Column(name = "ITEM_NO")
	private String itemNo;

	// 貨物名稱 ITEM_NAME VARCHAR
	@Column(name = "ITEM_NAME")
	private String itemName;
	
	//重車秤重人員	LOAD_WEIGHT_ID	VARCHAR
	@Column(name= "LOAD_WEIGHT_ID")
	private String loadWeightId;
	
	//重車秤重時間	LOAD_WEIGHT_TIME	DATETIME
	@Column(name= "LOAD_WEIGHT_TIME")
	private String loadWeightTime;
	
	//重車重量	LOAD_WEIGHT	INT
	@Column(name= "LOAD_WEIGHT")
	private int loadWeight;
	
	//空車秤重人員	EMPTY_WEIGHT_ID	VARCHAR
	@Column(name= "EMPTY_WEIGHT_ID")
	private String emptyWeightId;
	
	//空車秤重時間	EMPTY_WEIGHT_TIME	DATETIME
	@Column(name= "EMPTY_WEIGHT_TIME")
	private String emptyWeightTime;
	
	//空車重量	EMPTY_WEIGHT	INT
	@Column(name= "EMPTY_WEIGHT")
	private int emptyWeight;
	
	//貨物實際重量	REAL_WEIGHT	INT
	@Column(name= "REAL_WEIGHT")
	private int realWeight;
	
	//貨物購買重量	BUY_WEIGHT	INT
	@Column(name= "BUY_WEIGHT")
	private int buyWeight;
	
	//誤差重量	ERROR_WEIGHT	INT
	@Column(name= "ERROR_WEIGHT")
	private int errorWeight;

	// 備註 MOMO VARCHAR
	@Column(name = "MEMO")
	private String memo;

	// 建立人員 CREATE_ID VARCHAR
	@Column(name = "CREATE_ID")
	private String createId;

	// 建立時間 CREATE_DATE_TIME DATETIME
	@CreatedDate
	@Column(name = "CREATE_DATE_TIME")
	private String createDateTime;

	// 修改人員 CHANGE_ID VARCHAR
	@Column(name = "CHANGE_ID")
	private String changeId;

	// 修改時間 CHANGE_DATE_TIME DATETIME
	@Column(name = "CHANGE_DATE_TIME")
	@LastModifiedDate
	private String changeDateTime;

	// define constructors
	public TaskWeight() {

	}

	public TaskWeight(String assignNo, String weightNo, String itemNo, String itemName, String loadWeightId,
			String loadWeightTime, int loadWeight, String emptyWeightId, String emptyWeightTime, int emptyWeight,
			int realWeight, int buyWeight, int errorWeight, String memo, String createId, String createDateTime,
			String changeId, String changeDateTime) {
		super();
		this.assignNo = assignNo;
		this.weightNo = weightNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.loadWeightId = loadWeightId;
		this.loadWeightTime = loadWeightTime;
		this.loadWeight = loadWeight;
		this.emptyWeightId = emptyWeightId;
		this.emptyWeightTime = emptyWeightTime;
		this.emptyWeight = emptyWeight;
		this.realWeight = realWeight;
		this.buyWeight = buyWeight;
		this.errorWeight = errorWeight;
		this.memo = memo;
		this.createId = createId;
		this.createDateTime = createDateTime;
		this.changeId = changeId;
		this.changeDateTime = changeDateTime;
	}

	public String getAssignNo() {
		return assignNo;
	}

	public void setAssignNo(String assignNo) {
		this.assignNo = assignNo;
	}

	public String getWeightNo() {
		return weightNo;
	}

	public void setWeightNo(String weightNo) {
		this.weightNo = weightNo;
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

	public String getLoadWeightId() {
		return loadWeightId;
	}

	public void setLoadWeightId(String loadWeightId) {
		this.loadWeightId = loadWeightId;
	}

	public String getLoadWeightTime() {
		return loadWeightTime;
	}

	public void setLoadWeightTime(String loadWeightTime) {
		this.loadWeightTime = loadWeightTime;
	}

	public int getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(int loadWeight) {
		this.loadWeight = loadWeight;
	}

	public String getEmptyWeightId() {
		return emptyWeightId;
	}

	public void setEmptyWeightId(String emptyWeightId) {
		this.emptyWeightId = emptyWeightId;
	}

	public String getEmptyWeightTime() {
		return emptyWeightTime;
	}

	public void setEmptyWeightTime(String emptyWeightTime) {
		this.emptyWeightTime = emptyWeightTime;
	}

	public int getEmptyWeight() {
		return emptyWeight;
	}

	public void setEmptyWeight(int emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	public int getRealWeight() {
		return realWeight;
	}

	public void setRealWeight(int realWeight) {
		this.realWeight = realWeight;
	}

	public int getBuyWeight() {
		return buyWeight;
	}

	public void setBuyWeight(int buyWeight) {
		this.buyWeight = buyWeight;
	}

	public int getErrorWeight() {
		return errorWeight;
	}

	public void setErrorWeight(int errorWeight) {
		this.errorWeight = errorWeight;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
}
