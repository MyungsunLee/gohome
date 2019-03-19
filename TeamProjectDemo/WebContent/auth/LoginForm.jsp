<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body{
		background-color: lightyellow;
	}
<title>Insert title here</title>
</head>
</style>
<body>
<jsp:include page="/Header.jsp"/>
</br></br>
<h1>로그인</h1>
	<form action="" method="">
		<table>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="로그인">
		<input onclick='location="/TeamProjectDemo/MainPage.jsp"' type="button" value="메인으로">
	</form>

</body>
</html>