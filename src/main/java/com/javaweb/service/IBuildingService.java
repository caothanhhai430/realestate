package com.javaweb.service;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.Pageable;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingDTO dto,Pageable pageable);
	BuildingDTO findById(long id);
	Long save(BuildingDTO building);
	Long count(BuildingDTO building);
	Long update(BuildingDTO building);
	boolean delete(List<Long> ids);
}
