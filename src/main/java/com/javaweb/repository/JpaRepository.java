package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.paging.Pageable;

public interface JpaRepository<T> {
	List<T> findAll(String sql);
	T findById(long id);
	 Long save(T object);
	 List<Long> save(List<T> object);
	 Long update(T object);
	 void delete(List<Long> id);
	 void delete(long id);
	 long count(String sql);
}
