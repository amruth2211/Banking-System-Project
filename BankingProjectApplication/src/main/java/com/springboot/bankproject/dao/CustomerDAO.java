package com.springboot.bankproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankproject.model.Customer;


public interface CustomerDAO {
//	public String welcome(Integer customerId)
//            throws SQLException;
	
//	public Customer viewProfile(Integer customerId)
//            throws SQLException;

//    public int updateProfile(String name,Address address)
//            throws SQLException;
    
//	public int editProfileForm(String name,Address address)
//            throws SQLException;
	
//	public int create(Integer customerId)
//            throws SQLException;
//	
//	public int delete(Integer customerId)
//            throws SQLException;
//	
	public List<Customer> showAllCustomers() 
			throws SQLException;

	public List<Customer> showAllCustomersByBankName(String bankName) throws SQLException;
}
