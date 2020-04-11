package com.javaweb.service;

import java.util.List;

import com.javaweb.dto.CustomerDTO;
import com.javaweb.paging.Pageable;

public interface ICustomerService {
	List<CustomerDTO> findAll(CustomerDTO dto,Pageable pageable);
	CustomerDTO findById(long id);
	Long save(CustomerDTO customer);
	Long update(CustomerDTO customer);
	public Long count(CustomerDTO dto);
	boolean delete(List<Long> ids);

}

