package com.dahee.cenlibrary.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.service.Service;

public class PwCheckCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw");

		MemberDao dao = MemberDao.getInstance();

		int ri = dao.confirmPw(id, pw);

		request.setAttribute("ri", ri);

	}
}
