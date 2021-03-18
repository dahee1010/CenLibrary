<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>센도서관</title>
</head>
<link rel="stylesheet" href="/cenlibrary/resources/css/detailmenu.css">
<link rel="stylesheet" href="/cenlibrary/resources/css/bookadmin.css">
<script type="text/javascript">
function fileCheck(obj) {
    pathpoint = obj.value.lastIndexOf('.');
    filepoint = obj.value.substring(pathpoint+1,obj.length);
    filetype = filepoint.toLowerCase();
    
    if(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg' || filetype=='bmp') {
    } else {
        alert('이미지 파일만 선택 가능합니다.');
        obj.value = '';
        return false;
    }
}
</script>
<body>

	<jsp:include page="../header.jsp" />

	<div class="detailmenu">
		<a>| 도서추가 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="../sidemenu.jsp" />

		<form action="bookAddOk.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName" required></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td><input type="text" name="writer" required></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="publish" required></td>
				</tr>
				<tr>
					<th>발행년도</th>
					<td><input type="text" name="year" required pattern="^(18|19|20)\d{2}$" title="형식: 숫자로 된 연도 4자리"></td>
				</tr>
				<tr>
					<th>청구기호</th>
					<td><input type="text" name="code" required></td>
				</tr>
				<tr>
					<th>보유재고</th>
					<td><input type="text" name="bCnt" required pattern="^[0-9]*$" title="형식: 숫자"></td>
				</tr>
				<tr>
					<th>도서사진</th>
					<td><input type="file" name="file" id="file" size=40 accept="image/*" onchange="fileCheck(this)"></td>
				</tr>
			</table>

			<input type="submit" value="작성" id="writebtn"> <a href="bookListAdmin.do"><input type="button" value="취소" id="cancelbtn"></a>

		</form>

	</div>
	</main>

	<jsp:include page="../footer.jsp" />

</body>
</html>