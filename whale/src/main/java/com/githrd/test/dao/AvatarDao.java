package com.githrd.test.dao;

import java.sql.*;
import com.githrd.test.db.*;
import com.githrd.test.sql.*;
import com.githrd.test.vo.*;
public class AvatarDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private EzJDBC db;
	private MemberSQL mSQL;
	
	public AvatarDao() {
		db = new EzJDBC();
		mSQL = new MemberSQL();
	}

	// 아바타 번호로 아바타정보 조회
	public AvatarVO getAnoInfo(int ano) {
		// 반환값변수
		AvatarVO aVO = new AvatarVO();
		
		// db 접근
		con = db.getCon();
		
		// 명령 가져오기
		String sql = mSQL.getSQL(mSQL.SEL_AVT_INFO);
		pstmt = db.getPstmt(con, sql);
		try {
			pstmt.setInt(1, ano);

			// 명령 실행
			rs = pstmt.executeQuery();
			rs.next();
			
			// VO에 담기
			aVO.setAno(rs.getInt("ano"));
			aVO.setDir(rs.getString("dir"));
			aVO.setGen(rs.getString("gen"));
			aVO.setLen(rs.getLong("len"));
			aVO.setSavename(rs.getString("savename"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 자원반환
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return aVO;
	}
}
