<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

    
    
    <div style="background-color:#000086; color: #ffffff;
    	height: 20px; padding: 5px;">
    	
    	
    	SPMS(Simple Project Management System)
    	<span style="float:right">
    	
    	<!-- email값이 없을 때 -->
    	<c:if test="${sessionScope.member == null}">
    	환영합니다 ${sessionScope.member.email}
    		<a href="<%=request.getContextPath() %>/auth/login">로그인</a>
    	</c:if>
		<!-- email값이 있을 때 -->    	
    	<c:if test="${sessionScope.member != null}">	<!-- sessionScope.member.email 을 비교하면 안된다고 합니다 -->
    	${sessionScope.member.email}					<!-- sessionScope.member 즉 객체 자체를 비교해야 한다고 합니다 -->
    		<a href=" <%=request.getContextPath() %>/auth/logout"
    		style="color:white;">로그아웃
    		</a>
    		</c:if>
    	</span>
    	<table>
    		<tr>
    			<td><a href="/member/list">회원리스트</a></td>
    			<td><a href="/member/add">신규회원</a></td>
    			<td><a href="/auth/login">로그인</a></td>
    		</tr>
    	</table>
    	
    	</div>
    	
    	