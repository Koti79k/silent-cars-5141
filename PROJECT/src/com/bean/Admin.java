package com.bean;

public class Admin {
	
	private int AdminId;
	private String AdminName;
	private String AdminEmail;
	private String adminMobile;
	public Admin(int adminId, String adminName, String adminEmail, String adminMobile) {
		super();
		AdminId = adminId;
		AdminName = adminName;
		AdminEmail = adminEmail;
		this.adminMobile = adminMobile;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminEmail() {
		return AdminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", AdminName=" + AdminName + ", AdminEmail=" + AdminEmail
				+ ", adminMobile=" + adminMobile + "]";
	}
	
	
	
}


	