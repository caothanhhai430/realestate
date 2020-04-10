//package com.javaweb.repository.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import com.javaweb.builder.CustomerSearchBuilder;
//import com.javaweb.builder.SqlBuilder;
//import com.javaweb.entity.CustomerEntity;
//import com.javaweb.paging.Pageable;
//import com.javaweb.utils.EntityUtils;
//
//public class CustomerRepository extends SimpleRepository<CustomerEntity>{
//
//	public List<CustomerEntity> findAll(CustomerSearchBuilder builder,Pageable pageable){
//
//		String where = EntityUtils.toQuerySql(properties);
//		String limit = PageToSqlSearch.toSql(pageable);
//
//		SqlBuilder sqlBuilder = new SqlBuilder()
//				.setTableName(getTableName());
//		if(builder.getStaffId()!=null) {
//			sqlBuilder.setJoin("INNER").setTableName2("staff_customer")
//			.setOn("A.id=B.customerid")
//			.addWhere("AND staffid="+builder.getStaffId());
//		}
//		String SQL = sqlBuilder.addWhere(where).setLimit(limit).build();
//
//		List<CustomerEntity> resutls =  findAll(SQL);
//		return resutls;
//	}
//
//	}
