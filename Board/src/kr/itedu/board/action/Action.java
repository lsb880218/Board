package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;

public interface Action {

	ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
