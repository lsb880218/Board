package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.Utils;
import kr.itedu.board.common.Var;
import kr.itedu.board.service.BoardRegModService;

public class BoardRegModAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_1);
		
		BoardRegModService service = new BoardRegModService();
		int bid = Utils.getParamInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		
		BoardVO data = service.getBoardRegMod(bid, btype);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardRegMod");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		
		return forward;
	}

}
