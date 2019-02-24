package com.cognizant.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginAdminServletClass
 */
@WebServlet(name = "LoginAdminServlet", urlPatterns = { "/loginadmin" })
public class LoginAdminServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Connection connection=null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try
    	 
    	{
    		connection=
        			DriverManager.
        			getConnection("jdbc:oracle:thin:@localhost:1521:xe"
        					,"RAHILPAMECHA","Ashishagency9600@");
    	
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	int admin=Integer.parseInt(request.getParameter("admin"));
    	int count=0;
    	try {
			PreparedStatement statement=
					connection.prepareStatement("select * from cust_auth "
							+ "where admin=?");
			statement.setInt(1,admin);
			ResultSet resultSet=statement.executeQuery();
			boolean loginResult=false;
			while(resultSet.next()){
				loginResult=true;
			}
			if(loginResult){
				request.setAttribute("admin",admin);
				HttpSession session=request.getSession(true);
				session.setAttribute("admin",admin );
				RequestDispatcher dispatcher=request.getRequestDispatcher("welcome");
				dispatcher.forward(request,response);
			}else{
				request.setAttribute("admin",admin);
				RequestDispatcher dispatcher=request.getRequestDispatcher("loginerror");
				dispatcher.forward(request,response);
				count++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
