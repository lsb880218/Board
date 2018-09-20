<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Test</title>
<link rel="stylesheet" href="./css/basic.css?ver=3">
<link rel="stylesheet" href="./css/board.css?ver=3">
</head>
<body>
	<div class="templast">
		<div><jsp:include page="top.jsp"></jsp:include></div>
		<div><jsp:include page="${content }.jsp"/></div>
		<div><jsp:include page="bottom.jsp"/></div>
	</div>
</body>
</html>