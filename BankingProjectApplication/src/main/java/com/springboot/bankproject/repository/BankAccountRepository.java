package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.BankAccountDAO;
import com.springboot.bankproject.model.BankAccount;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class BankAccountRepository implements BankAccountDAO{
	 private final Connection conn; 
	    
	    public BankAccountRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
//		public int create(BankAccount bankAccount)
//	            throws SQLException{
//			  PreparedStatement ps = conn.prepareStatement("insert into BankAccounts values(?,?,?,?)");
//		        ps.setInt(1, bankAccount.getAccountNo());
//		        ps.setString(2, bankAccount.getType().name());
//		        ps.setInt(3, bankAccount.getBranchCode());
//		        ps.setInt(4, bankAccount.getCustomerId());
//		     
//		        return ps.executeUpdate();
//		}

		 public int update(Integer accountNo,Integer branchCode)
	            throws SQLException{
	    	 PreparedStatement ps = conn.prepareStatement(
	                 "UPDATE worker SET branchCode = ? WHERE accNo= ?");
	   
	         ps.setInt(1, branchCode);
	         ps.setInt(2, accountNo);;
	         int rowCount = ps.executeUpdate();
	     	
	     	return rowCount;
	    }
//
//		public BankAccount viewDetails(Integer accountNo)
//	            throws SQLException{
//			 PreparedStatement ps = conn.prepareStatement("select * from BankAccounts where accno= ?");
//		     ResultSet rs = ps.executeQuery();
//		     rs.next();
//		     return new BankAccount(rs.getInt(1),rs.getInt(4),rs.getInt(3));
//		}
		
		public int delete(Integer customerId)
	            throws SQLException{
			 PreparedStatement ps = conn.prepareStatement("DELETE FROM BankAccounts WHERE customerId=?");
		        ps.setInt(1,customerId);
		        int rowsUpdated = ps.executeUpdate();
			     return rowsUpdated;
		}
		@Override
		public List<BankAccount> showAllBankAccounts(int branchCode) throws SQLException{
			 PreparedStatement ps = conn.prepareStatement("""
                        select * from bankaccounts where branchCode=?
                      """);
             ps.setInt(1,branchCode);
			  List<BankAccount> bankAccList = new ArrayList<>();
				 ResultSet rs = ps.executeQuery();
			        while (rs.next()) {
			        	bankAccList.add( new BankAccount(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			        }
			        return bankAccList;
		}

}
