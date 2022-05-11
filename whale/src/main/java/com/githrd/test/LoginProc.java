package com.githrd.test;

import com.githrd.test.dao.*;
import com.githrd.test.vo.MemberVO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/test/loginProc.dream")
public class LoginProc extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 검사 먼저!
		String sid = (String)request.getSession().getAttribute("SID");
		if(sid!=null) {// 이미 로그인 된 상태
			response.sendRedirect("/whale/");
		}
		
		// 통과했다면
		// 파라미터 받기
		String pid = request.getParameter("id");
		String ppw = request.getParameter("pw");
		
		// db 작업
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLoginCnt(pid, ppw);
		MemberVO mvo = mDao.getinfo(pid);
		
		// 결과 받아 처리
		if(cnt==1) {// 이미 있는 회원일 경우
			
			// 데이터 넣어주기
			HttpSession session = request.getSession();
			session.setAttribute("MNO", mvo.getMno());
			session.setAttribute("SNAME", mvo.getName());
			session.setAttribute("SID", pid);
			session.setAttribute("SMAIL", mvo.getMail());
			session.setAttribute("STEL", mvo.getTel());
			session.setAttribute("JDATE", mvo.getSdate());
			session.setAttribute("SGEN", mvo.getGen());
			session.setAttribute("SAVT", mvo.getAvt());
			
			// 메인페이지로 redirect
			response.sendRedirect("/whale/");
		}else {
			// 로그인 페이지로 돌려보냄
			response.sendRedirect("/whale/test/login.dream");
		}
	}

}
