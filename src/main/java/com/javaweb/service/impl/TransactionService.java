package com.javaweb.service.impl;

import com.javaweb.annotation.Transactional;
import com.javaweb.dto.TransactionDTO;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.impl.TransactionRepository;
import com.javaweb.service.ITransactionService;
import com.javaweb.utils.EntityUtils;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
public class TransactionService implements ITransactionService{

	@Inject
	private TransactionRepository repository;

	@Override
	public List<TransactionDTO> findAll(TransactionDTO dto, Pageable pageable) {
		return repository
				.findAll(dto.getCustomerId(),dto.getType(),pageable).stream()
				.map(item-> (TransactionDTO)EntityUtils.toModel(item,TransactionDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public TransactionDTO findById(long id) {
		TransactionEntity en = repository.findById(id);
		return EntityUtils.toModel(en, TransactionDTO.class);

	}

	@Override
	@Transactional
	public Long save(TransactionDTO customer) {
		TransactionEntity entity = EntityUtils.toModel(customer,TransactionEntity.class);
		return repository.save(entity);
	}

	@Override
	public Long count(TransactionDTO dto) {
		return repository.count(dto.getCustomerId(),dto.getType());
	}

}
