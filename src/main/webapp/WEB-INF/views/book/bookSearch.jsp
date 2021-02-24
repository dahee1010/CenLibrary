<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
<link rel="stylesheet" href="/cenlibrary/resources/css/booklist.css">
<link rel="stylesheet" href="/cenlibrary/resources/css/search.css">
<link rel="stylesheet" href="/cenlibrary/resources/css/detailmenu.css">
<script language="JavaScript" src="/cenlibrary/resources/js/check.js" charset="euc-kr"></script>
</head>
<body>

	<jsp:include page="../header.jsp" />

	<div class="detailmenu">
		<a>| �����˻� |</a>
	</div>

	<main>
	<div class="searchform">
		<form action="bookSearch.do" method="get" name="search_frm">
			<select name="how">
				<option value="����">����</option>
				<option value="����">����</option>
				<option value="���ǻ�">���ǻ�</option>
			</select> <input type="text" size="20" name="obj" placeholder="�˻�� �Է����ּ���."> <input type="button" value="�˻�" onclick="searchConfirm()">
		</form>
	</div>

	<br>

	<c:choose>

		<c:when test="${empty search}">
			<img src="/cenlibrary/resources/img/null.png" alt="null.img" width="20%" />
		</c:when>



		<c:otherwise>
			<c:forEach items="${search}" var="dto">


				<table class="tab1">

					<tr onclick="location.href='bookView.do?bookNum=${dto.bookNum}'">

						<td width="200px">
						<c:choose>
								<c:when test="${empty dto.bookimg}">
									<img src="/cenlibrary/resources/img/booknull.jpg" id="bookimg">
								</c:when>

								<c:when test="${not empty dto.bookimg}">
									<img src="/cenlibrary/resources/${dto.bookimg}" id="bookimg">
								</c:when>
							</c:choose>
							</td>

						<td>${dto.bookName}<br>
						���� : ${dto.writer} | ���ǻ� : ${dto.publish} | ����⵵ : ${dto.year}</td>

					</tr>

				</table>
				
			</c:forEach>

			<table class="tab2">
				<tr>
					<td align="center"><c:if test="${startPage > pageBlock}">
							<a href="bookSearch.do?page=1&index=${index}&req=${req}">[�Ǿ�����]</a>
							<a href="bookSearch.do?page=${startPage-5}&index=${index}&req=${req}">[����]</a>
						</c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
							<a href="bookSearch.do?page=${i}&index=${index}&req=${req}">${i}</a>
						</c:forEach> <c:if test="${endPage < pageCount}">
							<a href="bookSearch.do?page=${startPage+5}&index=${index}&req=${req}">[����]</a>
							<a href="bookSearch.do?page=${pageCount}&index=${index}&req=${req}">[�ǵڷ�]</a>
						</c:if></td>
				</tr>
			</table>

		</c:otherwise>

	</c:choose> </main>

	<jsp:include page="../footer.jsp" />

</body>
</html>