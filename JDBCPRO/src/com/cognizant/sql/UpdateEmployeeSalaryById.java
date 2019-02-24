package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployeeSalaryById {

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
				
					
					System.out.print("New Employee Salary:");
					double empSalary=sc.nextDouble();
					
					
					PreparedStatement statement=
			connection.prepareStatement("update EMPLOYEESCOGNIZANT set EMP_SALARY=? where EMP_ID=?");
                   statement.setDouble(1, empSalary);
                   statement.setInt(2, empId);
					int rows=statement.executeUpdate();
					if(rows>0)
						System.out.println("Record updated");
					else
						System.out.println("update failed");
					
			
					
					
				}catch(SQLException e){
					e.printStackTrace();
				}

	}

}
