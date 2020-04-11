package com.javaweb.entity;

import com.javaweb.annotation.Column;
import com.javaweb.annotation.Entity;
import com.javaweb.annotation.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class UserEntity extends AbstractEntity{

	@Column(name="id")
	private Long id;
	@Column(name="fullname")
	private String fullname;
	@Column(name="status")
	private Integer status;

	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="avatar")
	private String avatar;
	@Column(name="phone")
	private String phone;

	List<BuildingEntity> buildingList=new ArrayList<>();

	Set<CustomerEntity> customerList=new HashSet<>();

//	Set<RoleEntity> roleList = new HashSet<>();

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<BuildingEntity> getBuildingList() {
		return buildingList;
	}

	public void setCustomerList(Set<CustomerEntity> customerList) {
		this.customerList = customerList;
	}

//	public Set<RoleEntity> getRoleList() {
//		return roleList;
//	}

//	public void setRoleList(Set<RoleEntity> roleList) {
//		this.roleList = roleList;
//	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBuildingList(List<BuildingEntity> buildingList) {
		this.buildingList = buildingList;
	}

	public Set<CustomerEntity> getCustomerList() {
		return customerList;
	}

}
