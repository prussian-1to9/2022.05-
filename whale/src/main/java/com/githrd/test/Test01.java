package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test/test01.dream")
/*
	WebServlet("요청내용")
	==> 요청내용으로 서버에 요청을 하면
		이 클래스를 응답하세요!
		
		이런 annotation 처럼
		요청내용을 따라서 실행할 클래스를 지정하는 행위를
		"요청매핑"이라고 한다.
 */
public class Test01 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		req.setAttribute("NAME", "renjun");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/test01.jsp");
		rd.forward(req, resp);
	}
}
