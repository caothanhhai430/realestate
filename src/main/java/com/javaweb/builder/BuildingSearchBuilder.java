package com.javaweb.builder;

public class BuildingSearchBuilder {
	private String name;
	private Long numberOfBasement;
	private Long buildingArea;
	private String district;
	private String ward;
	private String street;
	private Long costRentFrom;
	private Long costRentTo;
	private Long areaRentFrom;
	private Long areaRentTo;
	private String[] buildingType;
	private Long staffId;
	
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


	public Long getCostRentFrom() {
		return costRentFrom;
	}


	public Long getCostRentTo() {
		return costRentTo;
	}


	public Long getAreaRentFrom() {
		return areaRentFrom;
	}


	public Long getAreaRentTo() {
		return areaRentTo;
	}


	public Long getStaffId() {
		return staffId;
	}


	public static class Builder{
		private String name;
		private Long numberOfBasement;
		private Long buildingArea;
		private String district;
		private String ward;
		private String street;
		private Long costRentFrom;
		private Long costRentTo;
		private Long areaRentFrom;
		private Long areaRentTo;
		private String[] buildingType;
		private Long staffId;
		
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

		public String[] getBuildingType() {
			return buildingType;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

		public Long getCostRentFrom() {
			return costRentFrom;
		}

		public Builder setCostRentFrom(Long costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Long getCostRentTo() {
			return costRentTo;
		}

		public Builder setCostRentTo(Long costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Long getAreaRentFrom() {
			return areaRentFrom;
		}

		public Builder setAreaRentFrom(Long areaRentFrom) {
			this.areaRentFrom = areaRentFrom;
			return this;
		}

		public Long getAreaRentTo() {
			return areaRentTo;
		}

		public Builder setAreaRentTo(Long areaRentTo) {
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
