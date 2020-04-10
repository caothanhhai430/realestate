package com.javaweb.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng trệt"),
	NGUYEN_CAN("Nguyên căn"),
	NOI_THAT("Nội thất");
	
	private final String buildingType;
	BuildingTypeEnum(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getBuildingType() {
		return buildingType;
	}
}
