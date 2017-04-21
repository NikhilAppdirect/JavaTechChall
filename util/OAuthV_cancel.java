package com.nikhilgupta.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.nikhilgupta.bean.Parent;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class OAuthV_cancel {

	public  Parent sign_cancel(String myUrl) {
        // TODO Auto-generated method stub
        OAuthConsumer consumer = new DefaultOAuthConsumer("techapp-152799", "AxRITzjjmPTTrotx");
        URL url = null;
        try {
            url = new URL(myUrl);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        HttpURLConnection requestCon = null;
        try {
            requestCon = (HttpURLConnection) url.openConnection();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        requestCon.setRequestProperty("Accept", "application/json");
        try {
            consumer.sign(requestCon);
            requestCon.connect();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        BufferedReader br1 = null;
        try {
            br1 = new BufferedReader(new InputStreamReader(requestCon.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String str1="";
        String l1 = "";
        try {
            while((str1=br1.readLine())!=null) {
                System.out.println(str1);
                l1= l1+str1;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //return new MapJson_Cancel().mpjon_cancel(l1);
		return null;
    }
}
