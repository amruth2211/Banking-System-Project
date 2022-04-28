package com.springboot.bankproject.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankproject.services.BankAccountService;
import com.springboot.bankproject.services.BankService;
import com.springboot.bankproject.services.BranchService;
import com.springboot.bankproject.services.CustomerService;
import com.springboot.bankproject.services.EmployeeService;
import com.springboot.bankproject.services.Transactionservice;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	Transactionservice transactionService;
	
	@Autowired
	BankAccountService bankAccountService;
	
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("employee-page");
		mav.addObject("bankNames",bankService.getBankNames());
		mav.addObject("branches",branchService.showBranches());
		return mav;
	}
	
	@GetMapping("/viewProfile")
	public ModelAndView viewProfile(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("employee-dashBoard");
		mav.addObject("employees",employeeService.getEmployeeById(Integer.parseInt(paramMap.getFirst("employeeId"))));
		mav.addObject("bankNames",paramMap.getFirst("bankNames"));
		mav.addObject("branchCode",paramMap.getFirst("branches"));
		return mav;
	}
	
	@GetMapping("showEmployeeForm")
	public ModelAndView showEmployeeDetails(@RequestParam Integer employeeId) {
		ModelAndView mav = new ModelAndView("employee-details");
		mav.addObject("employees",employeeService.getEmployeeById(employeeId));
		return mav;
	}
	
	@GetMapping("/customers/list")
	public ModelAndView showAllCustomers(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list-customers");
		mav.addObject("customers", customerService.showAllCustomersByBankName(paramMap.get("bankNames")));
		return mav;
	}
	
	@GetMapping("/transactions/list")
	public ModelAndView showAllTransactions(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list-transactions");
		mav.addObject("transactions", transactionService.showAllTransactions(Integer.parseInt(paramMap.get("branchCode"))));
		return mav;
	}
	
	@GetMapping("/bankAccounts/list")
	public ModelAndView showAllBankAccounts(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list-bankAccounts");
		mav.addObject("bankAccounts", bankAccountService.showAllBankAccounts(Integer.parseInt(paramMap.get("branchCode"))));
		return mav;
	}
	
	
	

	
	
}
