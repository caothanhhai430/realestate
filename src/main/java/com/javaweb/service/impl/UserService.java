package com.javaweb.service.impl;

import com.javaweb.annotation.Transactional;
import com.javaweb.repository.impl.UserRepository;
import com.javaweb.service.IUserService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@ManagedBean
public class UserService implements IUserService {

    @Inject
    private UserRepository repository;

    @Override
    public List<Map<String, Object>> findAssignmentByBuildingId(Long id) {
        return repository.findAssignByBuildingId(id);
    }

    @Override
    public List<Map<String, Object>> findAssignmentByCustomerId(Long id) {
        return repository.findAssignByCustomerId(id);
    }

    @Override
    public List<Map<String, Object>> findAllActiveStaff() {
        return repository.findAllActiveStaff();
    }

    @Override
    @Transactional
    public void assignBuilding(List<Long> staffId, Long buildingId){
        repository.deleteAssignmentStaffByBuildingId(buildingId);
        repository.assignBuildingForStaff(staffId,buildingId);
    }

    @Override
    @Transactional
    public void assignCustomer(List<Long> staffId, Long customerId){
        repository.deleteCustomerStaffByCustomerId(customerId);
        repository.assignCustomerForStaff(staffId, customerId);
    }
}
