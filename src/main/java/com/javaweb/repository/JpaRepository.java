package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.paging.Pageable;

public interface JpaRepository<T> {
	List<T> findAll(String sql);
	T findById(long id);
	public Long save(Object object);
	public Long update(Object object);
	public void delete(long id[]);
	public void delete(long id);
}
