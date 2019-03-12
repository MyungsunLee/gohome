<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
    <h1>회원등록</h1>
    <form action='./update' method='post'>
 	 	번호: <input type='text' name='mno'><br>
   	 	이름: <input type='text' name='name'></br> 	 	
 	 	이메일: <input type='text' name='email'><br>
 	 	
   	 	암호: <input type='password' name='password'><br>
    	<input type='submit' value='수정'>
   		<input type='reset' value='취소'>

    </form>
	<a href='sfsef'>ddd</a>
	<!-- 이이와 같은 기능을 하는 것이 --> 33번째줄
	<p>클릭안됨</p>
	<p onclick="movePageFnc()" style="border:1px solid black;">클릭됨</p>
	
<input type='button' value='뒤로가기' "
					+ "onclick='location.href=\"./AddOne\"'>";
<input type = button' value='뒤로가기' onclick='location.herf="/AddOne?email=rs.getString("email")&"'>


</body>

 <script type="text/javascript">
// location.href="./상대주소";

function movePageFnc(){
	location.href="./index.jsp";
	//데이터전송은 의미있는 단위만 전달하기 때문에 getString같은거 보내면 안됨(?)
}

</script>
</html>