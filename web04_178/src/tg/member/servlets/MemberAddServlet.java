package tg.member.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAddServlet extends HttpServlet{

	public MemberAddServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("MemberAddServlet의 doGet을 탄다");
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		PrintWriter out = res.getWriter();
		
		String htmlStr = "";
		
		htmlStr += "<html>";
		htmlStr += "<head>";
		htmlStr += "<meta charset='UTF-8'>";
		htmlStr += "<title>회원등록</title>";
		htmlStr += "</head>";
		htmlStr += "<body>";
		htmlStr += "<h1>회원등록</h1>";
		htmlStr += "<form action='add' method='get'>";
		htmlStr += "이름 : <input type='text' name='name'></br>";
		htmlStr += "이메일 : <input type='text' name='email'></br>"; 
		htmlStr += "암호 : <input type='password' name='pwd'></br>";
		htmlStr += "<input type='submit' value='추가'>";
		htmlStr += "<input type='reset' value='취소'>";
		htmlStr += "</form>";
		htmlStr += "</body>";
		htmlStr += "</html>";
		
		out.println(htmlStr);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, res);
	}
	
}
