package com.dahee.cenlibrary.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.service.Service;

public class LoginCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDao dao = MemberDao.getInstance();
		int checkNum = dao.login(id, pw);

		request.setAttribute("checkNum", checkNum);
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
	}
}
