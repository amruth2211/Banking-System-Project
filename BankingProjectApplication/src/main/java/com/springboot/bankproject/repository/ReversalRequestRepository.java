package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.ReversalRequestDAO;
import com.springboot.bankproject.model.Employee;
import com.springboot.bankproject.model.ReversalRequests;
import com.springboot.bankproject.model.Transaction;

import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class ReversalRequestRepository implements ReversalRequestDAO{
	
	 private final Connection conn; 

	    public ReversalRequestRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
	    @Override
	    public List<ReversalRequests> getRequests() throws SQLException{
			 PreparedStatement ps = conn.prepareStatement("SELECT reversalrequest.requestid,transactions.Transactionno,transactions.AccNo,transactions.Timestamp,transactions.Type,reversalrequest.reqDate FROM transactions INNER JOIN reversalrequest ON transactions.Transactionno=reversalrequest.Transactionno");
			  List<ReversalRequests> transactionList = new ArrayList<>();
				 ResultSet rs = ps.executeQuery();
			        while (rs.next()) {
			        	transactionList.add( new ReversalRequests(rs.getInt(1),rs.getInt(2),rs.getDate(6),new Transaction(rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getString(5))));
			        }
			        return transactionList;
		}
	

}
