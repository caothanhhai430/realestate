package com.javaweb.mapper.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.mapper.RowMapper;

public class ResultSetMapper<T> implements RowMapper<T>{

	@Override
	public T rowMapper(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> rowMapper(ResultSet resultSet, Class<T> zClass) {
		List<T> results = new ArrayList<T>();
		
			try {
				if(zClass.isAnnotationPresent(Entity.class)) {
					ResultSetMetaData rs = resultSet.getMetaData();
					
					
					while(resultSet.next()) {
						Object object = zClass.newInstance();
						for(int i=0;i<rs.getColumnCount();i++) {
							String columnName = rs.getColumnName(i+1);
							Object columnValue = resultSet.getObject(i+1);
							try {
								Class<?> cl = zClass;
								
								while(cl!=null) {	
									Field[] fields = cl.getDeclaredFields();
									for(Field field : fields) {
										if(field.isAnnotationPresent(Column.class)) {
											Column column = field.getAnnotation(Column.class);
											if(column.name().equals(columnName) && columnValue!=null) {
												BeanUtils.setProperty(object, field.getName(), columnValue);
												break;
											}
										}
									}
									cl = cl.getSuperclass();
									
								}
							} catch (IllegalAccessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						results.add((T) object);
					}
				}
			} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// TODO Auto-generated method stub
		return results;
	}

}
