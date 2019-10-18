package com.javaweb.service;

import java.util.List;

import com.javaweb.dto.CustomerDTO;
import com.javaweb.paging.Pageable;

public interface ICustomerService {
	public List<CustomerDTO> findAll(CustomerDTO dto,Pageable pageable);
	public CustomerDTO findById(long id);
	public Integer save(CustomerDTO building);

}
