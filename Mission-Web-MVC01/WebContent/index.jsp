<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/board/list.do">게시판</a>
	<br>
	<a href="<%= request.getContextPath() %>/board/writeForm.do">글등록</a>
	<br>
	<a href="<%= request.getContextPath() %>/login.do">로그인</a>
	<br>

</body>
</html>