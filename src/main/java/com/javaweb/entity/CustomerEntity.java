package com.javaweb.entity;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.annotation.Table;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="customer")
public class CustomerEntity extends AbstractEntity{
	
	@Column
	private Long id;

	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String company;
	@Column
	private String demand;
	@Column
	private Byte status;
	@Column
	private String note;

	Set<UserEntity> staffList=new HashSet<>();

	private Set<TransactionEntity> transactionList=new HashSet<>();

	public void setTransactionList(Set<TransactionEntity> transactionList) {
		this.transactionList = transactionList;
	}

	public Set<TransactionEntity> getTransactionList() {
		return transactionList;
	}

	public Set<UserEntity> getStaffList() {
		return staffList;
	}

	public void setStaffList(Set<UserEntity> staffList) {
		this.staffList = staffList;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}


	
}
