function infoConfirm() {

	var form = document.reg_frm;
	
	var checkID = /^[a-zA-Z0-9]{4,12}$/;
	var checkBirth = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
	var radioChk = $("input:radio[name='gender']").is(":checked");

	if (form.id.value.length == 0) {
		alert("���̵�� �ʼ������Դϴ�.");
		reg_frm.id.focus();
		return false;
	}

	if (!checkID.test(form.id.value)) {
		alert("���̵�� 4~12���� ���� �ҹ��ڿ� ���ڸ� ��� �����մϴ�.");
		reg_frm.id.focus();
		return false;
	}

	if (form.pw.value.length == 0) {
		alert("��й�ȣ�� �ʼ������Դϴ�.");
		reg_frm.pw.focus();
		return false;
	}

	if (form.pw_check.value.length == 0) {
		alert("��й�ȣ Ȯ���� �ʼ������Դϴ�.");
		reg_frm.pw_check.focus();
		return false;
	}

	if (form.pw.value != form.pw_check.value) {
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		reg_frm.pw.focus();
		return false;
	}

	if (form.name.value.length == 0) {
		alert("�̸��� �ʼ������Դϴ�.");
		reg_frm.name.focus();
		return false;
	}
	
	if (form.birth.value.length == 0) {
		alert("��������� �ʼ������Դϴ�.");
		reg_frm.birth.focus();
		return false;
	}
	
	if (form.birth.value.length != 6) {
		alert("��������� YYMMDD�������� �Է°����մϴ�.");
		reg_frm.birth.focus();
		return false;
	}

	if 	(!checkBirth.test(form.birth.value)) {
		alert("��������� YYMMDD�������� �Է°����մϴ�.");
		reg_frm.birth.focus();
		return false;
	}
	
	if(radioChk == false) {
		alert("������ �ʼ������Դϴ�.");
		return false;
	}
		
	document.reg_frm.submit();
}