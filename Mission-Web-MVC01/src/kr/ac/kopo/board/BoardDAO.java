package kr.ac.kopo.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAO {
		public List<BoardVO> selectAll(){
			List<BoardVO> list = new ArrayList<>();
			// 데이터베이스 t_board 테이블에서 해당 게시물 조회
			StringBuilder sql = new StringBuilder();
			sql.append(" select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("  from t_board ");
			sql.append("  order by no desc ");
			try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no 			= rs.getInt("no");
					String title 	= rs.getString("title");
					String writer 	= rs.getString("writer");
					String regDate 	= rs. getString("reg_date");
					
					BoardVO board = new BoardVO();
					board.setNo(no);
					board.setTitle(title);
					board.setWriter(writer);
					board.setRegDate(regDate);
					
					list.add(board);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
			
		}
		public BoardVO selectByNo(int boardNo) {
			
			BoardVO board = null;
			
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, content, view_cnt ");
			sql.append("      , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append(" from t_board ");
			sql.append(" where no = ? ");
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setInt(1, boardNo);
				ResultSet rs = pstmt.executeQuery();
				/*
				rs.next();		//rs가 추출한 하나의 행을 가리킴
				int no 			= rs.getInt("no");
				String title	= rs.getString("title");
				String writer 	= rs.getString("writer");
				String content 	= rs.getString("content");
				int viewCnt		= rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				board = new BoardVO(no, title, writer, content, viewCnt, regDate);
				*/
				if(rs.next()) {
					board = new BoardVO();
					board.setNo(rs.getInt("no"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					board.setViewCnt(rs.getInt("view_cnt"));
					board.setRegDate(rs.getString("reg_date"));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return board;
		}
	
}
