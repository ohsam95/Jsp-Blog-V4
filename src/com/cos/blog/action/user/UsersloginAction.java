package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersloginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String myCookie = request.getHeader("Cookie");
		System.out.println("myCookie = " +myCookie);
		Cookie []cookies= request.getCookies();
		if (cookies !=null) {
			for (Cookie cookie : cookies) {
					if(cookie.getName().equals("remember")) {
						request.setAttribute("remember", cookie.getValue());
					}
			}
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("user/login.jsp");
		dis.forward(request, response);
		
	}

}
