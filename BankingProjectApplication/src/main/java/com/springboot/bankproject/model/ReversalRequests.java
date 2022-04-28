package com.springboot.bankproject.model;

import java.sql.Date;

public class ReversalRequests {
    Integer reqId;
    Integer transactionNo;
    Date reqDate;
    Transaction transaction;
    
	public ReversalRequests(Integer reqId, Integer transactionNo, Date reqDate) {
		super();
		this.reqId = reqId;
		this.transactionNo = transactionNo;
		this.reqDate = reqDate;
	}

	public ReversalRequests(Integer reqId, Integer transactionNo, Date reqDate, Transaction transaction) {
		super();
		this.reqId = reqId;
		this.transactionNo = transactionNo;
		this.reqDate = reqDate;
		this.transaction = transaction;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public Integer getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	@Override
	public String toString() {
		return "ReversalRequests [reqId=" + reqId + ", transactionNo=" + transactionNo + ", reqDate=" + reqDate
				+ ", transaction=" + transaction + "]";
	}

    
}
