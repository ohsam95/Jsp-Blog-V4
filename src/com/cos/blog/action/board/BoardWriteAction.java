package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.user.Action;
import com.cos.blog.util.Script;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인해야 글을 쓸 수 있기 때문에 세션 체크
		HttpSession session = request.getSession();
		if (session.getAttribute("principal")==null) {
			Script.getMessage("잘못된 접근방법입니다.", response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("board/write.jsp");
			dis.forward(request, response);			
		}

		
	}
}
