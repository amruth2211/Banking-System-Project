package com.springboot.bankproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankproject.model.ReversalRequests;

public interface ReversalRequestDAO {

	public List<ReversalRequests> getRequests() throws SQLException;
	
}
