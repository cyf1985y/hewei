package com.luv2code.springboot.thymeleafdemo.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tools {
	public List<HashMap<String, Object>> resultSetToArrayList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>(50);
		while (rs.next()) {
			HashMap<String, Object> row = new HashMap<String, Object>(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(row);
		}
		return list;
	}
	
	public static String leftPad(String str, String padStr,int length) {
		while(str.length() < length) {
			str = padStr + str;
		}
		return str;
	}
	
	public static String combinSql(String str, Map<String, String> map) {
		for(String s: map.keySet()) {			
			str = str.replaceAll("'" +":" + s + "'", "'" + map.get(s) + "'");
		}
		return str;
	}
	
	public static String toString(Object o) {		
		return o != null ? o.toString() : "";
	}
	
}
