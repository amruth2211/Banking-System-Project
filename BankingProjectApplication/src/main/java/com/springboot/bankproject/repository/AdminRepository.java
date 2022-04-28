package com.springboot.bankproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springboot.bankproject.dao.AdminDAO;
import com.springboot.bankproject.model.Admin;
import com.springboot.bankproject.util.DatabaseConnection;

@Repository
public class AdminRepository implements AdminDAO{
	private final Connection conn; 

    public AdminRepository() throws SQLException, ClassNotFoundException {
        this.conn = DatabaseConnection.getConnection();
    }
    
    public Admin viewProfile(Integer adminID)
            throws SQLException{
    	 PreparedStatement ps = conn.prepareStatement("select adminID,name,bankCode from admins where adminId=?");
	        ps.setInt(1,adminID);
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        return new Admin(rs.getInt(1),rs.getString(2),rs.getInt(3));
    }
    
    
}
