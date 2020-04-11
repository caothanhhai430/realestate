package com.javaweb.service;

import com.javaweb.dto.TransactionDTO;
import com.javaweb.paging.Pageable;

import java.util.List;

public interface ITransactionService {
	List<TransactionDTO> findAll(TransactionDTO dto, Pageable pageable);
	TransactionDTO findById(long id);
	Long save(TransactionDTO building);
	Long count(TransactionDTO dto);
}

