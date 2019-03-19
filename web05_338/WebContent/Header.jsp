<%@page import="com.tg.member.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<% MemberDto memberDto = (MemberDto)session.getAttribute("member");
// 	System.out.println("어떤값일까?"+request.getContextPath());//context루트의 경로 나타냄
%>
    
    
    <div style="background-color:#000086; color: #ffffff;
    	height: 20px; padding: 5px;">
    	
    	
    	SPMS(Simple Project Management System)
    	<span style="float:right"> <%=memberDto.getEmail() %>
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
    	
    	