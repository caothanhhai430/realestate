package com.javaweb.mapper.impl;

import com.javaweb.JPA.EntityManager;
import com.javaweb.annotation.Entity;
import com.javaweb.mapper.RowMapper;
import com.javaweb.utils.EntityUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetMapper<T> implements RowMapper<T> {

	@Override
	public List<T> rowMapper(ResultSet resultSet, Class<T> zClass) {
		List<T> results = new ArrayList<T>();
		Map<String, String> mapColumnName = EntityUtils.getMapColumnName(zClass);
		try {
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData rs = resultSet.getMetaData();
				Map<String, Object> rsHashMap = new HashMap<>();
				while (resultSet.next()) {
					for (int i = 1; i <= rs.getColumnCount(); i++) {
						rsHashMap.put(mapColumnName.get(rs.getColumnName(i)), resultSet.getObject(i));
					}
					Object entity = zClass.newInstance();
					BeanUtils.populate(entity, rsHashMap);
					results.add((T) entity);
					rsHashMap.clear();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public List<Map<String, Object>> getMap(ResultSet resultSet, Class<T> zClass) {
		List<Map<String, Object>> results = new ArrayList<>();
		try {
			ResultSetMetaData rs = resultSet.getMetaData();
			while (resultSet.next()) {
				Map<String, Object> rsHashMap = new HashMap<>();
				for (int i = 1; i <= rs.getColumnCount(); i++) {
					rsHashMap.put(rs.getColumnName(i), resultSet.getObject(i));
				}
				results.add(rsHashMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return results;
	}
}
