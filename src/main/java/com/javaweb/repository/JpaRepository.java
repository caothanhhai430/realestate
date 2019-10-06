package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.paging.Pageable;

public interface JpaRepository<T> {
	List<T> find(Map<String,Object> properies,Pageable pageable,String specialSql);
	List<T> find(String sql);
	T findById(int id);
	Integer save(Map<String,Object> properties);
}
