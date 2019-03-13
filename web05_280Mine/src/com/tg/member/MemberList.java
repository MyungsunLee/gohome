package com.tg.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/member/list")
public class MemberList extends HttpServlet {

	@Override	//보안이슈때문에 보통 이쪽에서 작성 안함(?)
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 특정한 주석. 주석 속에서도 빠르게 찾아갈수잇음!신기방기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);


			sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
			sql += " FROM MEMBERS";
			sql += " ORDER BY MNO ASC";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println("쿼리 수행 성공");

			// 이제 res 안씀 ㅠ,.ㅠ 감격
			
			
			//request에 회원 목록 데이터 보관
			ArrayList<MemberDto> memberList = new ArrayList();
			//드디어 리스트 사용함!
			//자바로만 구성된(?) memberDto클래스의 변수에 데이터 컬럼을 하나씩 담아서
			//배열에 담음
			int mno = 0;
			String mname = "";
			String email = "";
			Date creDate = null;

			while (rs.next()) {
				mno = rs.getInt("MNO");
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");

				MemberDto memberDto = new MemberDto(mno, mname, email, creDate);
				memberList.add(memberDto);
				//생성자를 통해 데이터를 리스트(배열)에 담음
			}

			req.setAttribute("memberList", memberList);

			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/member/memberListView.jsp");
			//???reDirect와의 차이점?? 분명 차이점이 있습니당
			//이부분에서 화면으로 전송한 것입니다
			
			
			dispatcher.include(req, res);
			//req랑 res를 포함시키면 프로그램이 끝나면서 페이지를 memberListView로 전환시켜줌
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
