// �����˻� ��ȿ�� �˻�
function searchConfirm() {

	var form = document.search_frm;

	if (form.obj.value.length == 0) {
		alert("�˻�� �Է����ּ���.");
		search_frm.obj.focus();
		return false;
	}
	document.search_frm.submit();
}