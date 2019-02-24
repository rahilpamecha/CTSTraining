<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="eb" class="com.cognizant.model.EmployeeBean" scope="session"/>
    <jsp:setProperty property="*" name="eb"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
boolean result=eb.insertData();
if(result){
%>
<jsp:forward page="success.jsp"/>
<%}else{ %>
<jsp:forward page="error.jsp"/>

<%} %>
</body>
</html>