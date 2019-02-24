package com.cognizant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeURLServletClass
 */
@WebServlet(name = "WelcomeURLServlet", urlPatterns = { "/welcomeurl" })
public class WelcomeURLServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeURLServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		PrintWriter out=response.getWriter();
		if(username.equals("sabbir")){
		out.println("<b>Welcome,"+username);
		out.println("<br><a href='fundtransferurl?username="+username+"'>Fund Transfer</a>");
		out.println("<br><a href='LogoutUrlServlet?username="+"loggedout'"+">LogOut</a>");
		}else{
			out.println("Session Expired");
		}
	}

}
