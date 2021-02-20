<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/cenlibrary/resources/css/detailmenu.css">
<link rel="stylesheet" href="/cenlibrary/resources/css/search.css">
<link rel="stylesheet" href="/cenlibrary/resources/css/booklist.css">
<script language="JavaScript" src="/cenlibrary/resources/js/check.js" charset="euc-kr"></script>
</head>
<body>

	<jsp:include page="../header.jsp" />

	<div class="detailmenu">
		<a>| 도서검색 |</a>
	</div>

	<main>

	<div class="searchform">
		<form action="bookSearch.do" method="get" name="search_frm">
			<select name="how">
				<option value="제목">제목</option>
				<option value="저자">저자</option>
				<option value="출판사">출판사</option>
			</select>
			<input type="text" size="20" name="obj" placeholder="검색어를 입력해주세요.">
			<input type="button" value="검색" onclick="searchConfirm()">
		</form>
	</div>

	<br>

	<c:choose>

		<c:when test="${empty list}">
			<p class="info">
				도서관에서 소장하고 있는 국내외 자료를 통합 검색 할 수 있습니다. <br> 검색은 제목별, 저자별, 출판사별로
				검색 할 수 있습니다.
			</p>
		</c:when>



		<c:otherwise>
		<c:forEach items="${list}" var="dto">
			
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
					저자 : ${dto.writer} | 출판사 : ${dto.publish} | 발행년도 : ${dto.year}</td>
					
					</tr>
					
			</table>
			
		</c:forEach>

			<table class="tab2">
				<tr>
					<td align="center">
					<c:if test="${startPage > pageBlock}">
							<a href="bookList.do?page=1">[맨앞으로]</a>
							<a href="bookList.do?page=${startPage-10}">[이전]</a>
						</c:if>
						
						<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
							<a href="bookList.do?page=${i}">${i}</a>
						</c:forEach>
						
						<c:if test="${endPage < pageCount}">
							<a href="bookList.do?page=${startPage+10}">[다음]</a>
							<a href="bookList.do?page=${pageCount}">[맨뒤로]</a>
						</c:if>
					</td>
				</tr>
			</table>
		</c:otherwise>

	</c:choose> </main>


	<jsp:include page="../footer.jsp" />

</body>
</html>