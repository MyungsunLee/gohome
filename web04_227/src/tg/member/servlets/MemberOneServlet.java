package tg.member.servlets;

//기본
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(value="/member/one")
public class MemberOneServlet extends GenericServlet{
//깃허브테스트 다시올리기...ㅎㅎ
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
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
			
			
						
			sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
			sql += " FROM MEMBERS";
			sql += " WHERE EMAIL = 's1@test.com'";
			sql += " ORDER BY MNO ASC";
			
			pstmt = conn.prepareStatement(sql);

			
			rs = pstmt.executeQuery(sql);
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter();
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			
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
			
			while(rs.next()) {
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
		
	}
	
}
