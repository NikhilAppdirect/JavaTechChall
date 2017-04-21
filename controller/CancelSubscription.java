package com.nikhilgupta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.nikhilgupta.bean.Parent;
import com.nikhilgupta.model.TechApp;
import com.nikhilgupta.util.OAuthV_cancel;


public class CancelSubscription {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("application/json");
        
        PrintWriter out = response.getWriter();
        
        String eventUrl = (String) request.getParameter("eventUrl");
        
        ObjectMapper mapper = new ObjectMapper();
        
        //response.setStatus(200);
        TechApp responseObject = new TechApp(true,"new-account-identifier");
        
        String json = mapper.writeValueAsString(responseObject);
        
        out.print(json);
        
        System.out.println(eventUrl);
        
        String myUrl = request.getParameter("eventUrl");
        
        Parent parentObject = new OAuthV_cancel().sign_cancel(myUrl);
        
        System.out.println(parentObject.getCreator().getEmail()+"->Servlet");
        

}
}
