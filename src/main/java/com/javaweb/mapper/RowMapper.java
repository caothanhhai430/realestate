package com.javaweb.mapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface RowMapper <T>{
	List<T> rowMapper(ResultSet resultSet, Class<T> zClass);
	List<Map<String,Object>> getMap(ResultSet resultSet, Class<T> zClass);
}
