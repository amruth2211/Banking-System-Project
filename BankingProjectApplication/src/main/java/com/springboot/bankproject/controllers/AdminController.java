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

import com.springboot.bankproject.model.Employee;

import com.springboot.bankproject.services.AdminService;
import com.springboot.bankproject.services.BankService;
import com.springboot.bankproject.services.BranchService;
import com.springboot.bankproject.services.CustomerService;
import com.springboot.bankproject.services.EmployeeService;
import com.springboot.bankproject.services.ReversalRequestService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	 EmployeeService employeeService;
	@Autowired
	ReversalRequestService reversalRequestService;
	
	@Autowired
	BankService bankService;
	@Autowired
	BranchService branchService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("admin-page");
		mav.addObject("bankNames",bankService.getBankNames());
		return mav;
	}
	@GetMapping("/viewProfile")
	public ModelAndView viewProfile(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("admin-dashBoard");
		mav.addObject("admins",adminService.viewProfile(Integer.parseInt(paramMap.getFirst("adminId"))));
		mav.addObject("bankNames",paramMap.getFirst("bankNames"));
		return mav;
	}
	@GetMapping("showAdminForm")
	public ModelAndView showAdminDetails(@RequestParam Integer adminId) {
		ModelAndView mav = new ModelAndView("admin-details");
		mav.addObject("admins",adminService.viewProfile(adminId));
		return mav;
	}
	@GetMapping("/customers/list")
	public ModelAndView showAllCustomers(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list-customers");
		mav.addObject("customers", customerService.showAllCustomersByBankName(paramMap.get("bankNames")));
		return mav;
	}
	
	@GetMapping("/branches/list")
	public ModelAndView getAllBranches(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list-branches");
		mav.addObject("branches", branchService.showBranchesByBankName(paramMap.get("bankNames")));
		return mav;
	}

	@GetMapping("employees/list")
	public ModelAndView getAllEmployees(@RequestParam Map<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("employees", employeeService.showAllEmployeesByBankName(paramMap.get("bankNames")));
		return mav;
	}

	@GetMapping("reversalRequests/list")
	 public ModelAndView getRequests() {
		ModelAndView mav = new ModelAndView("list-reversalRequests");
		mav.addObject("reversalRequests", reversalRequestService.getRequests());
		return mav;
	}
	
	
	
	@GetMapping("employees/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		mav.addObject("branches",branchService.showBranches());
		return mav;
	}
	
	@PostMapping("employees/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.createEmployee(employee);
		ModelAndView mav = new ModelAndView("list-employees");
		return "redirect:/employee/list";
	}
	
	@GetMapping("employees/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Integer employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee employee = employeeService.getEmployeeById(employeeId);
		mav.addObject("employee", employee);
		return mav;
	}
	
	@GetMapping("employees/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		ModelAndView mav = new ModelAndView("list-employees");
		return "redirect:employee/list";
	}
	
	
	
	
	
	
	
	
}
