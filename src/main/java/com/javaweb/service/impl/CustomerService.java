//package com.javaweb.service.impl;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import com.javaweb.builder.CustomerSearchBuilder;
//import com.javaweb.converter.DTOConverter;
//import com.javaweb.dto.CustomerDTO;
//import com.javaweb.entity.CustomerEntity;
//import com.javaweb.paging.Pageable;
//import com.javaweb.repository.impl.CustomerRepository;
//import com.javaweb.service.ICustomerService;
//
//public class CustomerService implements ICustomerService{
//
//	@Override
//	public List<CustomerDTO> findAll(CustomerDTO dto, Pageable pageable) {
//		CustomerSearchBuilder singleFieldBuilder = new CustomerSearchBuilder.Builder()
//				.setName(dto.getName()).setEmail(dto.getEmail())
//				.setPhone(dto.getPhone()).build();
//		CustomerSearchBuilder specialFieldBuilder = new CustomerSearchBuilder.Builder()
//				.setStaffId(dto.getStaffId()).build();
//
//		Map<String,Object> properties = ObjectToMap.toMap(singleFieldBuilder);
//		return new CustomerRepository()
//				.findAll(properties,pageable,specialFieldBuilder).stream()
//				.map(item-> (CustomerDTO)DTOConverter.toModel(item,CustomerDTO.class))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public CustomerDTO findById(long id) {
//		CustomerEntity en = new CustomerRepository().findById(id);
//		return DTOConverter.toModel(en, CustomerDTO.class);
//
//	}
//
//	@Override
//	public Long save(CustomerDTO customer) {
//		CustomerEntity entity = DTOConverter.toModel(customer,CustomerEntity.class);
//		return new CustomerRepository().save(entity);
//	}
//
//	@Override
//	public Long update(CustomerDTO customer) {
//		CustomerEntity entity = DTOConverter.toModel(customer,CustomerEntity.class);
//		return new CustomerRepository().update(entity);
//	}
//
//	@Override
//	public void delete(long[] id) {
//		new CustomerRepository().delete(id);
//	}
//
//	@Override
//	public void delete(long id) {
//		new CustomerRepository().delete(id);
//	}
//
//}
