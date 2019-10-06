package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.Helper.ObjectToMap;
import com.javaweb.builder.BuildingBuilder;
import com.javaweb.converter.DTOConverter;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.impl.BuildingRepository;
import com.javaweb.service.IBuildingService;

public class BuildingService implements IBuildingService{

	@Override
	public List<BuildingDTO> findAll(BuildingDTO dto, Pageable pageable) {
		BuildingBuilder buildingBuilder = new BuildingBuilder
				.Builder()
				.setBuildingType(dto.getBuildingType())
				.setAreaRentFrom(dto.getAreaRentFrom())
				.setAreaRentTo(dto.getAreaRentTo())
				.setCostRentFrom(dto.getCostRentFrom())
				.setCostRentTo(dto.getCostRentTo())
				.build();
		dto.setAreaRentFrom(null);
		dto.setAreaRentTo(null);
		dto.setCostRentFrom(null);
		dto.setCostRentTo(null);
//		dto.setCostRent(null);
//		dto.setBuildingType(null);
//		dto.setBuildingArea(null);
		
		Map<String,Object> properties = ObjectToMap.toMap(dto);
		return new BuildingRepository()
				.findAll(properties,pageable,buildingBuilder).stream()
				.map(item-> (BuildingDTO)DTOConverter.convertToDTO(item,BuildingDTO.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public Integer save(BuildingDTO building) {
		Map<String,Object> properties = ObjectToMap.toMap(building);
		return new BuildingRepository().save(properties);
	}

	@Override
	public BuildingDTO findById(int id) {
		// TODO Auto-generated method stub
		BuildingEntity e = new BuildingRepository().findById(id);
		return DTOConverter.convertToDTO(e, BuildingDTO.class);
	}
	
}
