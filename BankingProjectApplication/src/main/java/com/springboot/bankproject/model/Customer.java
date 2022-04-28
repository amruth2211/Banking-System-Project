package com.springboot.bankproject.model;

import java.util.List;

public class Customer {
	Integer customerId;
    String name;
    Address address;
    List<BankAccount> bankAccounts;

    public Customer(Integer customerId,String name, Address address) {
        this.name = name;
        this.address = address;
        this.customerId = customerId;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address.toString();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
    public String toString() {
        return "Customer [address=" + address + ", customerId=" + customerId + ", name=" + name + "]";
    }

}
