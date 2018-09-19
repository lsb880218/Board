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
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=vo.getBtitle()%></title>
<link rel="stylesheet" href="./CSS/basic.css">
<link rel="stylesheet" href="./CSS/board.css">
</head>
<body>
	<div id="link">
	<a href="boardList.bo?btype=<%=btype %>">되돌아가기</a>
	</div>
	<div class="container">
	<table>
		<tr>
			<th class="td1"><%=vo.getBid() %></th>
			<th class="title"><%=vo.getBtitle() %></th>
			<th class="td1"><%=vo.getBregdate()%></th>
		</tr>
		<tr>
			<td colspan="3"><%=vo.getBcontent() %></td>
		</tr>
	</table>
	</div>
	<div class="form">
		<a href="boardRegMod.bo?bid=<%=vo.getBid() %>&btype=<%=btype %>"><input type="button" value="수정"></a>
		<a href="boardDelete.bo?bid=<%=vo.getBid() %>&btype=<%=btype %>"><input type="button" value="삭제"></a>
	</div>
</body>
</html>