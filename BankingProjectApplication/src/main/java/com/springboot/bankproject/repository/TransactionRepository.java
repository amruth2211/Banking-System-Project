package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.springboot.bankproject.model.Transaction;
import com.springboot.bankproject.dao.TransactionDAO;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class TransactionRepository implements TransactionDAO
{
	 
		private final Connection conn; 
	    
	    public TransactionRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
	    

	    
	    @Override
		public List<Transaction> showAllTransactions(int branchCode) throws SQLException{
			 PreparedStatement ps = conn.prepareStatement("select transactions.* from transactions inner join bankaccounts on transactions.accno=bankaccounts.accno where bankaccounts.branchcode=?");
             ps.setInt(1,branchCode);
			  List<Transaction> transactionList = new ArrayList<>();
				 ResultSet rs = ps.executeQuery();
			        while (rs.next()) {
			        	transactionList.add( new Transaction(rs.getInt(2),rs.getDouble(3),rs.getDate(5),rs.getInt(1),rs.getString(4)));
			        }
			        return transactionList;
		}
	    
	    @Override
		public List<Transaction> showTransactionsByAccountNo(int accNo) throws SQLException{
			 PreparedStatement ps = conn.prepareStatement("select * from transactions where accno=?");
             ps.setInt(1,accNo);
			  List<Transaction> transactionList = new ArrayList<>();
				 ResultSet rs = ps.executeQuery();
			        while (rs.next()) {
			        	transactionList.add( new Transaction(rs.getInt(2),rs.getDouble(3),rs.getDate(5),rs.getInt(1),rs.getString(4)));
			        }
			        return transactionList;
		}

}
