package com.javaweb.Helper;

import java.util.Map;
import java.util.Set;

public class MapToSqlSearch {
	public static StringBuilder toSql(Map<String,Object> map) {
		StringBuilder where = new StringBuilder();
		if(map==null) return where;
		Set<String> set = map.keySet();
        for (String key : set) {
        	Object obj = map.get(key);
        	
        	if(obj instanceof String) {
        		where.append(" AND "+ key +" LIKE '%"+ obj + "%'"); 		
        	}else if(obj instanceof Integer || obj instanceof Long ) {
        		where.append(" AND "+ key +"="+ String.valueOf(obj));
        	}
        }
		return where;
	}
}
