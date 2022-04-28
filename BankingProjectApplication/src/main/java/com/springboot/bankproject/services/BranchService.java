package com.springboot.bankproject.services;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.model.Branch;
import com.springboot.bankproject.repository.AddressRepository;
import com.springboot.bankproject.repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepo;
	public Boolean createBranch(Branch branch) throws SQLException {
		try {
			return branchRepo.createBranch(branch);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Branch> showBranchesByBankName(String bankName) {
		try {
			return branchRepo.showBranchesByBankName(bankName);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Branch viewDetailsByIFSC(String ifscCode)  {
		try {
			return branchRepo.viewDetailsByIFSC(ifscCode);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public List<BankAccount> showBankAccounts() throws SQLException {
		try {
			return branchRepo.showBankAccounts();
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public Boolean deleteByIFSC(String ifscCode)  {
		try {
			return branchRepo.deleteByIFSC(ifscCode);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}

	}
	public List<Branch> showBranches()  {
		try {
			return branchRepo.showBranches();
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
