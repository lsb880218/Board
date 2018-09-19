package kr.itedu.board.service;

import kr.itedu.board.common.BoardDAO;

public class BoardDeleteService {
	public void boardDelete (int bid, int btype) {
		BoardDAO dao = null;
		dao = BoardDAO.getInstance();
		
		dao.getBoardDelete(bid, btype);
	}
}
