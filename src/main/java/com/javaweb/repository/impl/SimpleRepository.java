package com.javaweb.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaweb.Helper.MapToSqlInsert;
import com.javaweb.Helper.MapToSqlSearch;
import com.javaweb.Helper.PageToSqlSearch;
import com.javaweb.annotation.Table;
import com.javaweb.builder.SqlBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.mapper.impl.ResultSetMapper;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.JpaRepository;
import com.mysql.jdbc.Statement;

public class SimpleRepository<T> implements JpaRepository<T> {
	private  Class<T> zClass;
	
	@SuppressWarnings("unchecked")
	SimpleRepository(){
			Type type = getClass().getGenericSuperclass();
			ParameterizedType parameterizedType = (ParameterizedType) type;
			zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	
		
	}	
	@Override
	public List<T> find(Map<String,Object> properies,Pageable pageable,String specialSql) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from " + getTableName()+ " A where 1=1 ");
		sql.append(MapToSqlSearch.toSql(properies));
		sql.append(specialSql);
		sql.append(PageToSqlSearch.toSql(pageable));
		System.out.println(sql.toString());
		
		String SQL = new SqlBuilder().setTableName(getTableName())
		.addWhere(MapToSqlSearch.toSql(properies).toString() + specialSql)
		.setLimit(PageToSqlSearch.toSql(pageable).toString()).build();
		
		System.out.println(SQL);
		
		
		
		List<T> results = new ArrayList<>();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql.toString());
				resultSet = statement.executeQuery();
				results = new ResultSetMapper<T>().rowMapper(resultSet, zClass);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
						try {
							if(connection!=null) {
							connection.close();
							}
							if(statement != null) {
								statement.close();
							}
							if(resultSet != null) {
								resultSet.close();
							}
						}
						 catch (SQLException e) {
							e.printStackTrace();
							return null;
						}
					}
				
		}
		
		return results;

	}
	
	public String getTableName() {
		String tableName = "";
		if(zClass.isAnnotationPresent(Table.class)) {
			Table tableClass = (Table) zClass.getAnnotation(Table.class);
			tableName = tableClass.name();
		}
		return tableName;
	}
	
	@Override
	public Integer save(Map<String, Object> properties) {
		Integer currentRow=null;
		StringBuilder sql = new StringBuilder("insert into ")
				.append(getTableName());
		sql.append(MapToSqlInsert.toSql(properties)); 	
		
		System.out.println(sql.toString());
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				statement.executeUpdate();
				ResultSet rs = statement.getGeneratedKeys();
				
				if (rs.next()){
				    currentRow=rs.getInt(1);
				}
				
				System.out.print("resultSet = "+currentRow);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
						try {
							if(connection!=null) {
							connection.close();
							}
							if(statement != null) {
								statement.close();
							}
						}
						 catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					}
				
		}
		

		
		return currentRow;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		BuildingEntity e = (BuildingEntity) find(map,null,null).get(0); 
		return (T) e; 
	}
	
	@Override
	public List<T> find(String sql) {
		
		List<T> results = new ArrayList<>();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql.toString());
				resultSet = statement.executeQuery();
				results = new ResultSetMapper<T>().rowMapper(resultSet, zClass);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
						try {
							if(connection!=null) {
							connection.close();
							}
							if(statement != null) {
								statement.close();
							}
							if(resultSet != null) {
								resultSet.close();
							}
						}
						 catch (SQLException e) {
							e.printStackTrace();
							return null;
						}
					}
				
		}
		
		return results;

	}

}
