package com.nikhilgupta.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import org.codehaus.jackson.map.ObjectMapper;

import com.nikhilgupta.bean.Marketplace;
import com.nikhilgupta.bean.Parent;
import com.nikhilgupta.dao.CreateSubs;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
public class OAuthV {
	
	
	
    public void oauth (String eventUrl) throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, SQLException {
    	//OAuthConsumer consumer = new DefaultOAuthConsumer("techapp-152799", "AxRITzjjmPTTrotx");

		try {
			DefaultOAuthConsumer oauth = new DefaultOAuthConsumer("techapp-152799", "AxRITzjjmPTTrotx");
	        
	        URL url = new URL(eventUrl);
	        HttpURLConnection request = (HttpURLConnection)url.openConnection();
	        request.setRequestProperty("Accept", "application/json");
	        oauth.sign(request);

			BufferedReader f= new BufferedReader(new InputStreamReader(request.getInputStream()));

			String l = "";
			String str="";

			while((l = f.readLine())!=null)

			{

			System.out.println(l);
				str=str+l;

			}
			
			 System.out.println(str);
			 
			ObjectMapper om = new ObjectMapper();

		
			Parent p = om.readValue(str,Parent.class);

			System.out.println("************I" + p.getFlag());


			Marketplace mp=p.getMarketplace();

			System.out.println(mp.getBaseUrl());
			CreateSubs daoobjt = new CreateSubs();
			daoobjt.create(p);
			System.out.println("***********!!!!******");
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			

    }
}
