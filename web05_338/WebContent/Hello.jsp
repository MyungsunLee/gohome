<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일단 주소를 쉽게 보는 화면</title>
</head>
<body>
	안녕하세요</br>
	<% 
	String[] names = new String[]{
			"홍길동","임꺽정","일지매","용비"
	};
	pageContext.setAttribute("nameArr",names);
%>
</body>
	<ul>
	<c:forEach var="nameStr" items="${names}" begin="0" end="3">
		<li>${nameStr}</li>
	
	</c:forEach>
	</ul>
</html>