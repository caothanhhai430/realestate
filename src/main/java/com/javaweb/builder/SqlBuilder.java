package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

public class SqlBuilder {
	private List<String> listSelect;
	private String tableName;
	private String join;
	private String tableName2;
	private String on;
	private StringBuilder where;
	private String limit;
	
	public SqlBuilder() {
		listSelect = new ArrayList<>();
		where = new StringBuilder();
	}
	
	public SqlBuilder addListSelect(String select) {
		this.listSelect.add(select);
		return this;
	}
	public SqlBuilder setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	public SqlBuilder setTableName2(String tableName) {
		this.tableName2 = tableName;
		return this;
	}
	public SqlBuilder setJoin(String join) {
		this.join = join;
		return this;
	}
	public SqlBuilder setOn(String on) {
		this.on = on;
		return this;
	}
	public SqlBuilder addWhere(String where) {
		if(StringUtils.isNotBlank(where)) {
			this.where.append(" " + where);
		}
		return this;
	}
	public SqlBuilder setLimit(String limit) {
		this.limit = limit;
		return this;
	}
	public String build() {
		StringBuilder sql = new StringBuilder();
		if(listSelect.size()==0) {
			listSelect.add("*");
		}
		sql.append("SELECT ");
		String listSelect = this.listSelect.stream().map(e-> "A."+e).collect(Collectors.joining(", "));
		
		sql.append(listSelect);
		sql.append(" FROM "+tableName + " A");
	
		if(StringUtils.isNotBlank(join) && StringUtils.isNotBlank(tableName2) && StringUtils.isNotBlank(on)) {
			sql.append(" " + join).append(" " + tableName2 + " B").append(" ON " + on);
		}
		if(StringUtils.isNotBlank(where.toString())) {
			sql.append(" WHERE 1=1 " + where.toString());
		}
		if(StringUtils.isNotBlank(limit)) {
			sql.append(" " + limit);
		}
		return sql.toString();
	}
	
	
}
