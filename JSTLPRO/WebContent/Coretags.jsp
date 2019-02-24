<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="user" value="${param.username}" scope="session"></c:set>
UserName:<c:out value="${sessionScope.user}"/>

<c:if test="${user eq 'sabbir'}">
<p style="color:blue"><c:out value="Hello, ${user}"/></p>
</c:if>
<c:choose>

<c:when test="${fn:length(user) gt 4 && fn:length(user) lt 10}">
<c:out value="Length greater than 4"/>
</c:when>

<c:when test="${fn:length(user) lt 4}">
<c:out value="Length less than 4"/>
</c:when>

<c:otherwise>
<c:out value="Greater than 10"/>
</c:otherwise>

</c:choose>
</body>
</html>