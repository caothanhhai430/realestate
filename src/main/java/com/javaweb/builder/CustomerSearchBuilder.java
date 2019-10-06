package com.javaweb.builder;

public class CustomerSearchBuilder {
	private String name;
	private String phone;
	private String email;
	private Long staffId;
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Long getStaffId() {
		return staffId;
	}
	private CustomerSearchBuilder() {
		
	}
	private CustomerSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.phone = builder.phone;
		this.staffId = builder.staffId;
	}
	
	public static class Builder {
		private String name;
		private String phone;
		private String email;
		private Long staffId;
		public String getName() {
			return name;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public String getPhone() {
			return phone;
		}
		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		public String getEmail() {
			return email;
		}
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Long getStaffId() {
			return staffId;
		}
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		public CustomerSearchBuilder build() {
			return new CustomerSearchBuilder(this);
		}
		
	}
	
}
