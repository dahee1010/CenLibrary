<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>센도서관</title>
<link rel="stylesheet" href="/cenlibrary/resources/css/hearderfooter.css">
</head>
<body>

	<c:if test="${sessionScope.id eq null}">
		<jsp:forward page="member/memberLogin.jsp" />
	</c:if>

	<header>
		<div id="header1">

			<div id="logo">
				<a href="/cenlibrary/main.do"><img src="/cenlibrary/resources/img/logo.png" alt="메인으로" width="65%"></a>
			</div>

			<div id="top_menu">
				<!-- 첫번째 메뉴 -->

				<c:choose>
					<c:when test="${id eq 'admin' || id eq 'itcen1234'}">
						<a href="/cenlibrary/member/memberList.do">관리자페이지</a>　|　
				</c:when>
				
				<c:otherwise>
						<a>${id}님 안녕하세요.</a>　|　
				</c:otherwise>
				</c:choose>
				
				<a href="/cenlibrary/member/memberView.do">내정보</a>　| 　<a href="/cenlibrary/mybook/mybookList.do">내서재</a>　|　<a href="/cenlibrary/member/memberLogout">로그아웃</a>
			</div>
		</div>

		<nav>
			<!-- 두번째 메뉴 -->
			<ul>
				<li><a href="/cenlibrary/book/bookList">도서검색 </a></li>
				<li><a href="/cenlibrary/wishbook/wishbookForm">희망도서신청 </a></li>
				<li><a href="/cenlibrary/course/courseView.do">문화강좌 </a></li>
				<li><a href="/cenlibrary/board/boardList.do">공지사항 </a></li>
				<li><a href="/cenlibrary/qna/queList.do">Q&A </a></li>
			</ul>
		</nav>

	</header>

</body>
</html>