<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
</head>
<body>

	<c:choose>

		<c:when test="${empty id}">
			<script>
				alert('���̵� �Է��ϼ���!');
				document.location.href = "memberLogin";
			</script>
		</c:when>

		<c:when test="${empty pw}">
			<script>
				alert('��й�ȣ�� �Է��ϼ���!');
				document.location.href = "memberLogin";
			</script>
		</c:when>

		<c:when test="${checkNum eq '0'}">
			<script>
				alert('��й�ȣ�� �ٸ��ϴ�!');
				document.location.href = "memberLogin";
			</script>
		</c:when>

		<c:when test="${checkNum eq '-1'}">
			<script>
				alert('ȸ���� �ƴմϴ�!');
				document.location.href = "memberLogin";
			</script>
		</c:when>

		<c:otherwise>
			<%
				String id = request.getParameter("id");
						session.setAttribute("id", id);
						session.setAttribute("ValidMem", "yes");
						response.sendRedirect("/cenlibrary/main.do");
			%>
		</c:otherwise>

	</c:choose>

</body>
</html>