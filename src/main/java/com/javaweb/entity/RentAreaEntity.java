package com.javaweb.entity;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.annotation.Table;

@Entity
@Table(name="rentarea")
public class RentAreaEntity extends AbstractEntity{
	@Column(name="id")
	private Long id;

	@Column(name="value")
	private Integer value;

	@Column(name = "buildingid")
	private Long buildingId;

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getValue() {
		return value;
	}

	public RentAreaEntity() {
	}
	public RentAreaEntity(Integer value,Long buildingId){
		this.buildingId = buildingId;
		this.value = value;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
