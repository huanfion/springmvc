<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工</title>
</head>
<body>
	<c:form action="emp" method="post" modelAttribute="employee">
	<d:if test="${employee.id==null}">
	LastName:<c:input path="lastName"></c:input><br/>
	</d:if>
	<d:if test="${employee.id!=null}">
	<c:hidden path="id"></c:hidden>
	<input type="hidden" name=_method value="PUT"/>
	</d:if>
	Email:<c:input path="email"></c:input><br/>
	<%
		Map<String,String> genders=new HashMap<String,String>();
		genders.put("1","male");
		genders.put("0","female");
		request.setAttribute("genders",genders);
	%>
	Gender:<c:radiobuttons path="gender" items="${genders }"></c:radiobuttons><br/>
	Department:<c:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></c:select><br/>
	<input type="submit" value="Submit"/>
	</c:form>
</body>
</html>