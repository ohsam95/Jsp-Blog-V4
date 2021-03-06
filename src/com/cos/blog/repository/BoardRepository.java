package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cos.blog.db.DBConn;
import com.cos.blog.model.Board;
import com.cos.blog.model.Users;


public class BoardRepository {
	
	private static final String TAG = "BoardRepository : ";
	private static BoardRepository instance = new BoardRepository();
	private BoardRepository() {}
	public static BoardRepository getinstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int write(Board board) {
		final String SQL = "";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		
		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"write : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	
	public int save(Board board) {
		final String SQL = "insert into board(id,userid,title,content,readcount,createdate) values (board_seq.nextval,?,?,?,?,sysdate)";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		pstmt.setInt(1, board.getUserid());
		pstmt.setString(2, board.getTitle());
		pstmt.setString(3, board.getContent());
		pstmt.setInt(4, board.getReadCount());

		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	public int update(Board board) {
		final String SQL = "";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		
		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"update : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	
	public int deleteById(int id) {
		final String SQL = "";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		
		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"delete : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	
	public List<Board> findAll() {
		final String SQL = "select * from board order by id desc";
		List<Board> boards = new ArrayList<>();
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board(
					rs.getInt("id"),
					rs.getInt("userid"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getInt("readCount"),
					rs.getTimestamp("createDate")
					);
				boards.add(board);
		}
		//while 돌려서 rs
		return boards;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt,rs);
		}
		
		return null;
	}
	public Board findById(int id) {
		final String SQL = "";
		Board board = new Board();
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		//if  돌려서 rs
		return board;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return null;
	}
}
