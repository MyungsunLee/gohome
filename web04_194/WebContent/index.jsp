<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지 index</h1>
	
	<a href='./member/one'>연습 페이지로 이동(AddOne->doGet)</a></br>
	<a href='./member/AddOne'>연습 페이지로 이동(list service)</a></br>
	<a href='./member/list'>메인 페이지로 이동(service)</a>
	
		
		<form action ='./member/AddOne' method='get'>
					검색할 아이디 : <input type='text'
					name='email' placeholder="이메일을 입력해 주세요">
					검색할 이름 : <input type='text'
					name='name' placeholder="이름을 입력해 주세요">
					<input type="submit" value="검색"></form>
		<!-- 폼태그2개로 나눠서 검색했더니 안됨 하나로 통합 후 검색해야했음 -->
		<!-- 어쩌면 논문검색했을때 이 방법 비스무리하게 사용하지 않았을까 -->
</body>
</html>