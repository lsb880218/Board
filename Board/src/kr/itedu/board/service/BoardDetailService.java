package kr.itedu.board.service;

import kr.itedu.board.BoardVO;
import kr.itedu.board.common.BoardDAO;

public class BoardDetailService {
	public BoardVO getBoardDetail(int bid, int btype){
		BoardVO result = null;
	
		BoardDAO dao = BoardDAO.getInstance();
		
		result = dao.getBoardDetail(bid, btype);
		
		return result;
	}
}
