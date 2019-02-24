package com.cognizant.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalculateTaxOnSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sabbir","sabbir");
				Scanner scanner=new Scanner(System.in);
				
		){
			System.out.print("Please enter Emp Id:");
			int empId=scanner.nextInt();
			
			CallableStatement statement=connection.prepareCall("{call TAX_PROC(?,?)}");
			statement.registerOutParameter(2, Types.NUMERIC);
			statement.setInt(1, empId);
		    //execute returns true only if Query returns ResultSet
			statement.execute();
			double tax=statement.getDouble(2);
		    System.out.println("Tax is:"+tax);
	
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
