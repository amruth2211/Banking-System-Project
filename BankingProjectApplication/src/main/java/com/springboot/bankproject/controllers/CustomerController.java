package com.springboot.bankproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankproject.model.Customer;
import com.springboot.bankproject.model.Employee;
import com.springboot.bankproject.services.BankService;
import com.springboot.bankproject.services.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BankService bankService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("customer-page");
		mav.addObject("bankNames",bankService.getBankNames());
		return mav;
		
	}
	
	
	@GetMapping("/list")
	public List<Customer> showAllCustomers() {
//		ModelAndView mav = new ModelAndView("list-customers");
//		mav.addObject("employees", employeeService.showAllEmployees());
//		return mav;
		return customerService.showAllCustomers();
	}
//	
//	@GetMapping("/addEmployeeForm")
//	public ModelAndView addEmployeeForm() {
//		ModelAndView mav = new ModelAndView("add-employee-form");
//		Employee newEmployee = new Employee();
//		mav.addObject("employee", newEmployee);
//		return mav;
//	}
//	
//	@PostMapping("/saveEmployee")
//	public String saveEmployee(@ModelAttribute Employee employee) {
//		employeeService.createEmployee(employee);
//		return "redirect:/list";
//	}
//	
//	@GetMapping("/showUpdateForm")
//	public ModelAndView showUpdateForm(@RequestParam Integer employeeId) {
//		ModelAndView mav = new ModelAndView("add-employee-form");
//		Employee employee = employeeService.getEmployeeById(employeeId);
//		mav.addObject("employee", employee);
//		return mav;
//	}
//	
//	@GetMapping("/deleteEmployee")
//	public String deleteEmployee(@RequestParam Integer employeeId) {
//		employeeService.deleteEmployee(employeeId);
//		return "redirect:/list";
//	}
//	
	
}
