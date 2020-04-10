package com.javaweb.repository.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.utils.EntityUtils;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean
public class BuildingRepository extends SimpleRepository<BuildingEntity>{

	public List<BuildingEntity> findAll(BuildingSearchBuilder builder,Pageable pageable){
		StringBuilder sql = new StringBuilder();
		String prefix = "building";
		sql.append("SELECT building.* FROM ").append(getTableName()).append(" "+prefix);
		if(builder.getStaffId()!=null){
			sql.append(" INNER JOIN assignmentstaff assign ON " + prefix + ".id = assign.buildingid");
		}
		sql.append(" " + buildQuery(builder,prefix));
		sql.append(" " + EntityUtils.toPaginaitonSql(pageable));
		List<BuildingEntity> list = findAll(sql.toString());
		return list;
	}

	public long count(BuildingSearchBuilder builder){
		StringBuilder sql = new StringBuilder();
		String prefix = "building";
		sql.append("SELECT count(*) FROM ").append(getTableName()).append(" "+prefix);
		if(builder.getStaffId()!=null){
			sql.append(" INNER JOIN assignmentstaff assign ON " + prefix + ".id = assign.buildingid");
		}
		sql.append(" " + buildQuery(builder,prefix));

		return super.count(sql.toString());
	}



	private String buildQuery(BuildingSearchBuilder builder, String prefix){
		BuildingSearchBuilder singleFieldBuilder = new BuildingSearchBuilder.Builder()
				.setName(builder.getName())
				.setBuildingArea(builder.getBuildingArea())
				.setNumberOfBasement(builder.getNumberOfBasement())
				.setDistrict(builder.getDistrict())
				.setWard(builder.getWard())
				.setStreet(builder.getStreet())
				.build();
		Map<String,Object> map = EntityUtils.toMap(singleFieldBuilder);
		String where = EntityUtils.toQuerySql(map,prefix);

		String qlString = "";
		qlString +=  "  WHERE 1=1 ";

		String specialSQL = getSpecialQLString(builder,prefix);
		if(!where.isEmpty() || !specialSQL.isEmpty()){
			qlString = qlString+   where + " " + specialSQL;
		}
		if(builder.getStaffId()!=null) qlString = qlString + " AND"+ prefix+ ".staffid="+builder.getStaffId();
		return qlString;
	}

	private String getSpecialQLString(BuildingSearchBuilder builder, String prefix) {
		StringBuilder sql = new StringBuilder();
		if(builder.getRentCostFrom()!=null) {
			sql.append(" AND " + prefix + "rentCost >="+builder.getRentCostFrom());
		}
		if(builder.getRentCostTo()!=null) {
			sql.append(" AND " + prefix + "rentCost <="+builder.getRentCostTo());
		}

		if(builder.getRentAreaFrom()!=null || builder.getRentAreaTo()!=null) {
			sql.append(" AND EXISTS (SELECT ra FROM rentarea ra WHERE ra.building=" + prefix + "id");

			if(builder.getRentAreaFrom()!=null){
				sql.append(" AND ra.value >="+builder.getRentAreaFrom());
			}
			if(builder.getRentAreaTo()!=null){
				sql.append(" AND ra.value <="+builder.getRentAreaTo());
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

	public void deleteAssignmentStaffByBuildingId(List<Long> ids){
		String arrId = 	ids.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(","));
		String sql = "DELETE FROM assignmentstaff  WHERE buildingid IN (" + arrId + ")";
		entityManager.createExecuteQuery(sql,new ArrayList<>());
	}

	public void deleteAssignmentStaffByBuildingId(Long id){
		this.deleteAssignmentStaffByBuildingId(Arrays.asList(id));
	}
}
