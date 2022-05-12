package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/test/login.dream")
public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
/*
		로그인 여부는 session 객체에 속성을 입력하는것으로 처리하는게 일반적이다.
		따라서, 우리가 정한 속성이 session 객체에 기억 되어있으면
		로그인 했다는 것이 되겠쥬.
		
		우리가 사용할 규칙
			session.setAttribute("SID", id);
*/
		// 세션객체 꺼내기
		HttpSession session = req.getSession();
		
		// 세션에 저장된 데이터 있는지 꺼내
		String sid = (String)(session.getAttribute("SID"));

		// 로그인 검사
		if(sid != null) {// 이미 로그인 되어있는 상태
			// 메인페이지로 보낸다.
			resp.sendRedirect("/whistle/test/");
			
			// 로그인 하라고 경고창 띄우기
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인 후 이용해 주세요.');</script>");
			out.flush();
			
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/member/login.jsp");
		rd.forward(req, resp);
	}
}
