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

	<%MemberDto memberDto = (MemberDto)request.getAttribute("memberDto"); %>
	

	<h1>회원 정보 조회</h1>
	
	<!-- 자바에 관련된 코드가 일절 없기때문에 홈페이지로 바로 띄울 수 잇음 -->
	<!-- 벗뜨...자바관련코드가 있으면.... -->
	<form action="./update" method="post">
		번호 : <input type ="text" name="no" value="<%=memberDto.getNo()%>"></br>
		이름 : <input type= "text" name="name" value="<%=memberDto.getName()%>"></br>
		이메일 : <input type="text" name="email" value="<%=memberDto.getEmail()%>"></br>
		<input type="submit" value="수정">
		<input type="button" value="">
		<!-- <input type="reset" value="취소"> -->
	</form>
	
		<jsp:include page="/Tail.jsp"/>
</body>
</html>