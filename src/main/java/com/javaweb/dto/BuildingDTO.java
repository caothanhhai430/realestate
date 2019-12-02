package com.javaweb.dto;

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
	private Long costRent;
	private String serviceCost;
	private String carCost;
	private String motorbikeCost;
	private String overtimeCost;
	private String electricityCost;
	private String deposit;
	private String payment;
	private String timeRent;
	private String timeDecorator;
	private String managerName;
	private String managerPhone;
	private Long costRentFrom;
	private Long costRentTo;
	private Long areaRentFrom;
	private Long areaRentTo;
	private String costDescription;
	private String[] buildingType;
	private Long staffId;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Long getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Long buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Long getCostRent() {
		return costRent;
	}

	public void setCostRent(Long costRent) {
		this.costRent = costRent;
	}

	public String getCostDescription() {
		return costDescription;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}

	public String getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getCarCost() {
		return carCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public String getMotorbikeCost() {
		return motorbikeCost;
	}

	public void setMotorbikeCost(String motorbikeCost) {
		this.motorbikeCost = motorbikeCost;
	}

	public String getOvertimeCost() {
		return overtimeCost;
	}

	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}

	public String getElectricityCost() {
		return electricityCost;
	}

	public void setElectricityCost(String electricityCost) {
		this.electricityCost = electricityCost;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTimeRent() {
		return timeRent;
	}

	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}

	public String getTimeDecorator() {
		return timeDecorator;
	}

	public void setTimeDecorator(String timeDecorator) {
		this.timeDecorator = timeDecorator;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String[] getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String[] buildingType) {
		this.buildingType = buildingType;
	}
	
	public BuildingDTO() {
		
	}

	public Long getCostRentFrom() {
		return costRentFrom;
	}

	public void setCostRentFrom(Long costRentFrom) {
		this.costRentFrom = costRentFrom;
	}

	public Long getCostRentTo() {
		return costRentTo;
	}

	public void setCostRentTo(Long costRentTo) {
		this.costRentTo = costRentTo;
	}

	public Long getAreaRentFrom() {
		return areaRentFrom;
	}

	public void setAreaRentFrom(Long areaRentFrom) {
		this.areaRentFrom = areaRentFrom;
	}

	public Long getAreaRentTo() {
		return areaRentTo;
	}

	public void setAreaRentTo(Long areaRentTo) {
		this.areaRentTo = areaRentTo;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}

}
