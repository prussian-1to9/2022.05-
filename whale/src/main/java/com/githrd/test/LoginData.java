package com.githrd.test;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/test/logindata.dream")
public class LoginData extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("ID", req.getParameter("id"));
		req.setAttribute("PW", req.getParameter("pw"));
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/logindata.jsp");
		rd.forward(req, resp);
	}
}
