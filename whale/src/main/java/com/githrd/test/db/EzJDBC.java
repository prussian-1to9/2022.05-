package com.githrd.test.db;
/**
 * 이 클래스는 ez 계정으로 데이터베이스 작업을 할 경우
 * 필요한 드라이버를 로딩, 커넥션 및 statement를 필요로 할 때
 * 반환해주는 기능을 가진 클래스.
 * 
 * @author cage6
 * @since 2022.04.15
 * @version v.1.0
 */
import java.sql.*;
public class EzJDBC {

	public EzJDBC() {
		// 이 클래스가 new 될 때 드라이벌 로딩이 되도록 처리.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("# # # 드라이버 로딩 실패 # # #");
			e.printStackTrace();
		}
	}
	
	// 커넥션 반환 함수
	public Connection getCon() {
		Connection con = null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			con = DriverManager.getConnection(url, "ez", "pz");
		}catch(Exception e) {
			System.out.println("커넥션 생성 실패");
		}
		
		return con;
	}

	// id랑 pw 입력시 커넥션 반환 overloading
	public Connection getCon(String user, String pw) {
		Connection con = null;
		String url = "oracle:jdbc:thin:@localhost:1521:xe";
		
		try {
			con = DriverManager.getConnection(url, user, pw);
		}catch(Exception e) {
			System.out.println("# # # 커넥션 생성 실패 # # #");
		}
		
		return con;
	}
	
	// Statement 반환 함수
	public Statement getStmt(Connection con) {
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
		}catch(Exception e) {
			System.out.println("# # # statement 생성 실패 # # #");
		}
		
		return stmt;
	}
	
	// Prepared Statement 반환 함수
	public PreparedStatement getPstmt(Connection con, String sql) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
		}catch(Exception e) {
			System.out.println("# # # prepared statement 생성 실패 # # #");
		}
		
		return pstmt;
	}
	
	// 자원 반환 함수
	public void close(Object o) {
		try {
			if (o instanceof Connection) ((Connection)o).close();
			else if (o instanceof Statement) ((Statement)o).close();
			else if (o instanceof PreparedStatement) ((PreparedStatement)o).close();
			else if (o instanceof ResultSet) ((ResultSet)o).close();
		}catch(Exception e) {}
	}
}
