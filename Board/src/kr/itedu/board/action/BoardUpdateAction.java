package kr.itedu.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.Utils;
import kr.itedu.board.common.Var;
import kr.itedu.board.service.BoardListService;
import kr.itedu.board.service.BoardUpdateService;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_1);
		
		BoardUpdateService service = new BoardUpdateService();
		int bid = Utils.getParamInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		service.getBoardUpdate(bid, btype, btitle, bcontent);
		
		BoardListService list = new BoardListService();
	
		ArrayList<BoardVO> data = list.getBoardList(btype, 1);
		int paging = list.getCountList(btype);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("paging", paging);
		
		return forward;
	}

}
