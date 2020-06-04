package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.user.Action;
import com.cos.blog.model.Board;
import com.cos.blog.model.Users;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.Script;

public class BoardWriteProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인증확인
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		Users principal = (Users) session.getAttribute("principal");
		// request에서 타이틀값과 컨탠트 값 널인지 공백인지 확인
				if
				(
				request.getParameter("title").equals("")||
				request.getParameter("title")==null||
				request.getParameter("content").equals("")||
				request.getParameter("content")==null
				) {
					Script.back("글쓰기 실패했습니다.", response);
					return;
		}
	
			// 리퀘스트에 타이틀 , 컨탠트 값 받기
				String title = request.getParameter("title");
				String content = request.getParameter("content");

	
			//타이틀값과 컨탠트 값, principal.getId()값을 보드 오브젝트에 담기
				Board board = Board.builder()
						.userid(principal.getId())
						.title(title)
						.content(content)
						.readCount(0)
						.build();
						
			// 보드리포짓토리 연결해서 save(board) 함수 호출
				BoardRepository boardRepository = BoardRepository.getinstance();
				int result = boardRepository.save(board);
			//result == 1 이면 성공 로직 (index.jsp로 이동)
				if (result == 1) {
					Script.href("글쓰기 성공했습니다.", "index.jsp", response);
				}else {
					Script.back("글쓰기 실패했습니다.", response);
				}
				
			// !=1이면 실패로직 (history.back())
		}

		
	}

