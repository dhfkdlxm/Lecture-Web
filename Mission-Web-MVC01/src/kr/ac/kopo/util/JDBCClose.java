package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	
	//PreparedStatement 더 많이 쓰지만 Statement 사용할 수도 있기 때문에 Statement 객체로 인자 넣음
	//PreparedStatement는 Statement객체 상속 받기 때문에 사용 가능(묵시적 형변환)
	public static void close(Connection conn, Statement pstmt) {
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}
}
