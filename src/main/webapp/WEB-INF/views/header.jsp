<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
<link rel="stylesheet" href="/cenlibrary/resources/css/hearderfooter.css">
</head>
<body>

	<c:if test="${sessionScope.id eq null}">
		<jsp:forward page="member/memberLogin.jsp" />
	</c:if>

	<header>
		<div id="header1">

			<div id="logo">
				<a href="/cenlibrary/main.do"><img src="/cenlibrary/resources/img/logo.png" alt="��������" width="65%"></a>
			</div>

			<div id="top_menu">
				<!-- ù��° �޴� -->

				<c:choose>
					<c:when test="${id eq 'admin' || id eq 'itcen1234'}">
						<a href="/cenlibrary/member/memberList.do">������������</a>��|��
				</c:when>
				
				<c:otherwise>
						<a>${id}�� �ȳ��ϼ���.</a>��|��
				</c:otherwise>
				</c:choose>
				
				<a href="/cenlibrary/member/memberView.do">������</a>��| ��<a href="/cenlibrary/mybook/mybookList.do">������</a>��|��<a href="/cenlibrary/member/memberLogout">�α׾ƿ�</a>
			</div>
		</div>

		<nav>
			<!-- �ι�° �޴� -->
			<ul>
				<li><a href="/cenlibrary/book/bookList">�����˻� </a></li>
				<li><a href="/cenlibrary/wishbook/wishbookForm">���������û </a></li>
				<li><a href="/cenlibrary/course/courseView.do">��ȭ���� </a></li>
				<li><a href="/cenlibrary/board/boardList.do">�������� </a></li>
				<li><a href="/cenlibrary/qna/queList.do">Q&A </a></li>
			</ul>
		</nav>

	</header>

</body>
</html>