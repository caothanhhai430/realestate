package com.javaweb.entity;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.annotation.Table;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="transaction")
public class TransactionEntity extends AbstractEntity{

	@Column
	private Long id;
	@Column
	private String note;
	@Column
	private Integer type;

	private CustomerEntity customer;

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CustomerEntity getCustomer() {
		return customer;
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
