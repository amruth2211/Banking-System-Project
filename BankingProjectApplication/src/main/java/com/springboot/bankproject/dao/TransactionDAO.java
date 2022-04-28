package com.springboot.bankproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankproject.model.Transaction;


public interface TransactionDAO {
	
	 	public Integer deposit(Integer accountNo,Double amount)
	            throws SQLException;

	    public Integer withDraw(Integer accountNo,Double amount)
	            throws SQLException;

		public List<Transaction> showAllTransactions(int branchCode) 
				throws SQLException;

	    
}

