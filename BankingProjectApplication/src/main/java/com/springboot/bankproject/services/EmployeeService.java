package com.springboot.bankproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.Employee;
import com.springboot.bankproject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	
	public boolean createEmployee(Employee emp) {
		try {
			return employeeRepo.createEmployee(emp);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}

	}
	public List<Employee> showAllEmployeesByBankName(String bankName) {
		try {
			return employeeRepo.showAllEmployeesByBankName(bankName);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean deleteEmployee(Integer empId){
		try {
			return employeeRepo.deleteEmployee(empId);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}


	}

	public Employee getEmployeeById(Integer empId){
		try {
			return employeeRepo.getEmployeeById(empId);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public List<Employee> showAllEmployees(){
		try {
			return employeeRepo.showAllEmployees();
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	public boolean updateEmployee(Integer empId, String name){
		try {
			return employeeRepo.updateEmployee(empId,name);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
