package com.nikhilgupta.controller;
	import java.io.IOException;
	import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.codehaus.jackson.map.ObjectMapper;
	import com.nikhilgupta.model.TechApp;
    import com.nikhilgupta.util.OAuthV;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;;



	/**
	 * Servlet implementation class CreateSubscription
	 */
	@WebServlet("/CreateSubscription")
	public class CreateSubscription extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 * 
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			System.out.println("Create Subscription");
			System.out.println("Log Created");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			String eventUrl = (String) request.getParameter("eventUrl");
			
			//response.setStatus(200);
			
			TechApp responseObject = new TechApp(true,"new-account-modifier");
			
			OAuthV oth = new OAuthV();
			try {
				oth.oauth(eventUrl);
			} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
					| SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String json = mapper.writeValueAsString(responseObject);
			out.print(json);
			System.out.println(eventUrl);
		
			/*OAuthConsumer consumer = new DefaultOAuthConsumer("techapp-152799", "AxRITzjjmPTTrotx");

			
			catch(Exception e)

			{

			e.printStackTrace();

			}


			BufferedReader f= new BufferedReader(new InputStreamReader(requestres.getInputStream()));

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

			System.out.println(p);


			Marketplace mp=p.getMarketplace();

			System.out.println(mp.getBaseUrl());*/
			
			
		}

	}

