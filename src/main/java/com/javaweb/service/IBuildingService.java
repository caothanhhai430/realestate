package com.javaweb.service;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.Pageable;

public interface IBuildingService {
	public List<BuildingDTO> findAll(BuildingDTO dto,Pageable pageable);
	public BuildingDTO findById(long id);
	public Long save(BuildingDTO building);
}
