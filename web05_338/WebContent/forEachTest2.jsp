<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.tg.member.SubjectDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
	table, tr, td{
		border-collapse: collapse;
	}
	table, tr, td{
		border : 1px solid black;
	}
</style>
<title>Insert title here</title>
</head>
<body>

	<% 
		SubjectDto[] subjectDtoArr = new SubjectDto[3];
	
	subjectDtoArr[0] = new SubjectDto(1, "수학", 85);
	subjectDtoArr[1] = new SubjectDto(2, "영어", 92);
	subjectDtoArr[2] = new SubjectDto(3, "국어", 95);
		
		request.setAttribute("subjectDtoArr",subjectDtoArr);
		
	%>
	
	<table>
		<tr>
			<td>번호</td>
			<td>과목</td>
			<td>점수</td>
		</tr>
		<tr>
		<c:forEach var="subjectDto" items="${subjectDtoArr}">
				<td>${subjectDto.num}</td>
				<td>${subjectDto.subject}</td>
				<td>${subjectDto.score}점</td>
		</tr>
	</c:forEach>
	</table>
	
	

</body>
	
</html>