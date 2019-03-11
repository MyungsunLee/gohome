package tg.member.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAddOneServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   
	   
	   Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	   
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password =" jsp";
		
		String emailStr = req.getParameter("email");
		String pwdStr = req.getParameter("password");
		String nameStr = req.getParameter("name");
		
		String sql = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			//preparedStatement 하면 굳이 형변환 안해도 됨
						
			sql = "SELECT MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE";
			sql += " FROM MEMBERS";
			sql += " WHERE EMAIL = ?";//헐
			//위 쿼리문에는 절대 싱글따옴표가 들어가면 안됨. 다 털림 ㄷㄷㄷ
			//별표(*)는 절대!!하면 안됨
			//수정할때 엄청 귀찮기 때문 ㅠ
			//유지보수에 용이 ㅎ
			
			pstmt = conn.prepareStatement(sql);
			//pstmt쓰면 띄어쓰기로 구분 안해도 됨!
			
			pstmt.setString(1, "s1@test.com");
			

			
			rs = pstmt.executeQuery();
			
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter out = resp.getWriter();
			
			out.println("<html><head><title>회원 1명 목록</title></head>");
			out.println("<body><h1>회원 1명 목록</h1>");
			
			// 새로 추가
			String htmlStr = "";
			
			htmlStr += "<div>";
			htmlStr += "<a href='./add'>신규 회원</a>";
			htmlStr += "</div>";
			htmlStr += "<br/>";
			
			htmlStr += "<div>";
			htmlStr += "<a href='./list'>메인 화면으로(모든 회원 출력)</a>";
			htmlStr += "</div>";
			htmlStr += "<br/>";
			
			
			out.println(htmlStr);
			
			while(rs.next()) {	//하나뽑아오기?
				out.println(
					rs.getInt("mno") + "," + 
					rs.getString("mname") + "," +
					rs.getString("email") + "," +
					rs.getDate("cre_date") + "<br/>"
				);
			} // while end
			
			out.println("</body></html>");
			
			
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
//      System.out.println("MemberAddServlet의 doGet을 한다");
//
//      res.setContentType("text/html");
//      res.setCharacterEncoding("UTF-8");
//
//      PrintWriter out = res.getWriter();
//      
//      String htmlStr = "";
//
//      htmlStr += "<!DOCTYPE html>";
//      htmlStr += "<html>";
//      htmlStr += "<head>";
//      htmlStr += "<meta charset='UTF-8'>";
//
//      htmlStr += "<title>홍길동의 회원정보</title>";
//      htmlStr += "</head>";
//      htmlStr += "<body>";
//
//      out.println(htmlStr);
	   
	   //index를 통하는 순간 doGet으로 가게 되어있음
	   
	   
	   
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   
	   System.out.println("MemberAddServlet의 doPost를 탄다");
//	   super(req, res);
//	   Connection conn = null;
//      PreparedStatement pstmt = null;
//
//      String url = "jdbc:oracle:thin:@localhost:1521:xe";
//      String user = "jsp";
//      String password = "jsp";
//
//      String emailStr = req.getParameter("email");
//      String pwdStr = req.getParameter("password");
//      String nameStr = req.getParameter("name");
//
//      String sql = "";
//
//      try {
//         Class.forName("oracle.jdbc.driver.OracleDriver");
//         conn = DriverManager.getConnection(url, user, password);
//
//         sql = "SELECT * FROM MEMBERS";
//         sql += "WHERE EMAIL = 's1@test.com'";
//
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1,  emailStr);
//         pstmt.setString(2,  pwdStr);
//         pstmt.setString(3,  nameStr);
//         
//         
//         res = (HttpServletResponse) pstmt.executeQuery();
//         
//
//         res.setContentType("text/html");
//         res.setCharacterEncoding("UTF-8");
//
//         PrintWriter out = res.getWriter();
//
//         out.println("<html><head><title>회원목록</title></head>");
//         out.println("<body><h1>회원목록</h1>");
//
//         // 새로 추가
//
//
//         
//      } catch (ClassNotFoundException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      } catch (SQLException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      } finally {
//         if (pstmt != null) {
//            try {
//               pstmt.close();
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         } // if(rs != null) end
//
//         if (pstmt != null) {
//            try {
//               pstmt.close();
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//
//         if (conn != null) {
//            try {
//               conn.close();
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      } // finally end

   }

}