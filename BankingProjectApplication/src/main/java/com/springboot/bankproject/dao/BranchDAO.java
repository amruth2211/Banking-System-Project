package com.springboot.bankproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.model.Branch;
//import com.springboot.bankproject.model.Customer;

public interface BranchDAO {

	public Boolean createBranch(Branch branch) throws SQLException;

	public Branch viewDetailsByIFSC(String ifscCode) throws SQLException;

//	public Boolean updateBranchManager(Branch branch) throws SQLException;
	public List<Branch> showBranches() throws SQLException;

	public Boolean deleteByIFSC(String ifscCode) throws SQLException;

	public List<BankAccount> showBankAccounts() throws SQLException;

	public List<Branch> showBranchesByBankName(String bankName) throws SQLException;

}
