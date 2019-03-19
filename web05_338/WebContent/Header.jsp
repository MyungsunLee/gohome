<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    

    
    
    <div style="background-color:#000086; color: #ffffff;
    	height: 20px; padding: 5px;">
    	
    	
    	SPMS(Simple Project Management System)
    	<span style="float:right"> ${sessionScope.member.email}
    		<a href=" <%=request.getContextPath() %>/auth/logout"
    		style="color:white;">로그아웃
    		</a>
    	</span>
    	<table>
    		<tr>
    			<td><a href="/member/list">회원리스트</a></td>
    			<td><a href="/member/add">신규회원</a></td>
    			<td><a href="/auth/login">로그인</a></td>
    		</tr>
    	</table>
    	
    	</div>
    	
    	