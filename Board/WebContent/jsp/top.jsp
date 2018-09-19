<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2><%=request.getAttribute("title") %></h2>
<div class="menubar">
	<a href="./home?page=home"><div class="menu">Home</div></a>
	<div class="dropdown"><a href="./boardList.bo?page=boardList&btype=0"><div class="menu">게시판</div></a>
		<div class="dropdown_con">
			<a href="./boardList.bo?page=boardList&btype=1"><div class="menu">게시판 1</div></a>
			<a href="./boardList.bo?page=boardList&btype=2"><div class="menu">게시판 2</div></a>
			<a href="./boardList.bo?page=boardList&btype=3"><div class="menu">게시판 3</div></a>
		</div>
	</div>
</div>