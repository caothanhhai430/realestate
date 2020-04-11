package com.javaweb.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
	List<Map<String,Object>> findAssignmentByBuildingId(Long id);
	List<Map<String,Object>> findAssignmentByCustomerId(Long id);
	List<Map<String,Object>> findAllActiveStaff();
	void assignBuilding(List<Long> staffId, Long buildingId);
	void assignCustomer(List<Long> staffId,  Long customerId);
}

