package tg.member.servlets;

//기본
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/update")
// 구우우우우웃!어노테이션으로 개꿀
//jsp3.0부터 쓸 수 있습니당

public class MemberUpdate extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException {
	      // TODO Auto-generated method stub

		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 //셋이 순서 꼭 지켜야됨
		 //지울때는 반대로 지워야됨 rs 지우고 pstmt 지우고 conn 지워야됨
		 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password =" jsp";
		 
		int mNo = Integer.parseInt(req.getParameter("mno"));
		String pwd = req.getParameter("pwd");
		String sql = "";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드");
			
			
			conn = DriverManager.getConnection(url, user, password);
			
			
			sql += "SELECT MNO, EMAIL, MNAME, CRE_DATE, PWD";
			sql += " FROM MEMBERS";
			sql += " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);
			
			
			rs = pstmt.executeQuery();
			
			String mName = "";
			String email = "";
			Date creDate = null;
			
			while (rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("email");
				creDate = rs.getDate("cre_date");
				pwd = rs.getString("PWD");
			}
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			
			String htmlStr = "";
			
			htmlStr += "<!DOCTYPE html>";
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<meta charset='UTF-8'>";
			htmlStr += "<title>회원정보</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<h1>개인정보 수정</h1>";
			htmlStr += "<form action='./update' method='post'>";
			htmlStr += "번호: <input type='text' name='mNo' value = '" +mNo + "' disabled='disabled'><br>";
			htmlStr += "이름: <input type='text' name='name' value = '" + mName + "'></br>"; 	
			htmlStr += "이메일: <input type='text' name='email' value='" + email + "'><br>";
			htmlStr += "가입일: " + creDate + "</br>";
			htmlStr += "<input type='submit' value='수정'>";

			htmlStr += "<input type='button' value='뒤로가기' "
					+ "onclick='location.href=\"./AddOne?email=" + email+"&pwd="+pwd + "\"'>";
					//location.href 는 해당 링크 클래스파일의 doGet을 실행시킴
					//이게 로그인상태를 유지하는건가?아닌가?
			htmlStr += "</form>";	//역슬래쉬\는 구분자(",+ 등등)을 string안의 글자로 표시해줌
			htmlStr += "</body>";
			htmlStr += "</html>";
			
			out.println(htmlStr);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end
		
	}
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException {
		 System.out.println("doPost를 탄다");
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      //결과값없어서 resultset없어도됨
	      
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "jsp";
	      String password = "jsp";
	      
	      req.setCharacterEncoding("UTF-8");
	      
	      String email = req.getParameter("email");
	      String name = req.getParameter("name");
	      int mNo = Integer.parseInt(req.getParameter("mNo"));
	      String sql = "";

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, user, password);
	         
	         sql += "UPDATE MEMBERS";
	         sql += " SET EMAIL = ?, MNAME = ?,MOD_DATE = SYSDATE";
	         sql += " WHERE MNO = ?";
             
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1,  email);
	         pstmt.setString(2,  name);
	         pstmt.setInt(3,  mNo);
	         
	         
	         pstmt.executeUpdate();
	         
	         res.sendRedirect("./list");
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         if (pstmt != null) {
	            try {
	               pstmt.close();
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

	
}
