package com.githrd.test;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/main.dream")
public class MainTest extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
			rd.forward(req, resp);
		}catch(Exception e) {}
	}
}
