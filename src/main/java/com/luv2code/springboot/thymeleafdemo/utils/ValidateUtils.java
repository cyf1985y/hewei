package com.luv2code.springboot.thymeleafdemo.utils;

import java.awt.Color;

import javax.swing.JComboBox;

public class ValidateUtils {
	StringBuilder errMessage;
	Boolean isValidate;
	public ValidateUtils() {
		errMessage = new StringBuilder();
		isValidate = true;
	}
	
	public void validateJComboBox(JComboBox cbx, String message) {
		if(cbx.getSelectedIndex() == 0) {
			cbx.setBackground(Color.red);
			isValidate = false;
			errMessage.append(message).append("\r\n");
		}else {
			cbx.setBackground(Color.WHITE);
		}		
	}
	
	public void appendErrMessage(String message) {
		isValidate = false;
		errMessage.append(message).append("\r\n");
	}
	
	public boolean isValidator() {
		return isValidate;
	}
	
	public String getErrMessage() {
		return errMessage.toString();
	}
}
