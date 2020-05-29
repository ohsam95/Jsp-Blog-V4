package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cos.blog.db.DBConn;
import com.cos.blog.model.Board;
import com.cos.blog.model.Users;
import com.cos.blog.model.Reply;


public class ReplyRepository {
	
	private static final String TAG = "ReplyRepository : ";
	private static ReplyRepository instance = new ReplyRepository();
	private ReplyRepository() {}
	public static ReplyRepository getinstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int write(Reply reply) {
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
	
	public int save(Reply reply) {
		final String SQL = "";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		
		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"reply : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	public int update(Reply reply) {
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
	
	public List<Reply> findAll() {
		final String SQL = "";
		List<Reply> replys = new ArrayList<>();
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		//while 돌려서 rs
		return replys;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return null;
	}
	public Reply findById(int id) {
		final String SQL = "";
		Reply reply = new Reply();
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		//if  돌려서 rs
		return reply;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return null;
	}
}
