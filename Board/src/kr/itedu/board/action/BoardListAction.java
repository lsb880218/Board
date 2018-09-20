package kr.itedu.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.Utils;
import kr.itedu.board.common.Var;
import kr.itedu.board.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null&&!request.getParameter("pageNo").equals("")&&!request.getParameter("pageNo").equals("null")) {
			pageNo = Utils.getParamInt(request.getParameter("pageNo"));
		} 
		
		ArrayList<BoardVO> data = service.getBoardList(btype, pageNo);
		int paging = service.getCountList(btype);
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("paging", paging);
		request.setAttribute("pageNo", pageNo);
		
		return forward;
	}

}
