package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test/test02.dream")
public class Test02 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		req.setAttribute("NAME", "renjun");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/test02.jsp");
		rd.forward(req, resp);
	}
}
