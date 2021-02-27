<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
<link rel="stylesheet" href="resources/css/hearderfooter.css">
<link rel="stylesheet" href="resources/css/mainsearch.css">
<link rel="stylesheet" href="resources/css/mainbox.css">
<link rel="stylesheet" href="resources/css/tab.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script language="JavaScript" src="resources/js/check.js" charset="euc-kr"></script>
<script>
	$(document).ready(function() {

		$('ul.tabs li').click(function() {
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#" + tab_id).addClass('current');
		})

	})
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<main>
	
	<c:if test="${sessionScope.id eq null}">
		<jsp:forward page="member/memberLogin.jsp" />
	</c:if>

	<section>
		<jsp:include page="mainImage.jsp" />
	</section>


	<div class="parent">
		<div class="searchform">
			<form action="book/bookSearch.do" method="get" name="search_frm">
				<div class="select">
					<select name="how">
						<option value="����">����</option>
						<option value="����">����</option>
						<option value="���ǻ�">���ǻ�</option>
					</select>
				</div>

				<div class="text">
					<input type="text" size="20" name="obj" placeholder="�˻�� �Է����ּ���.">
				</div>

				<div class="search">
					<input type="button" value="�˻�" onclick="searchConfirm()">
				</div>
			</form>
		</div>
	</div>

	<div id="board">
		<div id="left">
			<h2>�����շ�ŷ</h2>
			<table>
				<c:forEach items="${memberrank}" var="dto" varStatus="status">
					<tr>
						<td><c:out value="${status.count}" />��</td>
						<td>${dto.id}</td>
						<td>${dto.cnt}��</td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<div id="right">
			<h2>
				��������<a href="board/boardList.do"><span>��</span></a>
			</h2>
			<table>
				<c:forEach items="${boardlist}" var="dto" varStatus="status" begin="0" end="4" step="1">
					<tr>
						<td align="left" width="600px" id="title"><a href="board/boardView.do?wNum=${dto.wNum}">${dto.title}</a></td>
						<td id="date">${fn:substring(dto.wDate, 0,10)}</td>
					</tr>
				</c:forEach>
			</table>
		</div>


		<div class="container">

			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">��������</li>
				<li class="tab-link" data-tab="tab-2">����Ʈ����</li>
				<li class="tab-link" data-tab="tab-3">��õ����</li>
			</ul>

			<div id="tab-1" class="tab-content current">
				<!-- �������� -->
				<table>
					<tr>
						<c:forEach items="${list}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><c:choose>
									<c:when test="${empty dto.bookimg}">
										<a href="book/bookView.do?bookNum=${dto.bookNum}"><img src="resources/img/booknull.jpg" width="180px" height="270px" /></a>
									</c:when>

									<c:when test="${not empty dto.bookimg}">
										<a href="book/bookView.do?bookNum=${dto.bookNum}"><img src="resources/${dto.bookimg}" width="180px" height="270px" /></a>
									</c:when>
								</c:choose></td>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${list}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><a href="book/bookView.do?bookNum=${dto.bookNum}">${dto.bookName}</a> <br> <span>${dto.writer}</span></td>
						</c:forEach>
					</tr>
				</table>
			</div>

			<div id="tab-2" class="tab-content">
				<!-- ����Ʈ���� -->
				<table>
					<tr>
						<c:forEach items="${bookrank}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><c:choose>
									<c:when test="${empty dto.bImg}">
										<a href="book/bookView.do?bookNum=${dto.bNum}"><img src="resources/img/booknull.jpg" width="180px" height="270px" /></a>
									</c:when>

									<c:when test="${not empty dto.bImg}">
										<a href="book/bookView.do?bookNum=${dto.bNum}"><img src="resources/${dto.bImg}" width="180px" height="270px" /></a>
									</c:when>
								</c:choose></td>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${bookrank}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td>
							 <a style="color: #fb4448">${status.count}��.</a>
							<a href="book/bookView.do?bookNum=${dto.bNum}">${dto.bName}</a> <br> <span>${dto.bWriter}</span>
							</td>
						</c:forEach>
					</tr>
				</table>
			</div>

			<div id="tab-3" class="tab-content">
				<!-- ��õ���� -->
				<table>
					<tr>
						<c:forEach items="${randombook}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><c:choose>
									<c:when test="${empty dto.bookimg}">
										<a href="book/bookView.do?bookNum=${dto.bookNum}"><img src="resources/img/booknull.jpg" width="180px" height="270px" /></a>
									</c:when>

									<c:when test="${not empty dto.bookimg}">
										<a href="book/bookView.do?bookNum=${dto.bookNum}"><img src="resources/${dto.bookimg}" width="180px" height="270px" /></a>
									</c:when>
								</c:choose></td>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${randombook}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><a href="book/bookView.do?bookNum=${dto.bookNum}">${dto.bookName}</a> <br> <span>${dto.writer}</span></td>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</body>
</html>