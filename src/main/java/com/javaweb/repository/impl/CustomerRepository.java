package com.javaweb.repository.impl;

import java.util.List;
import java.util.Map;

import com.javaweb.Helper.MapToSqlSearch;
import com.javaweb.Helper.PageToSqlSearch;
import com.javaweb.builder.SqlBuilder;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.paging.Pageable;

public class CustomerRepository extends SimpleRepository<CustomerEntity>{

	public List<CustomerEntity> findAll(Map<String,Object> properties,
			Pageable pageable){
		
		String where = MapToSqlSearch.toSql(properties).toString();
		String limit = PageToSqlSearch.toSql(pageable).toString();
		
		String SQL = new SqlBuilder()
				.setTableName(getTableName())
				.addWhere(where)
				.setLimit(limit).build();
		System.out.println(SQL);
		List<CustomerEntity> resutls =  find(SQL);
		return resutls;
	}
	
	}
