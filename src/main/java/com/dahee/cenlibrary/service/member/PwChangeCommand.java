package com.dahee.cenlibrary.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.dto.MemberDto;
import com.dahee.cenlibrary.service.Service;

public class PwChangeCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("changePw");

		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();

		int confirmPw = dao.confirmPw(id, pw);

		if (confirmPw == 0) {
			int ri = 0;

			request.setAttribute("ri", ri);

		} else {
			dto.setId(id);
			dto.setPw(pw1);

			int ri = dao.PwModify(dto);

			request.setAttribute("ri", ri);
		}

	}
}
