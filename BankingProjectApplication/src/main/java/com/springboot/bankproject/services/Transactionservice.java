package com.springboot.bankproject.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.Transaction;
import com.springboot.bankproject.repository.TransactionRepository;


@Service
public class Transactionservice {

	@Autowired
	TransactionRepository transactionRepo;
	
	 public Integer deposit(Integer accountNo,Double amount)
	           {
	    		try {
	    			return transactionRepo.deposit(accountNo, amount);
	    		}
	    		catch(Exception e) {
	    			System.out.println(e);
	    			return null;
	    		}
	    	
	    }
	    public Integer withDraw(Integer accountNo,Double amount) {
	    	try {
    			return transactionRepo.withDraw(accountNo, amount);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    			return null;
    		}
	    }
	
		public List<Transaction> showAllTransactions(int branchCode) {
			try {
    			return transactionRepo.showAllTransactions(branchCode);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    			return null;
    		}
		}
	
	
}