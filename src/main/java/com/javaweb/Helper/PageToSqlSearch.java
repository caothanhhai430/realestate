package com.javaweb.Helper;

import com.javaweb.paging.Pageable;

public class PageToSqlSearch {
	public static StringBuilder toSql(Pageable pageable) {
		StringBuilder where = new StringBuilder();
		if(pageable==null) return where;
		if(pageable.getPage()!=null && pageable.getLimit()!=null) {
			where.append("Limit ");
			where.append(pageable.getPage()+","+pageable.getLimit());
		}
		
		return where;
	}
}
