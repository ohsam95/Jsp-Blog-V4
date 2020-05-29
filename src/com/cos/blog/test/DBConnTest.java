package com.cos.blog.test;

import org.junit.jupiter.api.Test;

import com.cos.blog.db.DBConn;

public class DBConnTest {

	@Test 
	public void dbTest() {
		DBConn.getConnection();
	}
}
