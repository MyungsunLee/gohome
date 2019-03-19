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

	<jsp:include page="/Header.jsp"/>
	<!--  -->
	<h1>내가 만든 회원목록 전체조회</h1>
	<div>
		<a href="./add">신규회원</a>
	</div>
	
	<% //이것이 바로 scriptlet
		ArrayList<MemberDto> memberList = 
			(ArrayList<MemberDto>)request.getAttribute("memberList");
			//request를 줄여서 req라고 부르던 것...
		//object형태??타입으로 저장되면2진법으로 전송...뭐시ㅣㄱ..
		//그래서 형변환 해서 쓴것임....(?)
	
		for(MemberDto memberDto : memberList){%>
			<!-- //iterator패턴을 이렇게..?만들었습니다...?
			//memberList에 데이터가 존재해야 함
			//그 데이터들이 여러개가 있는디 그걸 rs.next()처럼 넣고... -->
			<!-- 여기서 추가합니다 -->
	<%=memberDto.getNo() %>,	<!-- 여기서 뽑아쓴 getNo를 바로 밑의 href주소로 보냄. 약간 out.println()하고 같은  쓰임-->
	<a href='./update?no=<%=memberDto.getNo() %>'><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail() %>,<!-- 컴마는 그냥 html쪽에 쓴 구분자??임 ㅎ -->
	<%=memberDto.getCreateDate() %>,
	수정한 날짜 : <%=memberDto.getModifiedDate() %>,
	<a href='./delete?no=<%=memberDto.getNo() %>'>[삭제]</a>
	</br>
	
	<% } %>
	
	<jsp:include page="/Tail.jsp"/>
	
	
		
</body>
</html>