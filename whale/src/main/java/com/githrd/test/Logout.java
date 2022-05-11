package com.githrd.test;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/test/logout.dream")
public class Logout extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("MNO");
		session.removeAttribute("SNAME");
		session.removeAttribute("SID");
		session.removeAttribute("SMAIL");
		session.removeAttribute("STEL");
		session.removeAttribute("JDATE");
		session.removeAttribute("SGEN");
		session.removeAttribute("SAVT");
		
		// 다시 로그인 뷰로 보내기
		response.sendRedirect("/whale/test/login.dream");
	}
}
