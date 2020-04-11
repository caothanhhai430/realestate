package com.javaweb.entity;

import com.javaweb.annotation.Column;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public abstract class AbstractEntity {

	@Column(name="createddate")
	protected Timestamp createdDate;

	@Column(name="createdby")
	protected String createdBy;

	@Column(name="modifieddate")
	protected Timestamp modifiedDate; 

	@Column(name="modifiedby")
	protected String modifiedBy;


	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public AbstractEntity(){
		this.createdDate = Timestamp.valueOf(LocalDateTime.now());
		this.modifiedDate = Timestamp.valueOf(LocalDateTime.now());
		this.createdBy = "ADMIN";
		this.modifiedBy = "ADMIN";
	}
}
