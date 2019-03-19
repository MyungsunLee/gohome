<%@page import="com.tg.member.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>

	

	<h1>${sessionScope.memberDto.name} 회원 정보 조회</h1>

	<form action="./update" method="post">
		번호 : <input type ="text" name="no" value="${memberDto.no}" readonly="readonly"></br>
		이름 : <input type= "text" name="name" value="${memberDto.name}"></br>
		이메일 : <input type="text" name="email" value="${memberDto.email}"></br>
		가입일 : ${requestScope.memberDto.createDate}</br>
		<input type="submit" value="수정">
		<input type="button" value="">
		<!-- <input type="reset" value="취소"> -->
	</form>
	
		<jsp:include page="/Tail.jsp"/>
</body>
</html>