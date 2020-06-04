package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cos.blog.db.DBConn;
import com.cos.blog.model.Users;
import com.sun.jmx.snmp.Timestamp;


public class UsersRepository {
	
	private static final String TAG = "UsersRepository : ";
	private static UsersRepository instance = new UsersRepository();
	private UsersRepository() {}
	public static UsersRepository getinstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Users findbyUsernameAndPassword(String username, String password) {
		final String SQL = "select id, username, email, address, userProfile, userRole, createDate from users where username = ? and password = ?";
		Users user = null;
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		//물음표 완성하기
		
		rs=pstmt.executeQuery();
		if (rs.next()) {
			user = new Users();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setUserProfile(rs.getString("userProfile"));
			user.setUserRole(rs.getString("userRole"));
			user.setCreateDate(rs.getTimestamp("createDate"));
		}
		//if  돌려서 rs
		return user;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findbyUsernameAndPassword : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return null;
	}
	
	public int join(Users user) {
		final String SQL = "";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		
		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"join : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	public int save(Users user) {
		final String SQL = "insert into users(id,username,password,email,address,userRole,createDate) values (users_seq.nextval,?,?,?,?,?,sysdate)";
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getAddress());
		pstmt.setString(5, user.getUserRole());
		return pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	
	public int update(Users user) {
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
	
	public int delete(int id) {
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
	
	public List<Users> findAll() {
		final String SQL = "";
		List<Users> users = new ArrayList<>();
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		//while 돌려서 rs
		return users;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return null;
	}
	public Users findById(int id) {
		final String SQL = "";
		Users user = new Users();
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		//물음표 완성하기
		//if  돌려서 rs
		return user;
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findById : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return null;
	}
	public int findbyUsername(String username) {
		final String SQL = "select count(*) from users where username = ?";
		Users user = null;
		try {
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, username);
		//물음표 완성하기
		
		rs=pstmt.executeQuery();
		if (rs.next()) {
				return rs.getInt(1);
		}
		//if  돌려서 rs

		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findbyUsername : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return -1;
	}
	
}
