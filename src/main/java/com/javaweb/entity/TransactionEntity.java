package com.javaweb.entity;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.annotation.Table;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="transaction")
public class TransactionEntity extends AbstractEntity{

	@Column(name="id")
	private Long id;
	@Column(name="note")
	private String note;
	@Column(name="type")
	private Integer type;

	@Column(name="customerid")
	private Long customerId;

	public Long getCustomerid() {
		return customerId;
	}

	public void setCustomerid(Long customerid) {
		this.customerId = customerid;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public Long getId() {
		return id;
	}


}
