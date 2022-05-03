package com.springboot.bankproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.Transaction;
import com.springboot.bankproject.repository.TransactionRepository;


@Service
public class Transactionservice {

	@Autowired
	TransactionRepository transactionRepo;
	

	
		public List<Transaction> showAllTransactions(int branchCode) {
			try {
    			return transactionRepo.showAllTransactions(branchCode);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    			return null;
    		}
		}
	
		public List<Transaction> showTransactionsByAccountNo(int accNo){
			try {
    			return transactionRepo.showTransactionsByAccountNo(accNo);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    			return null;
    		}
		}
	
}