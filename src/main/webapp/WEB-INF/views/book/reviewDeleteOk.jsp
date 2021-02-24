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
	
		<c:when test="${ri eq '3'}">
			<script>
				alert('리뷰 작성자만 삭제가 가능합니다.');
				history.back();
			</script>
		</c:when>
		
		<c:when test="${ri eq '0'}">
			<script>
				alert('리뷰삭제를 실패했습니다.');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('리뷰가 삭제되었습니다.');
				location.href = document.referrer;
			</script>
		</c:when>
	</c:choose>
</body>
</html>