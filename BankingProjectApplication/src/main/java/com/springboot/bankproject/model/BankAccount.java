package com.springboot.bankproject.model;

import java.util.List;

public class BankAccount {
    Integer accountNo;
    String type;
    Integer branchCode;
    Integer customerId;
    double accBalance;

    List<Transaction> transactions;
    
	public BankAccount() {
		this.accountNo = null;
		this.type = "";
		this.branchCode = null;
		this.customerId = null;
		this.accBalance = 0.0;
	}
	
	public BankAccount(Integer accountNo, String type, Integer branchCode, Integer customerId, double accBalance,
			List<Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.type = type;
		this.branchCode = branchCode;
		this.customerId = customerId;
		this.accBalance = accBalance;
		this.transactions = transactions;
	}
	public BankAccount(Integer accountNo, String type, Integer branchCode, Integer customerId,double accBalance) {
		super();
		this.accountNo = accountNo;
		this.type = type;
		this.branchCode = branchCode;
		this.customerId = customerId;
		this.accBalance=accBalance;
	}
	public BankAccount(Integer accountNo, String type, Integer branchCode, Integer customerId) {
		super();
		this.accountNo = accountNo;
		this.type = type;
		this.branchCode = branchCode;
		this.customerId = customerId;
	}
	

	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", type=" + type + ", branchCode=" + branchCode + ", customerId="
				+ customerId + ", accBalance=" + accBalance + ", transactions=" + transactions + "]";
	}
  
	


}
//
//class SavingsAccount extends BankAccount {
//    static double rateOfInterest = 10;
//
//    public SavingsAccount(Integer accountNo, Integer customerId, Integer branchCode) {
//        super(accountNo, customerId, branchCode);
//    }
//
//    public double getYearlyInterest() {
//        return ((getAccBalance() * getRateOfInterest()) / 100);
//
//    }
//
//    private double getRateOfInterest() {
//        return rateOfInterest;
//    }
//
//    public double getComputedInterest(int years) {
//        double res = getYearlyInterest();
//        return res * years;
//    }
//}
//
//class CurrentAccount extends BankAccount {
//    double avgDailyTransaction;
//
//    CurrentAccount() {
//        super();
//        this.avgDailyTransaction = 0.0;
//    }
//
//    public CurrentAccount(Integer accountNo, Integer customerId, Integer branchCode, double avgDailyTransaction) {
//        super(accountNo, customerId, branchCode);
//        this.avgDailyTransaction = avgDailyTransaction;
//    }
//
//    public void setAvgDailyTransaction(double t) {
//        avgDailyTransaction = t;
//    }
//
//    public double getAvgDailyTransaction() {
//        return avgDailyTransaction;
//
//    }
//
//    public double getTotalTransactionAmount(int days) {
//        return avgDailyTransaction * days;
//    }
//
//    public double getYearlyTransaction() {
//        return getTotalTransactionAmount(365);
//    }
//
//    @Override
//	public String toString() {
//		return "CurrentAccount [avgDailyTransaction=" + avgDailyTransaction + ", getAvgDailyTransaction()="
//				+ getAvgDailyTransaction() + ", getYearlyTransaction()=" + getYearlyTransaction() + "]";
//	}
//    
//}
