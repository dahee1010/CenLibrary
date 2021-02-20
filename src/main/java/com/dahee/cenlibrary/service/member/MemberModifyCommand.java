package com.dahee.cenlibrary.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.dto.MemberDto;
import com.dahee.cenlibrary.service.Service;

public class MemberModifyCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String eMail = request.getParameter("eMail");

		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();

		dto.setId(id);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setGender(gender);
		dto.seteMail(eMail);

		int ri = dao.MemberModify(dto);

		request.setAttribute("ri", ri);

	}
}
