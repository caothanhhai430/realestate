package com.javaweb.builder;

public class BuildingSearchBuilder {
	private String name;
	private Long numberOfBasement;
	private Long buildingArea;
	private String district;
	private String ward;
	private String street;
	private Long rentCostFrom;
	private Long rentCostTo;
	private Long rentAreaFrom;
	private Long rentAreaTo;
	private String[] buildingType;
	private Long staffId;
	private String managerName;
	private String managerPhone;
	
	private BuildingSearchBuilder() {
		
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

	public String[] getBuildingType() {
		return buildingType;
	}

	public Long getStaffId() {
		return staffId;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	private BuildingSearchBuilder(Builder builder) {
		
		this.name = builder.name;
		this.numberOfBasement = builder.numberOfBasement;
		this.buildingArea = builder.buildingArea;
		this.district = builder.district;
		this.ward = builder.ward;
		this.street = builder.street;
		this.buildingType = builder.buildingType;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
		this.rentCostFrom = builder.rentCostFrom;
		this.rentCostTo = builder.rentCostTo;
		this.staffId = builder.staffId;
		this.managerName = builder.managerName;
		this.managerPhone = builder.managerPhone;
	}

	public static class Builder{
		private String name;
		private Long numberOfBasement;
		private Long buildingArea;
		private String district;
		private String ward;
		private String street;
		private Long rentCostFrom;
		private Long rentCostTo;
		private Long rentAreaFrom;
		private Long rentAreaTo;
		private String[] buildingType;
		private Long staffId;
		private String managerName;
		private String managerPhone;
		public Builder() {
			
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setBuildingArea(Long buildingArea) {
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

		public Builder setBuildingType(String[] buildingType) {
			this.buildingType = buildingType;
			return this;
		}
		

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}


		public Builder setRentCostFrom(Long rentCostFrom) {
			this.rentCostFrom = rentCostFrom;
			return this;
		}

		public Builder setRentCostTo(Long rentCostTo) {
			this.rentCostTo = rentCostTo;
			return this;
		}

		public Builder setRentAreaFrom(Long rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}

		public Builder setRentAreaTo(Long rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}

		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
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
	}
	
}
