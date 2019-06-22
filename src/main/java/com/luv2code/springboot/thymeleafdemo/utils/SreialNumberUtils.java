package com.luv2code.springboot.thymeleafdemo.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class SreialNumberUtils {
	public void getSerialNumber(String type, Connection conn) throws SQLException {
//		DBUtils dbUtils = new DBUtils();
//		String serialNumber = "1";
//		ResultSet rt=dbUtils.queryDB(CreateSqlUtils.getSerialNumber(type), conn);
//		if(rt.next()) {
//			serialNumber = rt.getString(1);
//			dbUtils.executeDB(CreateSqlUtils.updateSerialNumber(type), conn);
//		}else {
//			dbUtils.insertDB(CreateSqlUtils.setSerialNumber(type), conn);
//		}
//		return Tools.leftPad(serialNumber, "0", 3);
	}
}
