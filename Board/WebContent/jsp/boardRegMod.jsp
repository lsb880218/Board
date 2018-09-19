<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.itedu.board.*" %>
<% 
	BoardVO vo = (BoardVO)request.getAttribute("data");
	String btype = "1";
	if(request.getParameter("btype")!=null){
		btype = request.getParameter("btype");
	} 
%>

	<div class="form">
	<form action="boardUpdate.bo" method="post">
	<input type="hidden" name="btype" value="<%=btype%>">
	<input type="hidden" name="bid" value="<%=vo.getBid()%>">
	<label for="title">제목:</label>
	<input type="text" name="btitle" id="title" value="<%=vo.getBtitle()%>">
	<br>
	<label for="area">내용</label>
	<br>
	<textarea rows="10" cols="50" name="bcontent" id="area"><%=vo.getBcontent() %></textarea>
	<br>
	<input type="submit" value="확인">
	</form>
	</div>
