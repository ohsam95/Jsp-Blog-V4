package com.cos.blog.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.repository.UsersRepository;

public class UserUsernameCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		UsersRepository usersRepository = UsersRepository.getinstance();
		int result = usersRepository.findbyUsername(username);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}
}
