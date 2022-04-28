package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.model.Address;
import com.springboot.bankproject.dao.BankDAO;
import com.springboot.bankproject.model.Bank;
import com.springboot.bankproject.model.Employee;
import com.springboot.bankproject.util.DatabaseConnection;


@Repository
public class BankRepository implements BankDAO{
	 private final Connection conn; 
	    
	    public BankRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
	    
	    @Override
	    public int create(Bank bank) throws SQLException {
	        PreparedStatement ps = conn.prepareStatement("insert into Bank values(?,?,?)");
	        ps.setInt(1, bank.getBankCode());
	        ps.setString(2, bank.getBankName());
	        ps.setString(3,bank.getMainofficeAddr().toString());

	        return ps.executeUpdate();
	    }
	    
	    @Override
	    public boolean delete(int bankCode)
	            throws SQLException{
	    	PreparedStatement ps=conn.prepareStatement("DELETE FROM Banks WHERE bankCode = ?");
			 ps.setInt(1, bankCode);
		        int rowDeleted = ps.executeUpdate();
		     	return rowDeleted==1;
	    }

	    @Override
	    public Bank update(int bankCode,Address mainOfficAddress)
	            throws SQLException{
	    	PreparedStatement ps=conn.prepareStatement("UPDATE Banks SET mainofficeaddress=? where bankCode=?");
	    	ps.setInt(2, bankCode);
	    	ps.setString(1, mainOfficAddress.toString());
	   		 ResultSet rs = ps.executeQuery();
		     rs.next();
		     return new Bank(rs.getInt(1),rs.getString(2),AddressRepository.processAddress(rs.getString("mainofficeaddress")));
	    }

	    @Override
	    public Bank viewBankDetails(int bankCode)
	            throws SQLException{
	   			PreparedStatement ps=conn.prepareStatement("SELECT * FROM Banks where bankCode=?");
	   		 ResultSet rs = ps.executeQuery();
		     rs.next();
		     return new Bank(rs.getInt(1),rs.getString(2),AddressRepository.processAddress(rs.getString("MainOfficeAddress")));
	    }

	    @Override
	    public List<Bank> getBankNames() throws SQLException {
	        List<Bank> BankList = new ArrayList<>();
	        PreparedStatement ps = conn.prepareStatement("select * from Banks");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	BankList.add( new Bank(rs.getInt(1),rs.getString(2),AddressRepository.processAddress(rs.getString("MainOfficeAddress"))));
	        }
	        return BankList;
	    }
       
	    
}
