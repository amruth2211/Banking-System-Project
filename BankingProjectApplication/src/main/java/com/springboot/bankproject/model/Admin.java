package com.springboot.bankproject.model;

public class Admin {

	Integer adminId;
	String name;
	Integer bankCode;
	
	public Admin() {
		this.adminId = null;
		this.name = "";
		this.bankCode = null;
	}
	public Admin(Integer adminId, String name, Integer bankCode) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.bankCode = bankCode;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBankCode() {
		return bankCode;
	}
	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", bankCode=" + bankCode + "]";
	}
	
	
}
