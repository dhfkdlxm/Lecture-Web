<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.board.BoardDAO"%>
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

	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href= "writeForm.jsp"
		})
	})
	
	function doAction(no, viewCnt) {
		//jstl의 해석이 먼저이기 때문에 javascript안에도 jstl사용 가능. choose안의 when태그에 의해서 javascrpit코드가 나뉘어서 실행됨
	
		//jstl은 이미 서버에서 먼저 해석이 되어 servlet에 들어가 있음. (둘중 하나의 문장만) -> response되어있는 코드에는 두개중에 하나의 문장만 들어있음
		//그럼 웹브라우저가 location.href 나 confirm 중 들어있는 코드만 해석해서 javascript문법 실행시킴
		<c:choose>
			<c:when test="${ not empty userVO }">	
				location.href = 'detail.jsp?no='+no + '&type=list';	
			</c:when>
			<c:otherwise>
				if(confirm('로그인이 필요한 페이지입니다\n로그인페이지로 이동하시겠습니까?'))
					location.href = "/Mission-Web/jsp/login/login.jsp"
			</c:otherwise>
		</c:choose>
	}
</script>

</head>
<body>
	<header>
	<jsp:include page="/include/topMenu.jsp" /> 
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>게시판 목록</h2>
			<hr>
			<br>
			<table id="list"> 
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="16%">작성자</th>				
					<th width="20%">등록일</th>				
				</tr>
				
				<c:forEach items="${ list }" var="board" varStatus="loop">	
	
					<tr <c:if test="${ loop.index mod 2 ne 0 }"> class="odd" </c:if>>
						<td>${ board.no }</td>
						<td>
							 <a href="<%= request.getContextPath() %>/board/detail.do?no=${board.no}">
							<%-- <a href="#" onclick="doAction()"> --%>
						<%-- 	<a href="javascript:doAction(${ board.no }, ${board.viewCnt })">  --%>  <%-- href로 경로 이동하지 않고, 자바스크립트의 문법 실행 --%>
								<c:out value="${ board.title }" /> 
							</a>
						</td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<c:if test="${ not empty userVO }">
				<button id="addBtn">새글등록</button>
			</c:if>
		</div>
	</section>
	<footer>
	<%@ include file="/include/bottom.jsp" %> 
	</footer>
</body>
</html>

