package com.springboot.bankproject.services;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.Address;
import com.springboot.bankproject.model.Bank;
import com.springboot.bankproject.repository.BankRepository;


@Service
public class BankService {

	@Autowired
	BankRepository bankRepo;
	
	public List<Bank> getBankNames() {
		try{
			return bankRepo.getBankNames();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

    public Integer create(Bank bank)  {
    	try{
			return bankRepo.create(bank);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    

    public boolean delete(int bankCode) {
	try{
		return bankRepo.delete(bankCode);
	} catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
    }


    public Bank update(int bankCode,Address mainOfficAddress) {
    try{
		return bankRepo.update(bankCode,mainOfficAddress);
	} catch(SQLException e) {
		e.printStackTrace();
		return null;
	}
    }

    public Bank viewBankDetails(int bankCode) {
    try{
 		return bankRepo.viewBankDetails(bankCode);
 	} catch(SQLException e) {
 		e.printStackTrace();
 		return null;
 	}
    }
	
}
