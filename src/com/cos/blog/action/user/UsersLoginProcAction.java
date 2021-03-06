package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;
import com.cos.blog.util.Script;

public class UsersLoginProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 유효성 검사
				if
				(
						request.getParameter("username").equals("")||
						request.getParameter("username")==null||
						request.getParameter("password").equals("")||
						request.getParameter("password")==null
						) {
					return;
				}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsersRepository usersRepository = UsersRepository.getinstance();
		Users user = usersRepository.findbyUsernameAndPassword(username, password);
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user); //제이세션아이디로 구분!
			
			if (request.getParameter("remember")!=null) {
				Cookie cookie = new Cookie("remember", user.getUsername());
				response.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("remember", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
			Script.href("로그인 성공", "/blog/board?cmd=home" , response);
		}else {
			Script.back("로그인 실패", response);
		}
	}

}
