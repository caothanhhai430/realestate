package com.javaweb.mapper;

import java.sql.ResultSet;
import java.util.List;

public interface RowMapper <T>{
	T rowMapper(ResultSet resultSet);
	List<T> rowMapper(ResultSet resultSet, Class<T> zClass);
}
