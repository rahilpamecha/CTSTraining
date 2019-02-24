package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InserEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
				Scanner sc=new Scanner(System.in);
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sabbir","sabbir");
				 ){
					System.out.print("Employee Id:");
					int empId=sc.nextInt();
					
					System.out.print("Employee Name:");
					String empName=sc.next();
					
					System.out.print("Employee Salary:");
					double empSalary=sc.nextDouble();
					
					System.out.print("Employee Designation:");
					String empDesignation=sc.next();
					
					PreparedStatement statement=
			connection.prepareStatement("insert into EMPLOYEESCOGNIZANT values(?,?,?,?)");
					statement.setInt(1, empId);
					statement.setString(2, empName);
					statement.setDouble(3,empSalary);
					statement.setString(4,empDesignation);
					int rows=statement.executeUpdate();
					if(rows>0)
						System.out.println("Record inserted");
					else
						System.out.println("Insert failed");
					
			
					
					
				}catch(SQLException e){
					e.printStackTrace();
				}

	}

}
