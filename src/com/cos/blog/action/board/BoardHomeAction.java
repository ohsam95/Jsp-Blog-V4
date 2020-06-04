package com.cos.blog.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.user.Action;
import com.cos.blog.model.Board;
import com.cos.blog.repository.BoardRepository;

public class BoardHomeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BoardRepository boardRepository = BoardRepository.getinstance();
			List<Board> borads = boardRepository.findAll();
			
			for (Board board : borads) {
				String preview = board.getContent();
				preview = preview.substring(0,10)+"...";
				board.setContent(preview);
			}
			request.setAttribute("boards", borads);

			

			
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
	}
}
