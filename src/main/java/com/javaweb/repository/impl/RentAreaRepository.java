package com.javaweb.repository.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class RentAreaRepository extends SimpleRepository<RentAreaEntity>{
    public List<RentAreaEntity> findByBuildingId(long id){
        String query = "SELECT * FROM " + getTableName() + " where buildingid = " + id;
        List<RentAreaEntity> list = super.findAll(query);
        return  list;
    }
}
