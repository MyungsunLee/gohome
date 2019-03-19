<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/Header.jsp"/>
	<!--  -->
	<h1>내가 만든 회원목록 전체조회</h1>
	<div>
		<a href="./add">신규회원</a>
	</div>
	
	<c:forEach var="memberDto" items= "${memberList}">
	
	${memberDto.no},	
	<a href='./update?no=${memberDto.no}'>${memberDto.name}</a>,
	${memberDto.email},
	${memberDto.createDate},
	수정한 날짜 : ${memberDto.modifiedDate},
	<a href='./delete?no=${memberDto.no}'>[삭제]</a>
	</c:forEach>
	
	<jsp:include page="/Tail.jsp"/>
		
</body>
</html>