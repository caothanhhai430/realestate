package com.javaweb.builder;

public class BuildingSearchBuilder {
	private String name;
	private Integer numberOfBasement;
	private Integer buildingArea;
	private String district;
	private String ward;
	private String street;
	private Integer costRentFrom;
	private Integer costRentTo;
	private Integer areaRentFrom;
	private Integer areaRentTo;
	private String[] buildingType;
	private Long staffId;
	
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

	public String[] getBuildingType() {
		return buildingType;
	}

	
	
	private BuildingSearchBuilder() {
		
	}
		
	private BuildingSearchBuilder(Builder builder) {
		
		this.name = builder.name;
		this.numberOfBasement = builder.numberOfBasement;
		this.buildingArea = builder.buildingArea;
		this.district = builder.district;
		this.ward = builder.ward;
		this.street = builder.street;
		this.buildingType = builder.buildingType;
		this.areaRentFrom = builder.areaRentFrom;
		this.areaRentTo = builder.areaRentTo;
		this.costRentFrom = builder.costRentFrom;
		this.costRentTo = builder.costRentTo;
		this.staffId = builder.getStaffId();
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


	public Long getStaffId() {
		return staffId;
	}


	public static class Builder{
		private String name;
		private Integer numberOfBasement;
		private Integer buildingArea;
		private String district;
		private String ward;
		private String street;
		private Integer costRentFrom;
		private Integer costRentTo;
		private Integer areaRentFrom;
		private Integer areaRentTo;
		private String[] buildingType;
		private Long staffId;
		
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

		public String[] getBuildingType() {
			return buildingType;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
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

		public Long getStaffId() {
			return staffId;
		}

		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		
		
	}
	
}
