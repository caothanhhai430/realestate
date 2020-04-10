package com.javaweb.entity;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.annotation.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="building")
public class BuildingEntity extends AbstractEntity{
	
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="numberofbasement")
	private Long numberOfBasement;

	@Column(name="buildingarea")
	private Long buildingArea;
	
	@Column(name="district")
	private String district;

	@Column(name="ward")
	private String ward;

	@Column(name="street")
	private String street;
	
	@Column(name="structure")
	private String structure;

	@Column(name="costrent")
	private Long rentCost;
	
	@Column(name="costdescription")
	private String costDescription;

	@Column(name="servicecost")
	private String serviceCost;
	
	@Column(name="carcost")
	private String carCost;

	@Column(name="motorbikecost")
	private String motorbikeCost;

	@Column(name="overtimecost")
	private String overtimeCost;

	@Column(name="electricitycost")
	private String electricityCost;

	@Column(name="deposit")
	private String deposit;

	@Column(name="payment")
	private String payment;

	@Column(name="timerent")
	private String rentTime;

	@Column(name="timedecorator")
	private String decoratorTime;

	@Column(name="managername")
	private String managerName;

	@Column(name="managerphone")
	private String managerPhone;
	
	@Column(name="type")
	private String type;

	private Set<RentAreaEntity> rentAreaList;

	Set<UserEntity> staffList=new HashSet<>();

	public void setStaffList(Set<UserEntity> staffList) {
		this.staffList = staffList;
	}

	public Set<UserEntity> getStaffs(){
		return staffList;
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

	public Long getRentCost() {
		return rentCost;
	}

	public String getCostDescription() {
		return costDescription;
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

	public String getType() {
		return type;
	}

	public Set<RentAreaEntity> getRentAreaList() {
		return rentAreaList;
	}

	public Set<UserEntity> getStaffList() {
		return staffList;
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

	public void setStreet(String street) {
		this.street = street;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setRentCost(Long rentCost) {
		this.rentCost = rentCost;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
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

	public void setType(String type) {
		this.type = type;
	}

	public void setRentAreaList(Set<RentAreaEntity> rentAreaList) {
		this.rentAreaList = rentAreaList;
	}

}
