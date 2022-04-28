package com.springboot.bankproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankproject.services.Transactionservice;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	Transactionservice transService;
	
	@GetMapping("/deposit/{accountNo}/{amount}")
	public Integer deposit(@PathVariable Integer accountNo,@PathVariable Double amount)
    {
		return transService.deposit(accountNo,amount);
    }
	@GetMapping("/withDraw/{accountNo}/{amount}")
	public Integer withDraw(@PathVariable Integer accountNo,@PathVariable Double amount)
    {
		return transService.withDraw(accountNo,amount);
    }
}
