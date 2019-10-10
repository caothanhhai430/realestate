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
		StringBuilder sql = new StringBuilder("INSERT INTO ")
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
	public T findById(long id) {
		String sql = "SELECT * FROM " + getTableName() + " WHERE id="+ id;
		return findAll(sql).get(0);
	}
	
	@Override
	public List<T> findAll(String sql) {
		System.out.println(sql);
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
