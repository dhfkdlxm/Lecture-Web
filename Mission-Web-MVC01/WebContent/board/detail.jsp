<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/layout.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board.css" />
<script src="<%= request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#goListBtn').click(function(){
			location.href = "list.jsp"
		})
		
		$('#updateBtn').click(function(){
			location.href = "updateForm.jsp?no=${param.no}"
		})
		
		$('#deleteBtn').click(function(){
			if(confirm('[${param.no}]번 게시글을 삭제할까요?'))
			location.href = "delete.jsp?no=${param.no}"
		})
	})
</script>
</head>
<body>
	<header>
		<jsp:include page="/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>게시판 상세</h2>
		<hr>
		<br>
		<table border="1" width="80%">
		<tr>
			<th width="25%">번호</th>
			<td><c:out value="${ board.no }" /></td>
		</tr>
		<tr>
			<th width="25%">제목</th>
			<td><c:out value="${ board.title }" /></td>
		</tr>
		<tr>
			<th width="25%">작성자</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th width="25%">내용</th>
			<td>${ board.content }</td>
		</tr>
		<tr>
			<th width="25%">조회수</th>
			<td>${ board.viewCnt }</td>
		</tr>
		<tr>
			<th width="25%">등록일</th>
			<td>${ board.regDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<c:forEach items="${ fileList }" var="file">
					<%-- href : eclipse-work밑의 경로(서버경로), web-workspace아님 --%>
					<a href="/Mission-Web/upload/${ file.fileSaveName }">
						<c:out value="${ file.fileOriName }" />
					</a>
					(${ file.fileSize } bytes)
					<br>
				</c:forEach>
			</td>
		</tr>
		</table>
		<button id="updateBtn">수정</button>
		<button id="deleteBtn">삭제</button>
		<button id="goListBtn">목록</button>
	</div>
	</section>
	<footer>
		<%@ include file="/include/bottom.jsp" %>	
	</footer>
</body>