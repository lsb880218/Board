package kr.itedu.board.common;

import static kr.itedu.board.common.DBConnector.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.itedu.board.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;
	
	private BoardDAO () {
		
	} //private 생성자
	
	public static BoardDAO getInstance() { // 싱글톤 패턴
		if(dao == null) {
			dao = new BoardDAO();
		}
		
		return dao;
	}
	
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConn();
			String query = String.format(" select  "
					+ " bid, btitle, "
					+ "   to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "  
					+ " from t_board%d order by bid desc ", btype);
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				BoardVO vo = new BoardVO();
				vo.setBid(bid);
				vo.setBtitle(btitle);
				vo.setBregdate(bregdate);
				result.add(vo);
			}
			
		} catch (SQLException e) {
			//TODO:예외처리
		}  catch (Exception e) {
			//TODO:예외처리
		} finally {
			close(conn, ps, rs);
		}
		
		return result;
	}
	
	public BoardVO getBoardDetail(int bid, int btype) {
		BoardVO result = new BoardVO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConn();
			String query = String.format(" select  "
					+ " bid, btitle, bcontent, "
					+ "   to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "  
					+ " from t_board%d where bid=%d ", btype, bid);
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result.setBid(rs.getInt("bid"));
				result.setBtitle(rs.getString("btitle"));
				result.setBcontent(rs.getString("bcontent"));
				result.setBregdate(rs.getString("bregdate"));
			}
			
		} catch (SQLException e) {
			//TODO:예외처리
		}  catch (Exception e) {
			//TODO:예외처리
		} finally {
			close(conn, ps, rs);
		}
		
		return result;
	}
	
	public void getBoardUpdate(int bid, int btype, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query = null;

		try {
			conn = getConn();
			
			if(bid > 0) {
				query = String.format(" UPDATE T_BOARD%d SET BTITLE='%s' , BCONTENT='%s' where bid=%d  "
				, btype, btitle, bcontent, bid);
			} else {
				query = String.format(" INSERT INTO t_board%d (bid, btitle, bcontent)" + 
						"VALUES" + 
						"((select nvl(max(bid), 0) + 1 from t_board%d), '%s', '%s') ", btype, btype, btitle, bcontent);
			}
			
			ps = conn.prepareStatement(query);
			ps.executeQuery();
			
		} catch (SQLException e) {
			//TODO:예외처리
		}  catch (Exception e) {
			//TODO:예외처리
		} finally {
			close(conn, ps, null);
		}
	}
	
	public BoardVO getBoardRegMod (int bid, int btype) {
		BoardVO result = new BoardVO();
		if(bid >0) {
			BoardDAO dao = new BoardDAO();
			result = dao.getBoardDetail(bid, btype);
		} 
		return result;
	}
	
	public void getBoardDelete (int bid, int btype) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConn();
			String query = String.format(
					"  delete from t_board%d where bid=%d ", btype, bid);
			ps = conn.prepareStatement(query);
			ps.executeQuery();
			
		} catch (SQLException e) {
			//TODO:예외처리
		}  catch (Exception e) {
			//TODO:예외처리
		} finally {
			close(conn, ps, null);
		}
	}
}
			