package com.springboot.bankproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankproject.model.BankAccount;


public interface BankAccountDAO {
 	public Integer deposit(Integer accountNo,Double amount)
            throws SQLException;

    public Integer withDraw(Integer accountNo,Double amount)
            throws SQLException;
	
//	public int create(BankAccount bankAccount)
//            throws SQLException;

    public int update(Integer accountNo,Integer branchCode)
            throws SQLException;

//	public BankAccount viewDetails(Integer accountNo)
//            throws SQLException;
//	
	public int delete(Integer customerId)
            throws SQLException;

	public List<BankAccount> showAllBankAccounts(int branchCode) 
			throws SQLException;
}
