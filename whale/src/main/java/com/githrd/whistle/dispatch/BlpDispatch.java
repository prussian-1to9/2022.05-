package com.githrd.whistle.dispatch;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import com.githrd.whistle.controller.*;
/**
 * 	.blp 확장자로 요청이 된 경우,
 * 	요청 내용을 분석해 특정 클래스를 실행(dispatch)시켜주는
 * 	Servlet 클래스다.
 * 
 * 	@author 최이지
 *	@since 2022/05/11
 *	@version v.1.0
 *	@see
 *		com.githrd.whistle.controller.BlpInter
 *		com.githrd.whistle.resources.blp.properties
 *
 *		작업이력 :
 *			2022.05.11	-	클래스 제작
 *							담당자 : 최이지
 */

// 이 Servlet이 언제 실행될지 url-pattern을 지정하는 부분
@WebServlet("*.blp")
public class BlpDispatch extends HttpServlet {
	private HashMap<String, BlpInter> map;	// 실제 요청 내용과 실행할 객체를 입력

	public void init(ServletConfig config) throws ServletException {
	/*
		최초로 이 servlet이 실행될 때 (.blp로 처음 요청이 올 때)
		준비된 properties 파일을 읽어, Map을 만들어 놓는다.
		(요청마다 사용할 클래스를 미리 작성해 놓는다!)
		
		파일에서 직접 읽어서 Map을 작성해야 하니,
		Properties 클래스 객체를 이용한다.
	 */
		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			// 파일 - > Stream
			String path = this.getClass().getResource("").getPath();	// 현재 실행중인 경로 얻기
			path = path + "../resources/blp.properties";	// resources 폴더는 한 단계 위이기 때문에 경로 편집
// 확인	System.out.println("### dispatch path : " + path);
			fin = new FileInputStream(path);
			
			// Properties에 채워주기
			prop.load(fin);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			}catch(Exception e) {}
		}
		
// 확인	System.out.println("### dispatch prop : " + prop.get("/main.blp"));
		
		// properties에 기억된 Class 경로를 이용해 Map 완성
		map = new HashMap<String, BlpInter>();
		Enumeration en = prop.keys();	// 키값 뽑아오기
		// 키값에 해당하는 클래스 객체 생성, map에 입력
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			
			// 실행할 클래스 경로 꺼내기
			String classPath = prop.getProperty(key);
			
			// map을 이용해 객체 만들기
			try {
				Class tmp = Class.forName(classPath);
				Object o = tmp.newInstance();	// 일단 씁시다
				map.put(key, (BlpInter)o);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	// .blp로 요청이 올 때마다 실행되는 함수
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	/*
		요청내용 분석, 실행할 객체(클래스)를 꺼내 처리하는 함수.
		
		이 함수의 처리방식은 forward, ajax, redirect 동시에 처리해야 하므로
		각각의 작업을 구분해줄 수 있는 변수를 만들어 처리한다.
		
		이 때 변수는 실제 실행되는
		함수 내에서도 (어떤 작업이 처리되어야 하는지) 알 수 있어야 하므로
		요청 객체에 기억시킨다.
	 */
		Boolean bool = false;	// forward를 많이쓰므로 기본값 false
		req.setAttribute("isRedirect", bool);
		// Redirect false 면 forward, true면 redirect, null이면 ajax로 처리
		
		// 1. 전체 요청 알아내기
		String full = req.getRequestURI();
		
		// 2. 도메인 찾아내기
		String domain = req.getContextPath();
// 확인	System.out.println("### service full : " + full);
// 확인	System.out.println("### service domain : " + domain);
		
		// 3. 실제 요청 알아내기
		String real = full.substring(domain.length());
		
		// 4. 원하는 컨트롤러 선택, init()에서 map에 등록된 데이터를 이용해 꺼낸다.
		BlpInter blp = map.get(real);
		
		// 5. 실행
		String view = blp.exec(req, resp);
		bool = (Boolean)req.getAttribute("isRedirect");	// 얕은 복사
		
		if(bool==null) {// 비동기통신
			PrintWriter pw = resp.getWriter();
			pw.print(view);
			
		}else if(bool) {// true : redirect
			resp.sendRedirect(view);
			
		}else {// false : forward
			String prefix = "/WEB-INF/views/whistle";
			String surrifx = ".jsp";
			
			RequestDispatcher rd = req.getRequestDispatcher(prefix + view + surrifx);
			rd.forward(req, resp);
		}
	}
}
