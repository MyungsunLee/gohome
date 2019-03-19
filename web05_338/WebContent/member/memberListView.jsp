<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	
	table, tr, td{
		border : 1px solid black;
		background-color: lightyellow;
	}
</style>

<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/Header.jsp"/>
	<h1>내가 만든 회원목록 전체조회</h1>
	<div>
		<a href="./add">신규회원</a>
	</div>
	</br>
	
	<table>
	<c:forEach var="memberDto" items="${memberList}">
		<tr>
			<td>회원번호</td>
			<td>회원이름</td>
			<td>이메일</td>
			<td>가입일</td>
			<td>회원관리</td>
		</tr>
		<tr>
			<td>${memberDto.no}</td>
			<td><a href='./update?no=${memberDto.no}'>${memberDto.name}</a></td>
			<td>${memberDto.email}</td>
			<td>${memberDto.createDate}</td>
			<td><a href='./delete?no=${memberDto.no}'>[삭제]</a></td>
		</tr>
		</c:forEach>
	</table>
	
	
	
	
	
	
	
	
	<jsp:include page="/Tail.jsp"/>
		
</body>
</html>