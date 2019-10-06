package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.Helper.ObjectToMap;
import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.converter.DTOConverter;
import com.javaweb.dto.CustomerDTO;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.impl.CustomerRepository;
import com.javaweb.service.ICustomerService;

public class CustomerService implements ICustomerService{

	@Override
	public List<CustomerDTO> findAll(CustomerDTO dto, Pageable pageable) {
		CustomerSearchBuilder singleFieldBuilder = new CustomerSearchBuilder.Builder()
				.setName(dto.getName()).setEmail(dto.getEmail())
				.setPhone(dto.getPhone()).build();
		CustomerSearchBuilder specialFieldBuilder = new CustomerSearchBuilder.Builder()
				.setStaffId(dto.getStaffId()).build();
		
		Map<String,Object> properties = ObjectToMap.toMap(singleFieldBuilder);
		return new CustomerRepository()
				.findAll(properties,pageable,specialFieldBuilder).stream()
				.map(item-> (CustomerDTO)DTOConverter.convertToDTO(item,CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(CustomerDTO Customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
