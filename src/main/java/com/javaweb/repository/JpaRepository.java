package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.paging.Pageable;

public interface JpaRepository<T> {
	List<T> findAll(String sql);
	T findById(long id);
	Integer save(Map<String,Object> properties);
}
