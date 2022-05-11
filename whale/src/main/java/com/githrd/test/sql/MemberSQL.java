package com.githrd.test.sql;

public class MemberSQL {
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_MEMB_INFO = 1002;
	public final int SEL_AVT_INFO = 1003;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
			
		case SEL_MEMB_INFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, mail, tel, joindate, gen, avt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
			
		case SEL_AVT_INFO:
			buff.append("SELECT ");
			buff.append("	ano, savename, dir, gen, len ");
			buff.append("FROM ");
			buff.append("	avatar ");
			buff.append("WHERE ");
			buff.append("	ano = ? ");
			break;
		}
		
		return buff.toString();
	}
}
