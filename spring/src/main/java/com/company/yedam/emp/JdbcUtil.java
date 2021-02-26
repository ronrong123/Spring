package com.company.yedam.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	// DB연결 메서드
	public static Connection connect() {
		Connection conn = null;
		try {
			//Class.forName(dbdriver);
			//conn =  DriverManager.getConnection (dburl, user, passwd);
			
			//dbcp connection
			//context.xml을 이용한 연결
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); 
			//jndi: 자원을 관리하는데 자바에서 디렉토리 찾아가듯 할수있는것, 자원을 찾는것, 자원을 모아두는곳
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return conn;
	}

	public static void disconnect(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
