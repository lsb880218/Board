package kr.itedu.board.service;

import kr.itedu.board.BoardVO;
import kr.itedu.board.common.BoardDAO;

public class BoardRegModService {
	public BoardVO getBoardRegMod(int bid, int btype){
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO result = dao.getBoardRegMod(bid, btype);
		
		return result;
	}
}
