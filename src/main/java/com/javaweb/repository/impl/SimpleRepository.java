package com.javaweb.repository.impl;

import java.lang.reflect.Field;
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
import com.javaweb.annotation.Column;
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
	
	@Override
	public Long insert(Object object) {
		Long id=null;
		String sql = this.createSQLInsert(object);
		System.out.println(sql);
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				connection.setAutoCommit(false);
				Class<?> aClass = object.getClass();
				int index = 1;
				while(aClass!=null) {
					Field[] fields = aClass.getDeclaredFields();
					for(int i=0;i<fields.length;i++) {					
						Field field = fields[i];
						field.setAccessible(true);
						Object obj = field.get(object);
						if(obj!=null) {	
							statement.setObject(index, obj);
							index += 1;
						}
					}
					aClass = aClass.getSuperclass();
				}
				
				
				
				statement.executeUpdate();
				ResultSet rs = statement.getGeneratedKeys();
				
				if (rs.next()){
				    id=rs.getLong(1);
				}
				connection.commit();
				
			} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
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
		

		
		return id;

	}
	
	private String createSQLInsert(Object obj) {
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		Class<?> aClass = zClass;
		while(aClass!=null) {
		for(Field field : aClass.getDeclaredFields()) {
				field.setAccessible(true);
				try {
					if(field.get(obj)==null) {
						continue;
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(fields.length()>0) {
					fields.append(",");
					params.append(",");
				}
				if(field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			aClass = aClass.getSuperclass();
		}
		String sql = "INSERT INTO " + this.getTableName() + " (" + fields.toString() + ")"
				+ " VALUES(" + params.toString() + ")";
		return sql;
	
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
