package com.cognizant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.helper.ConnectionManager;

public class JDBCCustomerDAOImpl implements CustomerDAO {
	
	private ConnectionManager manager=new ConnectionManager();

	@Override
	public boolean authCustomer(int custId, int pin) {
		// TODO Auto-generated method stub
		Connection connection=manager.openConnection();
		boolean result=false;
		try {
			PreparedStatement statement=
					connection.prepareStatement("select * from "
							+ "cust_auth where cust_id=? and pin=?");
			statement.setInt(1,custId);
			statement.setInt(2,pin);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.closeConnection();
		return result;
	}
	
	public void internal(){}

}
