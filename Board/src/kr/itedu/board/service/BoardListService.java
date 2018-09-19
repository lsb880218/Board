package kr.itedu.board.service;

import java.util.ArrayList;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.BoardDAO;

public class BoardListService {
	public ArrayList<BoardVO> getBoardList(int btype){
		ArrayList<BoardVO> result = null;
	
		BoardDAO dao = BoardDAO.getInstance();
		
		result = dao.getBoardList(btype);
		
		return result;
	}
}
