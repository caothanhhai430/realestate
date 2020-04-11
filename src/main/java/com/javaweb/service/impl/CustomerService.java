package com.javaweb.service.impl;

import com.javaweb.annotation.Transactional;
import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.dto.CustomerDTO;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.impl.CustomerRepository;
import com.javaweb.repository.impl.TransactionRepository;
import com.javaweb.repository.impl.UserRepository;
import com.javaweb.service.ICustomerService;
import com.javaweb.utils.EntityUtils;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean
public class CustomerService implements ICustomerService{

	@Inject
	private CustomerRepository repository;

	@Inject
	private TransactionRepository transactionRepository;

	@Inject
	private UserRepository userRepository;

	@Override
	public List<CustomerDTO> findAll(CustomerDTO dto, Pageable pageable) {
		CustomerSearchBuilder builder = EntityUtils.toModel(dto,CustomerSearchBuilder.Builder.class).build();
		return repository
				.findAll(builder,pageable).stream()
				.map(item-> (CustomerDTO)EntityUtils.toModel(item,CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO findById(long id) {
		CustomerEntity en = repository.findById(id);
		return EntityUtils.toModel(en, CustomerDTO.class);

	}

	@Override
	@Transactional
	public Long save(CustomerDTO customer) {
		CustomerEntity entity = EntityUtils.toModel(customer,CustomerEntity.class);
		return repository.save(entity);
	}

	@Override
	@Transactional
	public Long update(CustomerDTO customer) {
		CustomerEntity entity = EntityUtils.toModel(customer,CustomerEntity.class);
		return repository.update(entity);
	}

	@Override
	public Long count(CustomerDTO dto) {
		CustomerSearchBuilder builder = EntityUtils.toModel(dto,CustomerSearchBuilder.Builder.class).build();
		return repository.count(builder);
	}

	@Override
	@Transactional
	public boolean delete(List<Long> ids) {
		try{
			userRepository.deleteAssignmentStaffByCustomerId(ids);
			transactionRepository.deleteByCustomerId(ids);
			repository.delete(ids);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
