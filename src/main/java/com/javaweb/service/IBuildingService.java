package com.javaweb.service;

import java.util.List;

import com.javaweb.builder.BuildingBuilder;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.Pageable;

public interface IBuildingService {
	public List<BuildingDTO> findAll(BuildingDTO dto,Pageable pageable);
	public BuildingDTO findById(int id);
	public Integer save(BuildingDTO building);
}
