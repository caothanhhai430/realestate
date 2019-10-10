package com.javaweb.Helper;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class MapToSqlInsert {
	public static String toSql(Map<String,Object> map) {
		StringBuilder sql = new StringBuilder("(");
		StringBuilder value = new StringBuilder("(");
		
		Set<String> set = map.keySet();
		
        for (String key : set) {
        	Object obj = map.get(key);
        	if(StringUtils.isNotBlank(key)) {
        		sql.append(key+",");
        		value.append("'").append(String.valueOf(obj)).append("',");
        	}
        }
        if(sql.charAt(sql.length()-1)=='(') {
        	return null;
        }else {
        	sql=sql.deleteCharAt(sql.length()-1);
        }
        if(value.charAt(value.length()-1)==',') {
        	value.deleteCharAt(value.length()-1);
        }
		return sql.append(") values ").append(value).append(")").toString();
	}
}
