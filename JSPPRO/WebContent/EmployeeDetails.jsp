<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Employee Id</th><th>Employee Name</th><th>Employee Salary</th><th>Employee Designation</th>
</tr>
<%

Class.forName("oracle.jdbc.OracleDriver");
Connection connection=
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","sabbir","sabbir");

Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select * from EMPLOYEESCOGNIZANT");
while(resultSet.next()){
%>
<tr>
<td><%= resultSet.getInt("EMP_ID") %></td>


<td><%= resultSet.getString("EMP_NAME") %></td>


<td><%= resultSet.getDouble("EMP_SALARY") %></td>


<td><%= resultSet.getString("EMP_DESIGNATION") %></td>
</tr>
<%} %>
</table>
</body>
</html>