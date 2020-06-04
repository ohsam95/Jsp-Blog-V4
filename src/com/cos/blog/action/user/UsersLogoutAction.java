package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.util.Script;

public class UsersLogoutAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); //세션 무효화
//		session.removeAttribute("principal"); //프린시펄의 세션만 날림
		
		Script.href("로그아웃 하셨습니다.", "index.jsp", response);
	}

}
