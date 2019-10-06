package com.javaweb.builder;

public class BuildingBuilder {
	private String name;
	private Integer numberOfBasement;
	private Integer buildingArea;
	private String district;
	private String ward;
	private String street;
	private String structure;
	private Integer costRent;
	private String costDescription;
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
	private Integer costRentFrom;
	private Integer costRentTo;
	private Integer areaRentFrom;
	private Integer areaRentTo;
	private String[] buildingType;
	
	
	public String getName() {
		return name;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public Integer getBuildingArea() {
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

	public Integer getCostRent() {
		return costRent;
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

	public String getTimeRent() {
		return timeRent;
	}

	public String getTimeDecorator() {
		return timeDecorator;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public String[] getBuildingType() {
		return buildingType;
	}

	
	
	private BuildingBuilder() {
		
	}
		
	private BuildingBuilder(Builder builder) {
		
		this.name = builder.name;
		this.numberOfBasement = builder.numberOfBasement;
		this.buildingArea = builder.buildingArea;
		this.district = builder.district;
		this.ward = builder.ward;
		this.street = builder.street;
		this.structure = builder.structure;
		this.costRent = builder.costRent;
		this.costDescription = builder.costDescription;
		this.serviceCost = builder.serviceCost;
		this.carCost = builder.carCost;
		this.motorbikeCost = builder.motorbikeCost;
		this.overtimeCost = builder.overtimeCost;
		this.electricityCost = builder.electricityCost;
		this.deposit = builder.deposit;
		this.payment = builder.payment;
		this.timeRent = builder.timeRent;
		this.timeDecorator = builder.timeDecorator;
		this.managerName = builder.managerName;
		this.managerPhone = builder.managerPhone;
		this.buildingType = builder.buildingType;
		this.areaRentFrom = builder.areaRentFrom;
		this.areaRentTo = builder.areaRentTo;
		this.costRentFrom = builder.costRentFrom;
		this.costRentTo = builder.costRentTo;
		
	}


	public Integer getCostRentFrom() {
		return costRentFrom;
	}


	public Integer getCostRentTo() {
		return costRentTo;
	}


	public Integer getAreaRentFrom() {
		return areaRentFrom;
	}


	public Integer getAreaRentTo() {
		return areaRentTo;
	}


	public static class Builder{
		private String name;
		private Integer numberOfBasement;
		private Integer buildingArea;
		private String district;
		private String ward;
		private String street;
		private String structure;
		private Integer costRent;
		private String costDescription;
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
		private Integer costRentFrom;
		private Integer costRentTo;
		private Integer areaRentFrom;
		private Integer areaRentTo;
		private String[] buildingType;
		
		public Builder() {
			
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setBuildingArea(Integer buildingArea) {
			this.buildingArea = buildingArea;
			return this;
		}

		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setStructure(String structure) {
			this.structure = structure;
			return this;
		}

		public Builder setCostRent(Integer costRent) {
			this.costRent = costRent;
			return this;
		}

		public Builder setCostDescription(String costDescription) {
			this.costDescription = costDescription;
			return this;
		}

		public Builder setServiceCost(String serviceCost) {
			this.serviceCost = serviceCost;
			return this;
		}

		public Builder setCarCost(String carCost) {
			this.carCost = carCost;
			return this;
		}

		public Builder setMotorbikeCost(String motorbikeCost) {
			this.motorbikeCost = motorbikeCost;
			return this;
		}

		public Builder setOvertimeCost(String overtimeCost) {
			this.overtimeCost = overtimeCost;
			return this;
		}

		public Builder setElectricityCost(String electricityCost) {
			this.electricityCost = electricityCost;
			return this;
		}

		public Builder setDeposit(String deposit) {
			this.deposit = deposit;
			return this;
		}

		public Builder setPayment(String payment) {
			this.payment = payment;
			return this;
		}

		public Builder setTimeRent(String timeRent) {
			this.timeRent = timeRent;
			return this;
		}

		public Builder setTimeDecorator(String timeDecorator) {
			this.timeDecorator = timeDecorator;
			return this;
		}

		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public Builder setManagerPhone(String managerPhone) {
			this.managerPhone = managerPhone;
			return this;
		}

		public Builder setBuildingType(String[] buildingType) {
			this.buildingType = buildingType;
			return this;
		}
		
		
		public String getName() {
			return name;
		}

		public Integer getNumberOfBasement() {
			return numberOfBasement;
		}

		public Integer getBuildingArea() {
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

		public Integer getCostRent() {
			return costRent;
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

		public String getTimeRent() {
			return timeRent;
		}

		public String getTimeDecorator() {
			return timeDecorator;
		}

		public String getManagerName() {
			return managerName;
		}

		public String getManagerPhone() {
			return managerPhone;
		}

		public String[] getBuildingType() {
			return buildingType;
		}

		public BuildingBuilder build() {
			return new BuildingBuilder(this);
		}

		public Integer getCostRentFrom() {
			return costRentFrom;
		}

		public Builder setCostRentFrom(Integer costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Integer getCostRentTo() {
			return costRentTo;
		}

		public Builder setCostRentTo(Integer costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Integer getAreaRentFrom() {
			return areaRentFrom;
		}

		public Builder setAreaRentFrom(Integer areaRentFrom) {
			this.areaRentFrom = areaRentFrom;
			return this;
		}

		public Integer getAreaRentTo() {
			return areaRentTo;
		}

		public Builder setAreaRentTo(Integer areaRentTo) {
			this.areaRentTo = areaRentTo;
			return this;
		}
		
		
	}
	
}
