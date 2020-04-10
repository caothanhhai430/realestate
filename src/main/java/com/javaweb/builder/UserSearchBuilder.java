package com.javaweb.builder;

public class UserSearchBuilder {
	private String fullname;
//	private Long staffId;
	private String phone;

//	public Long getStaffId() {
//		return staffId;
//	}

	public String getFullname() {
		return fullname;
	}

	public String getPhone() {
		return phone;
	}

	private UserSearchBuilder() {

	}
	private UserSearchBuilder(Builder builder) {
		this.fullname = builder.fullname;
		this.phone = builder.phone;
	}
	
	public static class Builder {
		private String fullname;
		private String phone;

		public Builder setName(String fullname) {
			this.fullname = fullname;
			return this;
		}
		public String getPhone() {
			return phone;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getFullname() {
			return fullname;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserSearchBuilder build() {
			return new UserSearchBuilder(this);
		}
		
	}
	
}
