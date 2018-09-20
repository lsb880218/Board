package kr.itedu.board.service;

import java.util.ArrayList;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.BoardDAO;

public class BoardListService {
	public ArrayList<BoardVO> getBoardList(int btype, int pageNo){
		ArrayList<BoardVO> result = null;
	
		BoardDAO dao = BoardDAO.getInstance();
		
		result = dao.getBoardList(btype, pageNo);
		
		return result;
	}
	
	public int getCountList(int btype) {
		int pageCount = 10;
		
		BoardDAO dao = BoardDAO.getInstance();
		int i = (int)Math.ceil(dao.getCountList(btype)/pageCount);
		
		return i+1;
	}
}
