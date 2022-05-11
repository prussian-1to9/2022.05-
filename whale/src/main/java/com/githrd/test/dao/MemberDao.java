package com.githrd.test.dao;

import java.sql.*;
import com.githrd.test.db.*;
import com.githrd.test.sql.*;
import com.githrd.test.vo.*;
public class MemberDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private EzJDBC db;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new EzJDBC();
		mSQL = new MemberSQL();
	}

	// 로그인 db 작업 함수
	public int getLoginCnt(String id, String pw) {
		// 반환값 변수 초기화
		int cnt = 0;
		
		// db 접근
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		pstmt = db.getPstmt(con, sql);
		
		// 명령 가져오기
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			// 명령 실행
			rs = pstmt.executeQuery();
			
			// 데이터 꺼내, 반환값 변수에 입력
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 자원반환
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 한 맴버의 모든 값 꺼내오는 병령
	public MemberVO getinfo(String id) {
		// 반환값 변수 초기화
		MemberVO mVO = new MemberVO();
		
		// db 접근
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MEMB_INFO);
		
		// 명령 가져오기
		pstmt = db.getPstmt(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mVO.setGen(rs.getString("gen"));
				mVO.setJdate(rs.getDate("joindate"));
				mVO.setSdate();
				mVO.setTel(rs.getString("tel"));
				mVO.setMail(rs.getString("mail"));
				mVO.setId(id);
				mVO.setName(rs.getString("name"));
				mVO.setMno(rs.getInt("mno"));
				mVO.setAvt(rs.getInt("avt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 자원반환
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
}
