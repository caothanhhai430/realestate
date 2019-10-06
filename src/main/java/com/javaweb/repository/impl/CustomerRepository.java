package com.javaweb.repository.impl;

import java.util.List;
import java.util.Map;

import com.javaweb.Helper.MapToSqlSearch;
import com.javaweb.Helper.PageToSqlSearch;
import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.builder.SqlBuilder;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.paging.Pageable;

public class CustomerRepository extends SimpleRepository<CustomerEntity>{

	public List<CustomerEntity> findAll(Map<String,Object> properties,
			Pageable pageable, CustomerSearchBuilder builder){
		
		String where = MapToSqlSearch.toSql(properties).toString();
		String limit = PageToSqlSearch.toSql(pageable).toString();
		
		SqlBuilder sqlBuilder = new SqlBuilder()
				.setTableName(getTableName());
		if(builder.getStaffId()!=null) {
			sqlBuilder.setJoin("INNER").setTableName2("staff_customer")
			.setOn("A.id=B.customerid")
			.addWhere("AND staffid="+builder.getStaffId());
		}
		String SQL = sqlBuilder.addWhere(where).setLimit(limit).build();
		System.out.println(SQL);
		List<CustomerEntity> resutls =  find(SQL);
		return resutls;
	}
	
	}
