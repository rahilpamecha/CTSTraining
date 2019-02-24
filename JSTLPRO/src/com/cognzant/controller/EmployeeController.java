package com.cognzant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.entity.Employee;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Employee objects will come from DAO
		Employee e1=new Employee();
		e1.setEmpId(1001);
		e1.setEmpName("sabbir");
		e1.setEmpSalary(34000);
		e1.setEmpDesignation("Trainer");
		
		Employee e2=new Employee();
		e2.setEmpId(1002);
		e2.setEmpName("Amit");
		e2.setEmpSalary(94000);
		e2.setEmpDesignation("Trainer");
		
		List<Employee> empList=new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		request.setAttribute("empList",empList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Collection.jsp");
		dispatcher.forward(request,response);
		
	}

}
