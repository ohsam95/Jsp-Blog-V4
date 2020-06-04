package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.board.BoardHomeAction;
import com.cos.blog.action.board.BoardWriteAction;
import com.cos.blog.action.board.BoardWriteProcAction;
import com.cos.blog.action.user.Action;

// http://localhost:8000/blog/user
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private final static String TAG = " BoardController : ";
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8000/blog/user?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"doProcess : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	
	}
	public Action router(String cmd) {
		if(cmd.equals("home")) {
			return new BoardHomeAction();
		}else if (cmd.equals("write")) {
			return new BoardWriteAction();
		}else if (cmd.equals("writeProc")) {
			return new BoardWriteProcAction();
		}
		return null;
	}
}
