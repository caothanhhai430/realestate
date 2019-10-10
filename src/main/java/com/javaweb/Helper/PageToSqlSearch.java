package com.javaweb.Helper;

import com.javaweb.paging.Pageable;

public class PageToSqlSearch {
	public static String toSql(Pageable pageable) {
		StringBuilder where = new StringBuilder();
		
		if(pageable!=null && pageable.getPage()!=null && pageable.getLimit()!=null) {
			where.append("LIMIT ");
			where.append(pageable.getPage()+","+pageable.getLimit());
		}
		
		return where.toString();
	}
}
