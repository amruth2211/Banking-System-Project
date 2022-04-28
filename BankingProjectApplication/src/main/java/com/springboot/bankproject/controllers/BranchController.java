package com.springboot.bankproject.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.model.Branch;
import com.springboot.bankproject.services.BranchService;

public class BranchController {
	@Autowired
	BranchService branchService;

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/all")
	public List<Branch> showBranches() {
		return branchService.showBranches();

	}

	@GetMapping("/{ifscCode}")
	public Branch showBranchByIFSC(@PathVariable String ifscCode) {
		return branchService.viewDetailsByIFSC(ifscCode);
	}

	@PostMapping("/create/{ifscCode}")
	public Boolean createBranch(@RequestBody Branch branch) throws SQLException {
			return branchService.createBranch(branch);
	}

	@GetMapping("/allAccounts")
	public List<BankAccount> showBankAccounts() throws SQLException {
			return branchService.showBankAccounts();

	}

	@DeleteMapping("/{ifscCode}")
	public boolean deleteBranchUsingIFSC(@PathVariable String ifscCode) {
		return branchService.deleteByIFSC(ifscCode);
	}
}
