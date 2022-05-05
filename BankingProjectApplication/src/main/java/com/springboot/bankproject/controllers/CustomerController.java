package com.springboot.bankproject.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.model.Employee;
import com.springboot.bankproject.services.BankAccountService;
import com.springboot.bankproject.services.BankService;
import com.springboot.bankproject.services.CustomerService;
import com.springboot.bankproject.services.Transactionservice;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Transactionservice transactionService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	BankAccountService bankAccountService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("customer-page");
		mav.addObject("bankNames",bankService.getBankNames());
		return mav;
		
	}
	
	@GetMapping("/viewProfile")
	public ModelAndView viewProfile(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("customer-dashBoard");
		mav.addObject("customers",customerService.viewProfile(Integer.parseInt(paramMap.getFirst("customerId"))));
		mav.addObject("bankNames",paramMap.getFirst("bankNames"));
		mav.addObject("accountNo",paramMap.getFirst("accountNo"));
		return mav;
	}
	
	@GetMapping("showCustomerForm")
	public ModelAndView showEmployeeDetails(@RequestParam Integer customerId) {
		ModelAndView mav = new ModelAndView("customer-details");
		mav.addObject("customers",customerService.viewProfile(customerId));
		return mav;
	}
	
	@GetMapping("/transactions/list")
	public ModelAndView showAllTransactions(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("customer-transactions");
		mav.addObject("transactions", transactionService.showTransactionsByAccountNo(Integer.parseInt(paramMap.get("accountNo"))));
		return mav;
	}
	
	@GetMapping("/depositForm")
	public ModelAndView deposit(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("customer-deposit");
//		BankAccount bankAccount =new BankAccount();
//		mav.addObject("accountNo",Integer.parseInt(paramMap.get("accountNo")));
//		bankAccountService.deposit(Double.parseDouble(paramMap.get("amount")),Integer.parseInt(paramMap.get("accountNo")));
		return mav;
	}
	
	@PostMapping("saveDeposit")
	public ModelAndView saveDeposit(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("deposit-display");
		bankAccountService.deposit(Double.parseDouble(paramMap.getFirst("amount")),Integer.parseInt(paramMap.getFirst("accountNumber")));
//		if(bankAccountService.deposit(Double.parseDouble(paramMap.getFirst("amount")),Integer.parseInt(paramMap.getFirst("accountNumber"))))
//		{
//			mav.addObject("value",true);
//		}
		mav.addObject("accountNumber",paramMap.getFirst("accountNumber"));
		mav.addObject("name",paramMap.getFirst("name"));
		return mav;
	}
	
	@GetMapping("/withDrawForm")
	public ModelAndView withDraw(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("customer-withDraw");
		return mav;
	}
	
	@PostMapping("savewithDraw")
	public ModelAndView savewithDraw(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("withDraw-display");
		bankAccountService.withDraw(Double.parseDouble(paramMap.getFirst("amount")),Integer.parseInt(paramMap.getFirst("accountNumber")));
		mav.addObject("accountNumber",paramMap.getFirst("accountNumber"));
		mav.addObject("name",paramMap.getFirst("name"));
		return mav;
	}
	
}
