package com.javaweb.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.Helper.MapToSqlSearch;
import com.javaweb.Helper.PageToSqlSearch;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.builder.SqlBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.paging.Pageable;

public class BuildingRepository extends SimpleRepository<BuildingEntity>{

	public List<BuildingEntity> findAll(Map<String,Object> properties,
			Pageable pageable,BuildingSearchBuilder builder){
		
		SqlBuilder sqlBuilder = new SqlBuilder()
				.setTableName(getTableName());
		if(builder.getStaffId()!=null) {
			sqlBuilder.setJoin("INNER").setTableName2("assignmentstaff")
			.setOn("A.id=B.buildingid")
			.addWhere("AND staffid="+builder.getStaffId());
		}
		String SQL = sqlBuilder
				.addWhere(MapToSqlSearch.toSql(properties).toString().trim())
				.addWhere(getSpecialSQL(builder).trim())
				.setLimit(PageToSqlSearch.toSql(pageable).toString()).build();
		
		System.out.println(SQL);
		return find(SQL);
		
	}
	
	private String getSpecialSQL(BuildingSearchBuilder builder) {
		StringBuilder sql = new StringBuilder();
		if(builder.getCostRentFrom()!=null) {
			sql.append(" AND costrent >="+builder.getCostRentFrom());
		}
		if(builder.getCostRentTo()!=null) {
			sql.append(" AND costrent <="+builder.getCostRentTo());
		}
		
		if(builder.getAreaRentFrom()!=null || builder.getAreaRentTo()!=null) {
			sql.append(" AND EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid=A.id");
			if(builder.getAreaRentFrom()!=null){
				sql.append(" AND ra.value >="+builder.getAreaRentFrom());
			}
			if(builder.getAreaRentTo()!=null){
				sql.append(" AND ra.value <="+builder.getAreaRentTo());
			}
			sql.append(")");
		}
		if(builder.getBuildingType()!=null && builder.getBuildingType().length>0) {
			
			sql.append(" AND (");
			String s = Arrays.stream(builder.getBuildingType())
			.map(e->"type LIKE '%"+e+"%'").collect(Collectors.joining(" OR "));
			sql.append(s+")");
			
	}
		return sql.toString();
	}
}
