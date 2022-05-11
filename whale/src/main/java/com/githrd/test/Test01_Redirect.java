package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test/test01_redirect.dream")
public class Test01_Redirect extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
									throws IOException, ServletException {
		req.setAttribute("NAME", "renjun");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/test01_redirect.jsp");
		rd.forward(req, resp);
	}
}
