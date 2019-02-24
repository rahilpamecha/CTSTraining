package com.cognizant.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ScopePROListener
 *
 */
@WebListener
public class ScopePROListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ScopePROListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("****context destroyed*****");

    try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    private static Connection connection=null;
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("****context intialized*****");
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
        			getConnection("jdbc:oracle:thin:@localhost:1521:ORCL"
        					,"sabbir","sabbir");
    		ServletContext application=arg0.getServletContext();
    		application.setAttribute("con", connection);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	
    	
    }
	
}
