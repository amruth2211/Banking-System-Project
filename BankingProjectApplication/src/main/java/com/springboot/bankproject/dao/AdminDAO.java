package com.springboot.bankproject.dao;

import java.sql.SQLException;

import com.springboot.bankproject.model.Admin;


public interface AdminDAO {
	
	public Admin viewProfile(Integer adminID)
            throws SQLException;
	
	
	
}
