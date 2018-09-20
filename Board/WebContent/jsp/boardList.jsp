<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.itedu.board.*" %>
<% 
	ArrayList<BoardVO> result = (ArrayList<BoardVO>)request.getAttribute("data");
	int paging = (int)request.getAttribute("paging");
	
	String btype = "1";
	if(request.getParameter("btype")!=null){
		btype = request.getParameter("btype");
	} 
	
	String pageNo="1";
	if(request.getParameter("pageNo")!=null){
		pageNo = request.getParameter("pageNo");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>

</head>
<body>
	
	<div class="container">
	<table>
		<tr>
			<th class="no">번호</th><th class='title'>제목</th>
			<th class="td1">등록일시</th>
		</tr>
	<% 
	if(!result.isEmpty()){
		for(BoardVO vo:result){
			out.print("<tr>");
			out.print("<td>");			
				out.print(vo.getBid());
			out.print("</td>");
			out.print("<td>");
				out.print("<a href='boardDetail.bo?bid=" + vo.getBid() +"&btype="+ btype +"'>");
				out.print(vo.getBtitle());
				out.print("</a>");
			out.print("</td>");
			out.print("<td>");
				out.print(vo.getBregdate());
			out.print("</td>");
			out.print("</tr>");
		}
	} else {
			out.print("<td colspan='4'>");
			out.print("자료없음");	
			out.print("</td>");
	}
	%>
	</table>
	</div>
	<div class="pageNo">
	<%
		for(int i = 1; i <= paging; i++){
			out.print("<a href='boardList.bo?btype="+btype+"&pageNo="+i+"'>");
			out.print(" "+i+" ");
			out.print("</a>");
		}
	%>
	</div>
	<div class="form"><a href="boardRegMod.bo?bid=0&btype=<%=btype%>"><button>글쓰기</button></a></div>
	
</body>
</html>