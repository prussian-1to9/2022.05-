package com.githrd.test;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.githrd.test.dao.MemberDao;
import com.githrd.test.vo.*;

@WebServlet("/test/loginAjax.dream")
public class LoginAjax extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션검사
		HttpSession session = req.getSession();
		if(session.getAttribute("SID")!=null) {
			resp.sendRedirect("/whale/test.dream");
			return;
		}
		
		// 파라미터 받기
		String pid = req.getParameter("id");
		String ppw = req.getParameter("pw");
		
		// db 작업 후 결과받기
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLoginCnt(pid, ppw);
		MemberVO mvo = mDao.getinfo(pid);
		
		// 결과에 따른 처리
		PrintWriter pw = resp.getWriter();
		pw.println("{");
		if(cnt==1) {
			
			// 세션에 넣어주고
			session.setAttribute("MNO", mvo.getMno());
			session.setAttribute("SNAME", mvo.getName());
			session.setAttribute("SID", pid);
			session.setAttribute("SMAIL", mvo.getMail());
			session.setAttribute("STEL", mvo.getTel());
			session.setAttribute("JDATE", mvo.getSdate());
			session.setAttribute("SGEN", mvo.getGen());
			session.setAttribute("SAVT", mvo.getAvt());
			
			// OK 처리!
			pw.println("\"result\": \"OK\"");
		}else {
			pw.println("\"result\": \"NO\"");			
		}
		pw.println("}");
	}

}
