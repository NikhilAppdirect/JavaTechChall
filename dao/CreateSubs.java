package com.nikhilgupta.dao;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nikhilgupta.bean.Parent;
//import com.nikhilgupta.domain.Userdetails;
import com.nikhilgupta.util.DBConnectionManager;

public class CreateSubs {
		//public void create(obj(firstName,lastName,email, uuid ,languages, editionCode ,pricingDuration)) throws SQLException{
		public void create (Parent prt)  throws SQLException{
	
	         
			Connection con = null;
			try {
				con = (Connection) DBConnectionManager.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	       try{
	        PreparedStatement ps=null;
	        String query1 = "INSERT INTO marketplace(FName, LName, Email, Uuid, Language , BaseUrl) VALUES (?,?,?,?,?,?)";
	        ps = (PreparedStatement) con.prepareStatement(query1);
	        ps.setString(1, prt.getCreator().getFirstName());
	        ps.setString(2, prt.getCreator().getLastName());
	        ps.setString(3, prt.getCreator().getEmail());
	        ps.setString(4, prt.getCreator().getUuid());
	        ps.setString(5, prt.getCreator().getLanguage());
	        ps.setString(6, prt.getMarketplace().getBaseUrl());
	        System.out.println("111111111111");
	        ps.executeUpdate();
	        System.out.println(ps);
	        System.out.println("2222222222222");
	        System.out.println("Object->"+prt);
		       
	        String query2= "INSERT INTO company(Name,PhoneNo,Country,Website,ExternalId) VALUES (?,?,?,?,?) ";
	        ps = (PreparedStatement) con.prepareStatement(query2);
	        ps.setString(1, prt.getPayload().getCompany().getName());
	        ps.setString(2, prt.getPayload().getCompany().getPhoneNumber());
	        ps.setString(3, prt.getPayload().getCompany().getCountry());
	        ps.setString(4, prt.getPayload().getCompany().getWebsite());
	        ps.setString(5, prt.getPayload().getCompany().getExternalId());
	        System.out.println("***********************Exxe**********");
	        ps.executeUpdate();
	        System.out.println("dcjksbcbsdcbhdsbchsdbchbsdhcb");
	        int c=1;
	        while(c==1) {
	        	break;
	        }
	       
	       }
	       catch(Exception e)
	       {
	    	   e.getMessage();
	    	   e.printStackTrace();
	    	   
	       }
	 }

	}



