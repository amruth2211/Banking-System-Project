package com.springboot.bankproject.model;
public class Employee {
    Integer employeeId;
    String employeeName;
    Integer branchCode;
	public Employee(Integer employeeId, String employeeName, Integer branchCode) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.branchCode = branchCode;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
		this.employeeId = null;
		this.employeeName = "";
		this.branchCode = null;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}
    
    
}
