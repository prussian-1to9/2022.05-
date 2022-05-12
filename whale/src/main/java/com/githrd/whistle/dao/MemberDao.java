package com.githrd.whistle.dao;

import java.sql.*;
import java.util.*;
import com.githrd.whistle.db.*;
import com.githrd.whistle.sql.*;
import com.githrd.whistle.vo.*;
/**
 * 	회원 관련 db 작업을 전담 처리하는 Class
 *	@author 최이지
 *	@since	2022.05.12
 *	@version v.1.0
 *		
 *		작업이력 :
 *			2022.05.12	-	Class 제작
 *							담당자 : 최이지
 */
public class MemberDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private BlpDBCP db;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new BlpDBCP();
		mSQL = new MemberSQL();
	}
	
	// 로그인 유무 처리 함수
	public int getLogin(String id, String pw) {
		// 반환값 변수 초기화
		int cnt = 0;
		
		// db 접근
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		pstmt = db.getPstmt(con, sql);
		
		// 명령 완성
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			// 명령 실행, 데이터 채우기
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			
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

	// 회원가입 함수
	public int addMember(MemberVO mVO) {
		// 반환값 변수
		int cnt = 0;
		
		// db 접근
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.ADD_MEMBER);
		pstmt = db.getPstmt(con, sql);
		
		// 명령 완성 (순서 : name, id, pw, mail, tel, avt, gen)
		try {
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getId());
			pstmt.setString(3, mVO.getPw());
			pstmt.setString(4, mVO.getMail());
			pstmt.setString(5, mVO.getTel());
			pstmt.setInt(6, mVO.getAvt());
			pstmt.setString(7, mVO.getGen());
			
			// 명령 실행
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 자원 반환
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 아바타 리스트 보여주는 함수
	public ArrayList<MemberVO> gettAvtList(){
		// 반환값 변수
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		// db 접근
		con = db.getCon();
		stmt = db.getStmt(con);
		
		// 명령 완성
		String sql = mSQL.getSQL(mSQL.SEL_ALL_AVT);
		
		// 명령 실행
		try {
			rs = stmt.executeQuery(sql);
			
			// 데이터 넣어주기
			while(rs.next()) {
				MemberVO mVO = new MemberVO();
				
				mVO.setAno(rs.getInt("ano"));
				mVO.setSavename(rs.getString("savename"));
				mVO.setGen(rs.getString("gen"));
				
				list.add(mVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			// 자원 반환
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return list;
	}
}
