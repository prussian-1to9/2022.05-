package com.githrd.test;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.githrd.test.dao.*;
import com.githrd.test.vo.*;

@WebServlet("/test/avtInfo.dream")
public class AvtInfo extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 꺼내기
		String sno = req.getParameter("ano");	// ajax에서 ano로 넘겨주었음.
		int ano = Integer.parseInt(sno);
		
		// db 작업
		AvatarDao aDao = new AvatarDao();
		AvatarVO avo = aDao.getAnoInfo(ano);
		
		// 응답문서 작성
		PrintWriter pw = resp.getWriter();
		pw.println("{");
		pw.println("\"ano\": \"" + avo.getAno() + "\",");
		pw.println("\"savename\": \"" + avo.getSavename() + "\",");
		pw.println("\"dir\": \"" + avo.getDir() + "\",");
		pw.println("\"gen\": \"" + avo.getGen() + "\"");
		pw.println("}");
	}

}
