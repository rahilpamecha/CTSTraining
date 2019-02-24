package com.cognizant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.dao.CustomerDAO;
import com.cognizant.dao.JDBCCustomerDAOImpl;
import com.cognizant.helper.FactoryCustomerDAO;

/**
 * Servlet implementation class LoginCookieClass
 */
@WebServlet(name = "LoginCookie", urlPatterns = { "/logincookie" })
public class LoginCookieClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCookieClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int custId=Integer.parseInt(request.getParameter("custId"));
		int pin=Integer.parseInt(request.getParameter("pin"));
		
		
		CustomerDAO customerDAO=FactoryCustomerDAO.createCustomerDAO();
		boolean result=customerDAO.authCustomer(custId, pin);
		if(result){
			Cookie cookie=new Cookie("LoginCookie",String.valueOf(custId));
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			response.sendRedirect("http://localhost:8080/CookiePRO/welcomecookie");
		}else{
			
			response.getWriter().println("Login failed!!!");
		}
		
		
	}

}
