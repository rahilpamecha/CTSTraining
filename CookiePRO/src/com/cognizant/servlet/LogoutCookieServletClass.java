package com.cognizant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutCookieServletClass
 */
@WebServlet(name = "LogoutCookieServle", urlPatterns = { "/logoutcookie" })
public class LogoutCookieServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutCookieServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		Cookie cookies[]=request.getCookies();
		for(Cookie cookie:cookies){
			
			if(cookie.getName().equals("LoginCookie")){
               cookie.setMaxAge(0);
               response.addCookie(cookie);
			}
		}
		response.getWriter().println("Logged out successfully..");
		}catch(Exception e){
			response.getWriter().println("<p style='color:red'>Session Expired</p>");
		}
	}

}
