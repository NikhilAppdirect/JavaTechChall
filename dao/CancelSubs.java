package com.nikhilgupta.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nikhilgupta.bean.Parent;
import com.nikhilgupta.util.DBConnectionManager;

public class CancelSubs {
	
	public void cancel(Parent p) throws SQLException{
         
		 Connection con = null;
		try {
			con = (Connection) DBConnectionManager.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	        PreparedStatement ps=null;
	        String query = "delete from marketplace where Uuid = ?";
	        ps = (PreparedStatement) con.prepareStatement(query);
	        ps.setString(1, p.getCreator().getUuid());
	        ps.executeUpdate();
	      }

	}
