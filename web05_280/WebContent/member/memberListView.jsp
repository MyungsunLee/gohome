<%@page import="java.util.ArrayList" %>
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
	<h1>회원목록</h1>
	<div>
		<a href=".add">신규회원</a>
	</div>
	
	<%
		ArrayList<MemberDto> memberList = 
			(ArrayList<MemberDto>)request.getAttribute("memberList");
	
		for(MemberDto memberDto : memberList){
			
	%>
	<%=memberDto.getNo() %>,
	<a href='./update?no=<%=memberDto.getNo() %>'><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail() %>,
	<%=memberDto.getCreateDate() %>
	<a href='./delete?no=<%=memberDto.getNo() %>'>[삭제]</a>
	
	<% } %>
		
</body>
</html>