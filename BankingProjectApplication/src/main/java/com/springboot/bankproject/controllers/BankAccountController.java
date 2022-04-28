package com.springboot.bankproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.services.BankAccountService;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

	@Autowired
	BankAccountService bankAccountservice;
	
	@PatchMapping("/update/{branchCode}")
	public Integer update(@PathVariable Integer accountNo,@PathVariable Integer branchCode) 
	{
		return bankAccountservice.update(accountNo,branchCode);
    }
	 
//	@GetMapping("/view/{customerId}")
//	public BankAccount viewDetails(@PathVariable Integer accountNo)
//    {
//		return bankAccountservice.viewDetails(accountNo);
//	
//	}
	
	@DeleteMapping("/delete/{customerID}")
	public Integer delete(@PathVariable Integer customerId)
	{
		return bankAccountservice.delete(customerId);
	}
	
//	@PostMapping("/create")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Integer create(@RequestBody BankAccount bankAccount) 
//	{
//		return bankAccountservice.create(bankAccount);
//	}
		
}
