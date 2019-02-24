package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginURLServletClass
 */
@WebServlet(name = "LoginURLServlet", urlPatterns = { "/loginurl" })
public class LoginURLServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginURLServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String userName=request.getParameter("username");
	String password=request.getParameter("password");
	if(userName.equals("sabbir") && password.equals("sabbir123")){
		//HttpSession not supported
		//Cookie not enabled in browser
		response.sendRedirect("http://localhost:8080/URLRewritingPRO/welcomeurl?username="+userName);
	}
	}
	

}
