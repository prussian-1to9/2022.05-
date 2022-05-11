package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/test/avtList.dream")
public class AvtList extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 뷰만 보여주면 됨!
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/test/avtList.jsp");
		rd.forward(request, response);
	}

}
