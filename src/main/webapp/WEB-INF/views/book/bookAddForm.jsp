<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
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
        alert('�̹��� ���ϸ� ���� �����մϴ�.');
        obj.value = '';
        return false;
    }
}
</script>
<body>

	<jsp:include page="../header.jsp" />

	<div class="detailmenu">
		<a>| �����߰� |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="../sidemenu.jsp" />

		<form action="bookAddOk.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>������</th>
					<td><input type="text" name="bookName" required></td>
				</tr>
				<tr>
					<th>���ڸ�</th>
					<td><input type="text" name="writer" required></td>
				</tr>
				<tr>
					<th>���ǻ�</th>
					<td><input type="text" name="publish" required></td>
				</tr>
				<tr>
					<th>����⵵</th>
					<td><input type="text" name="year" required pattern="^(18|19|20)\d{2}$" title="����: ���ڷ� �� ���� 4�ڸ�"></td>
				</tr>
				<tr>
					<th>û����ȣ</th>
					<td><input type="text" name="code" required></td>
				</tr>
				<tr>
					<th>�������</th>
					<td><input type="text" name="bCnt" required pattern="^[0-9]*$" title="����: ����"></td>
				</tr>
				<tr>
					<th>��������</th>
					<td><input type="file" name="file" id="file" size=40 accept="image/*" onchange="fileCheck(this)"></td>
				</tr>
			</table>

			<input type="submit" value="�ۼ�" id="writebtn"> <a href="bookListAdmin.do"><input type="button" value="���" id="cancelbtn"></a>

		</form>

	</div>
	</main>

	<jsp:include page="../footer.jsp" />

</body>
</html>