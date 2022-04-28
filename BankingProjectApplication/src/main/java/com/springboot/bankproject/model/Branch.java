package com.springboot.bankproject.model;

import java.util.List;
import java.util.Objects;

public class Branch implements Comparable<Branch> {
    Integer branchCode;
    Address address;
    String manager;
    String headOffice;
    Integer bankCode;

	List<BankAccount> bankAccounts;

    public Branch() {
    }

    public Branch(Integer branchCode, Address address, String manager, String headOffice, Integer bankCode) {
		super();
		this.branchCode = branchCode;
		this.address = address;
		this.manager = manager;
		this.headOffice = headOffice;
		this.bankCode = bankCode;
		
	}
    public Branch(Integer branchCode, Address address, String manager, String headOffice, Integer bankCode,
			List<BankAccount> bankAccounts) {
		super();
		this.branchCode = branchCode;
		this.address = address;
		this.manager = manager;
		this.headOffice = headOffice;
		this.bankCode = bankCode;
		this.bankAccounts = bankAccounts;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}

	public Integer getBankCode() {
		return bankCode;
	}

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchCode, manager);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		return Objects.equals(branchCode, other.branchCode) && Objects.equals(manager, other.manager);
	}

	@Override
	public int compareTo(Branch o) {
		 return this.branchCode - o.branchCode;
	}

	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", address=" + address + ", manager=" + manager + ", headOffice="
				+ headOffice + ", bankCode=" + bankCode + ", bankAccounts=" + bankAccounts + "]";
	}


}
