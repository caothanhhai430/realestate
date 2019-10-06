package com.javaweb.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.Helper.MapToSqlSearch;
import com.javaweb.Helper.PageToSqlSearch;
import com.javaweb.builder.BuildingBuilder;
import com.javaweb.builder.SqlBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.paging.Pageable;

public class BuildingRepository extends SimpleRepository<BuildingEntity>{

	public List<BuildingEntity> findAll(Map<String,Object> properties,
			Pageable pageable,BuildingBuilder builder){
		
		String specialSQL = getSpecialSQL(builder);	
		String where = MapToSqlSearch.toSql(properties).toString() + specialSQL;
		String limit = PageToSqlSearch.toSql(pageable).toString();
		
		String SQL = new SqlBuilder()
				.setTableName(getTableName())
//				.addListSelect("id")
//				.addListSelect("name")
//				.addListSelect("numberofbasement")
//				.addListSelect("costrent")
//				.addListSelect("buildingarea")
//				.addListSelect("district")
//				.setJoin("INNER JOIN")
//				.setTableName2("assignmentstaff")
//				.setOn("A.id = B.buildingid")
//				.addWhere(where)
//				.addWhere("AND B.staffid = 1")
				.setLimit(limit).build();
		System.out.println(SQL);
		return find(SQL);
		
	}
	
	private String getSpecialSQL(BuildingBuilder builder) {
		StringBuilder sql = new StringBuilder();
		if(builder.getCostRentFrom()!=null) {
			sql.append(" And costrent >="+builder.getCostRentFrom());
		}
		if(builder.getCostRentTo()!=null) {
			sql.append(" And costrent <="+builder.getCostRentTo());
		}
		
		if(builder.getAreaRentFrom()!=null || builder.getAreaRentTo()!=null) {
			sql.append(" And Exists (Select * From rentarea ra Where ra.buildingid=A.id");
			if(builder.getAreaRentFrom()!=null){
				sql.append(" And ra.value >="+builder.getAreaRentFrom());
			}
			if(builder.getAreaRentTo()!=null){
				sql.append(" And ra.value <="+builder.getAreaRentTo());
			}
			sql.append(")");
		}
		if(builder.getBuildingType()!=null && builder.getBuildingType().length>0) {
			
			sql.append(" And (");
			String s = Arrays.stream(builder.getBuildingType())
			.map(e->"type Like '%"+e+"%'").collect(Collectors.joining(" OR "));
			sql.append(s+")");
			
	}
		return sql.toString();
	}
}
