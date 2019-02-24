package com.cognizant.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBean {
	
	public EmployeeBean(){}
	
	private int empId;
	private String empName;
	private double empSalary;
	private String empDesignation;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	

	public boolean insertData(){
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result=false;
		try {
			Connection connection=
					DriverManager.getConnection("jdbc:oracle:thin:"
							+ "@localhost:1521:ORCL","sabbir","sabbir");
			
			PreparedStatement statement=
					connection.prepareStatement("insert into "
							+ "EMPLOYEESCOGNIZANT values(?,?,?,?)");
			statement.setInt(1,empId);
			statement.setString(2,empName);
			statement.setDouble(3,empSalary);
			statement.setString(4,empDesignation);
			int rows=statement.executeUpdate();
			if(rows>0)
				result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
