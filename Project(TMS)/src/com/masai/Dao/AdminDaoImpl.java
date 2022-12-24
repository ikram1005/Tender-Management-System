package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Exception.AdminException;
import com.masai.Utility.JdbcUtil;
import com.masai.model.Admin;

public class AdminDaoImpl implements AdminDao {


	@Override
	public Admin LoginAdmin(String email, String password) throws AdminException {
		Admin ad=null;
		
		try(Connection conn=JdbcUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("Select * from admin where email=? and password=?");
			
			ps.setString(1,email);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String e=rs.getString("email");
				String p=rs.getString("password");
				
				ad=new Admin(e,p);
			}else {
				throw new AdminException("Invalid email and password");
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return ad;
	}

}
