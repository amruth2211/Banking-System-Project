package com.springboot.bankproject.model;

import java.sql.Date;

public class Transaction {
    Integer accountNo;
    Double amount;
    Date date;
    Integer transactionNo;
	String transactionType;
	
	public Transaction() {
		super();
	}

	public Transaction(Integer accountNo, Double amount, Date date, Integer transactionNo, String transactionType) {
		super();
		this.accountNo = accountNo;
		this.amount = amount;
		this.date = date;
		this.transactionNo = transactionNo;
		this.transactionType = transactionType;
	}

	public Transaction(Integer accountNo, Double amount, Date date, Integer transactionNo) {
		super();
		this.accountNo = accountNo;
		this.amount = amount;
		this.date = date;
		this.transactionNo = transactionNo;
	}
	public Transaction(Integer transactionNo, Integer accountNo, Date date) {
		super();
		this.accountNo = accountNo;
		this.date = date;
		this.transactionNo = transactionNo;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [accountNo=" + accountNo + ", amount=" + amount + ", date=" + date + ", transactionNo="
				+ transactionNo + ", transactionType=" + transactionType + "]";
	}
	


}
