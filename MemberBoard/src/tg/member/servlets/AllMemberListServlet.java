package tg.member.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AllMemberListServlet extends GenericServlet {

   @Override
   public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
      // TODO Auto-generated method stub
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "sql";
      String password = "sql";

      String sql = "";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
         stmt = conn.createStatement();
         
         
         sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, PWD, MOD_DATE";
         sql += " FROM MEMBERS";
         sql += " ORDER BY MNO ASC";
         
         
         rs = stmt.executeQuery(sql); //여기서 실행시키는거겟지...?
         
         res.setContentType("text/html"); //타입 변경 띠용 다까먹음 String 다시 보기
         res.setCharacterEncoding("UTF-8");
         
         PrintWriter out = res.getWriter();
         
         out.println("<html><head><title>회원목록</title></head>");
         out.println("<body><h1>회원목록</h1>");
         //지금은 이렇게 했지만
         //앞으로는 뭐 Str같은스트링변수만들어서 프린트ln안에있는거 담+=로 담아서 한번에 출력?하는걸로?
         
         while(rs.next()) {
            out.println(
               rs.getInt("mno") + "," + 
               rs.getString("mname") + "," +
               rs.getString("email") + "," +
               rs.getDate("cre_date") + "," + 
               rs.getString("pwd") +  "," + 
               rs.getDate("mod_date") + "<br/>"
            );
         }//while end
         
         out.println("</body></html>");
      } catch (ClassNotFoundException e) {
         // TODO: handle exception
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO: handle exception
         e.printStackTrace();
      }finally {
         if(rs != null) {
            try {
               rs.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }//if(rs != null) end
         
         if(stmt != null) {
            try {
               stmt.close();
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
      }//finally end

      
      
   }

}