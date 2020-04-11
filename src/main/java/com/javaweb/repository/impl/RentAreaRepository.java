package com.javaweb.repository.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
public class RentAreaRepository extends SimpleRepository<RentAreaEntity>{
    public List<RentAreaEntity> findByBuildingId(long id){
        String query = "SELECT * FROM rentarea where buildingid = ?";
        List<RentAreaEntity> list = super.findAll(query,Arrays.asList(id));
        return  list;
    }
    public void deleteByBuildingId(Long id){
        String sql = "DELETE FROM rentarea WHERE buildingid = ?";
        entityManager.createExecuteQuery(sql,Arrays.asList(id));
    }
}
