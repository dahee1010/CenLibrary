<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>센도서관</title>
</head>
<body>
	<c:choose>
		<c:when test="${ri eq '0'}">
			<script>
				alert('글 삭제를 실패했습니다.');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('글 삭제를 성공했습니다.');
				location.href = 'boardList.do'
			</script>
		</c:when>
	</c:choose>
</body>
</html>