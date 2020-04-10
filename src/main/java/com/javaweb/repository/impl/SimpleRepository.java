package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.javaweb.JPA.EntityManager;
import com.javaweb.JPA.EntityManagerFactory;
import com.javaweb.utils.EntityUtils;
import org.apache.commons.lang.ArrayUtils;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Table;
import com.javaweb.mapper.impl.ResultSetMapper;
import com.javaweb.repository.JpaRepository;
import com.mysql.jdbc.Statement;

public class SimpleRepository<T> implements JpaRepository<T> {
	private  Class<T> zClass;

	public EntityManager entityManager = EntityManager.getEntityManager();

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

	public Long execute(Object object, String type){
		Long id=null;
		List<Object> parameters = new ArrayList<>();
		String sql = "";
		System.out.println(sql);

		switch (type){
			case "SAVE":
				sql = this.createSQLInsert(object,parameters);
				break;
			case "UPDATE":
				sql = this.createSQLUpdate(object,parameters);
				break;
		}

		ResultSet resultSet = entityManager.createExecuteQuery(sql,parameters);
		try {
			if (resultSet.next()){
				id=resultSet.getLong(1);
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}


	@Override
	public Long update(Object object) {
		return execute(object,"UPDATE");
	}
	@Override
	public Long save(Object object) {
		return execute(object,"SAVE");
	}


	@Override
	public List<Long> save(List<T> list) {
		List<Long> ids = new ArrayList<>();
		for (T obj: list) {
			Long id = this.save(obj);
			ids.add(id);
		}
		return ids;
	}
	
	private String createSQLInsert(Object obj, List<Object> parameters) {
		String sql = "INSERT INTO " + getTableName() + " " + EntityUtils.toInsertSql(obj,parameters);
		return  sql;
	}

	private String createSQLUpdate(Object obj, List<Object> parameters) {
		String sql = "UPDATE " + this.getTableName() + " SET "+ EntityUtils.createUpdateSql(obj,parameters) + " WHERE id=?";
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
		ResultSet resultSet = entityManager.createQuery(sql,new ArrayList<>());
		results = new ResultSetMapper<T>().rowMapper(resultSet, zClass);
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return results;
	}

	@Override
	public void delete(List<Long> ids) {
		if(ids.size()<1) return;
		String arrId = 	ids.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(","));
		String sql = "DELETE FROM " + getTableName() + " WHERE id IN (" + arrId + ")";
		System.out.println(sql);
		ResultSet resultSet = entityManager.createExecuteQuery(sql,new ArrayList<>());
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id) {
		List<Long> ids = new ArrayList<>();
		ids.add(id);
		this.delete(ids);
	}

	@Override
	public long count(String sql) {
		System.out.println(sql);
		long result = 0;
		ResultSet resultSet = entityManager.createQuery(sql,new ArrayList<>());
		try {
			if(resultSet.next()){
				result = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
