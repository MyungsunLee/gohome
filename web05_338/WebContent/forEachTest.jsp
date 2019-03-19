<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java/util/ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEachTestJsp</title>
</head>
<body>
<% 
	String[] subject = new String[]{
			"국어","영어","수학"};
	pageContext.setAttribute("subjectArr",subject);
	
	int[] num = new int[]{
			1,2,3};
	pageContext.setAttribute("numArr",num);
	
	int []score = new int[]{
			70,50,99};
	pageContext.setAttribute("scoreArr",score);
	
	ArrayList<String> subNumScore = new List<String>();
			%>
			
			
</body>
	
	<c:forEach var="subjectStr" items="${subjectArr}" varStatus="i">
		<li>${subjectStr}, ${numArr}</li>
	
	</c:forEach>


</html>