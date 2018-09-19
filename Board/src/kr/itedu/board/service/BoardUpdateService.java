package kr.itedu.board.service;

import kr.itedu.board.common.BoardDAO;

public class BoardUpdateService {
	public void getBoardUpdate(int bid, int btype, String btitle, String bcontent){
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.getBoardUpdate(bid, btype, btitle, bcontent);
	}
}
