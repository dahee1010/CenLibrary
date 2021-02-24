<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
				alert('도서 수정에 실패했습니다.');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('도서정보가 수정되었습니다.');
				document.location.href = "bookListAdmin.do";
			</script>
		</c:when>
	</c:choose>
</body>
</html>