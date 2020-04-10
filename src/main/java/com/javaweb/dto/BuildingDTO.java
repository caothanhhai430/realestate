package com.javaweb.dto;

import com.javaweb.enums.BuildingTypeEnum;
import com.javaweb.enums.DistrictEnum;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BuildingDTO extends AbstractDTO{
	
	private Long id;
	private String name;
	private Long numberOfBasement;
	private Long buildingArea;
	private String district;
	private String ward;
	private String rentArea;
	private String street;
	private String structure;
	private String rank;
	private String direction;
	private List<RentAreaDTO> rentAreaList;
	
	private Long rentCost;
	private String serviceCost;
	private String carCost;
	private String motorbikeCost;
	private String overtimeCost;
	private String electricityCost;
	private String deposit;
	private String payment;
	private String rentTime;
	private String decoratorTime;
	private String managerName;
	private String managerPhone;
	private Long rentCostFrom;
	private Long rentCostTo;
	private Long rentAreaFrom;
	private Long rentAreaTo;
	private String costDescription;
	private String[] buildingType;
	private String type;
	private Long staffId;
	private String address;
	private String buildingTypeInString;




	public String getBuildingTypeInString() {
		getBuildingType();
		if(buildingType==null || buildingType.length<1) return "";
		String result = Arrays.stream(buildingType)
				.map(e->BuildingTypeEnum.valueOf(e).getBuildingType())
				.collect(Collectors.joining(",")); 
		return result;
	}
	
	public String getAddress() {
		address = "";
		if(StringUtils.isNotBlank(street)) address+=street;
		if(StringUtils.isNotBlank(ward)) {
			if(address.length()>0) address = address + ", " ;
			address+=ward;
		}
		if(StringUtils.isNotBlank(district)) {
			if(address.length()>0) address = address + ", " ;
			address += DistrictEnum.valueOf(district).getDistrictName();
		}
		return address;
	}

	public String getRentArea() {
		if(rentArea != null && !rentArea.isEmpty()) return rentArea;
		if(rentAreaList==null || rentAreaList.size()==0) return  "";

		return rentAreaList.stream()
				.map(e-> e.getValue().toString()).sorted().collect(Collectors.joining(","));

	}

	public String getBuildingTypeString() {
		if(buildingType	== null) return "";
		String tempBuildingType = Arrays.stream(buildingType).map(e-> e).collect(Collectors.joining(","));
		return tempBuildingType;
	}



	public void setRentAreaList(List<RentAreaDTO> rentAreaList) {
		this.rentAreaList = rentAreaList;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public Long getBuildingArea() {
		return buildingArea;
	}

	public String getDistrict() {
		return district;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public String getStructure() {
		return structure;
	}

	public String getRank() {
		return rank;
	}

	public String getDirection() {
		return direction;
	}

	public List<RentAreaDTO> getRentAreaList() {
		return rentAreaList;
	}

	public Long getRentCost() {
		return rentCost;
	}

	public String getServiceCost() {
		return serviceCost;
	}

	public String getCarCost() {
		return carCost;
	}

	public String getMotorbikeCost() {
		return motorbikeCost;
	}

	public String getOvertimeCost() {
		return overtimeCost;
	}

	public String getElectricityCost() {
		return electricityCost;
	}

	public String getDeposit() {
		return deposit;
	}

	public String getPayment() {
		return payment;
	}

	public String getRentTime() {
		return rentTime;
	}

	public String getDecoratorTime() {
		return decoratorTime;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public Long getRentCostFrom() {
		return rentCostFrom;
	}

	public Long getRentCostTo() {
		return rentCostTo;
	}

	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}

	public Long getRentAreaTo() {
		return rentAreaTo;
	}

	public String getCostDescription() {
		return costDescription;
	}

	public String[] getBuildingType() {
		if(StringUtils.isNotBlank(type)) {
			buildingType = type.replaceAll("\\s+", "").split(",");
		}
		return buildingType;
	}

	public String getType() {
		return type;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public void setBuildingArea(Long buildingArea) {
		this.buildingArea = buildingArea;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public void setRentArea(Object rentArea) {
		if(rentArea instanceof CharSequence)
		this.rentArea = (String) rentArea;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setRentCost(Long rentCost) {
		this.rentCost = rentCost;
	}

	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public void setMotorbikeCost(String motorbikeCost) {
		this.motorbikeCost = motorbikeCost;
	}

	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}

	public void setElectricityCost(String electricityCost) {
		this.electricityCost = electricityCost;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}

	public void setDecoratorTime(String decoratorTime) {
		this.decoratorTime = decoratorTime;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public void setRentCostFrom(Long rentCostFrom) {
		this.rentCostFrom = rentCostFrom;
	}

	public void setRentCostTo(Long rentCostTo) {
		this.rentCostTo = rentCostTo;
	}

	public void setRentAreaFrom(Long rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}

	public void setRentAreaTo(Long rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}

	public void setBuildingType(String[] buildingType) {
		this.buildingType = buildingType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
