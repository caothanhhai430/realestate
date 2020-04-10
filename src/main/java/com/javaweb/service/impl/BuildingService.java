package com.javaweb.service.impl;

import com.javaweb.annotation.Transactional;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.RentAreaDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.repository.impl.BuildingRepository;
import com.javaweb.repository.impl.RentAreaRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.EntityUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
public class BuildingService implements IBuildingService{

	@Inject
	private BuildingRepository repository;

	@Inject
	private RentAreaRepository rentAreaRepository;


	@Override
	public List<BuildingDTO> findAll(BuildingDTO dto, Pageable pageable) {
		BuildingSearchBuilder builder =EntityUtils.toModel( dto,BuildingSearchBuilder.Builder.class).build();

		List<BuildingDTO> list = repository.findAll(builder,pageable).stream()
				.map(item-> (BuildingDTO)EntityUtils.toModel(item,BuildingDTO.class))
				.collect(Collectors.toList());
		list.stream().forEach(e->{
			List<RentAreaEntity> rentAreaEntityList  = rentAreaRepository.findByBuildingId(e.getId());
			List<RentAreaDTO> rentAreaDTOList =  rentAreaEntityList.stream()
					.map(r-> EntityUtils.toModel(r,RentAreaDTO.class)).collect(Collectors.toList());
			e.setRentAreaList(rentAreaDTOList);
		});
		return list;
	}
	
	@Override
	public BuildingDTO findById(long id) {
		try{
			BuildingEntity e = repository.findById(id);
			BuildingDTO dto = EntityUtils.toModel(e,BuildingDTO.class);
			List<RentAreaEntity> rentAreaEntityList  = rentAreaRepository.findByBuildingId(id);
			List<RentAreaDTO> rentAreaDTOList =  rentAreaEntityList.stream()
					.map(r-> EntityUtils.toModel(r,RentAreaDTO.class)).collect(Collectors.toList());
			dto.setRentAreaList(rentAreaDTOList);
			return dto;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Long save(BuildingDTO building) {
		BuildingEntity entity = EntityUtils.toModel(building, BuildingEntity.class);
		try {
			Long id = repository.save(entity);
			List<RentAreaEntity> rentAreaEntityList = toRentAreaList(building.getRentArea(),id);
			rentAreaRepository.save(rentAreaEntityList);
			return id;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}



	private List<RentAreaEntity> toRentAreaList(String rentArea, Long buildingId){
		List<RentAreaEntity> rentAreaEntityList = new ArrayList<>();
		if(StringUtils.isNotBlank(rentArea)) {
			String[] arr = rentArea.replaceAll("\\s+", "").split(",");
			Arrays.asList(arr).stream().forEach(e->{
				try{
					Integer data = Integer.parseInt(e);
					RentAreaEntity rentAreaEntity = new RentAreaEntity(data,buildingId);
					rentAreaEntityList.add(rentAreaEntity);
				}catch (NumberFormatException ex){
					ex.printStackTrace();
				}
			});
		}
		return rentAreaEntityList;
	}


	@Override
	public Long count(BuildingDTO building) {
		BuildingSearchBuilder builder =EntityUtils.toModel( building,BuildingSearchBuilder.Builder.class).build();
		return repository.count(builder);
	}


	@Override
	@Transactional
	public Long update(BuildingDTO building) {
		deleteRentAreaByBuildingId(building.getId());
		List<RentAreaEntity> rentAreaEntityListNew = toRentAreaList(building.getRentArea(),building.getId());
		rentAreaRepository.save(rentAreaEntityListNew);
		BuildingEntity entity = EntityUtils.toModel(building,BuildingEntity.class);
		repository.update(entity);
		return building.getId();
	}
	private void deleteRentAreaByBuildingId(Long id){
		List<RentAreaEntity> rentAreaEntityList = rentAreaRepository.findByBuildingId(id);
		List<Long> ids = rentAreaEntityList.stream().map(e-> e.getId()).collect(Collectors.toList());
		rentAreaRepository.delete(ids);
	}


	@Override
	@Transactional
	public boolean delete(List<Long> ids) {
		try{
			ids.stream().forEach(e-> deleteRentAreaByBuildingId(e));
			repository.deleteAssignmentStaffByBuildingId(ids);
			repository.delete(ids);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
