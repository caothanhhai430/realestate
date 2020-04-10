package com.javaweb.utils;

import com.javaweb.enums.BuildingTypeEnum;
import com.javaweb.enums.DistrictEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EnumUtils{
	public static Map<String,String> getBuildingTypes(){
		Map<String,String> buildingTypes = new HashMap<>();
		for(BuildingTypeEnum key : BuildingTypeEnum.values()) {
			buildingTypes.put(key.name(),key.getBuildingType());
		}

		//sorted
		Map<String, String> treeMap = new TreeMap<>(buildingTypes);
		return treeMap;
	}
	
	public static Map<String,String> getDistricts(){
		Map<String,String> districts = new HashMap<>();
		
		for(DistrictEnum key : DistrictEnum.values()) {
			districts.put(key.name(),key.getDistrictName());
		}

		//sorted
		Map<String, String> treeMap = new TreeMap<>(districts);
		return treeMap;
	}
	
	
}
