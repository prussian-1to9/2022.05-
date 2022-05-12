package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/test/")
public class TestIndex extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션객체 꺼내기
		HttpSession session = req.getSession();
		
		// 세션에 저장된 데이터 있는지 꺼내
		String sid = (String)(session.getAttribute("SID"));

		// 로그인 검사
		if(sid == null) {// 로그인이 안되어있는 상태
			// 로그인 페이지로 보낸다.
			resp.sendRedirect("/whistle/test/login.dream");
			return;
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/index.jsp");
		rd.forward(req, resp);
	}

}
