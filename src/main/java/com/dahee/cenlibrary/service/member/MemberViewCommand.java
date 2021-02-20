package com.dahee.cenlibrary.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.dto.MemberDto;
import com.dahee.cenlibrary.service.Service;

public class MemberViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");

		MemberDao dao = MemberDao.getInstance();
		MemberDto dtos = dao.memberView(id);

		request.setAttribute("view", dtos);
		
	}
}
