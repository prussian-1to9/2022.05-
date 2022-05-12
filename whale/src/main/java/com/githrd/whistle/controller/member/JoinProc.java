package com.githrd.whistle.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.githrd.whistle.controller.*;
public class JoinProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 일단 view만 만들어 놓고, 나중에 작성하자.
		String view = "whistle/main.blp";
		return view;
	}
}
