package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.Helper.ObjectToMap;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.DTOConverter;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.impl.BuildingRepository;
import com.javaweb.service.IBuildingService;

public class BuildingService implements IBuildingService{

	@Override
	public List<BuildingDTO> findAll(BuildingDTO dto, Pageable pageable) {
		BuildingSearchBuilder specialFieldBuilder = new BuildingSearchBuilder.Builder()
				.setBuildingType(dto.getBuildingType()).setAreaRentFrom(dto.getAreaRentFrom())
				.setAreaRentTo(dto.getAreaRentTo()).setCostRentFrom(dto.getCostRentFrom())
				.setCostRentTo(dto.getCostRentTo()).setStaffId(dto.getStaffId()).build();
		
		BuildingSearchBuilder singleFieldBuilder = new BuildingSearchBuilder.Builder()
				.setName(dto.getName()).setNumberOfBasement(dto.getNumberOfBasement())
				.setBuildingArea(dto.getBuildingArea()).setDistrict(dto.getDistrict())
				.setWard(dto.getWard()).setStreet(dto.getStreet()).build();
		
		Map<String,Object> properties = ObjectToMap.toMap(singleFieldBuilder);
		return new BuildingRepository()
				.findAll(properties,pageable,specialFieldBuilder).stream()
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
