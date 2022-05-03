package com.springboot.bankproject.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
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
		mav.addObject("transactions", transactionService.showTransactionsByAccountNo(Integer.parseInt(paramMap.get("accountNo"))));
		return mav;
	}
	
}
