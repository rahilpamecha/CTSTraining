package com.cognizant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllEmployeesServletClass
 */
@WebServlet(
		name = "AllEmployeesServlet", 
		urlPatterns = { "/getAllEmployees" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "oracle.jdbc.OracleDriver"), 
				@WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:ORCL"), 
				@WebInitParam(name = "username", value = "sabbir"), 
				@WebInitParam(name = "password", value = "sabbir")
		})
public class AllEmployeesServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String driver;
	private String url;
	private String username;
	private String password;
	
    public AllEmployeesServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.driver=config.getInitParameter("driver");
		this.url=config.getInitParameter("url");
		this.username=config.getInitParameter("username");
		this.password=config.getInitParameter("password");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
			Connection connection=DriverManager.getConnection(url,username,password);	
				PrintWriter out=response.getWriter();
			){
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from EMPLOYEESCOGNIZANT");
			out.println("<html><head><title>All Employee Details</title></head>");
			out.println("<body><table cellspacing='2' cellpadding='2' border='2'>");
			out.println("<tr><th>Emp Id</th><th>Emp Name</th><th>Emp Salary</th><th>Emp Designation</th></tr>");
			while(resultSet.next()){
				out.println("<tr>");
				out.println("<td>"+resultSet.getInt("EMP_ID")+"</td>");
				out.println("<td>"+resultSet.getString("EMP_NAME")+"</td>");
				out.println("<td>"+resultSet.getDouble("EMP_SALARY")+"</td>");
				out.println("<td>"+resultSet.getString("EMP_DESIGNATION")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
