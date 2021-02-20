package com.dahee.cenlibrary.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.service.Service;

public class MemberDeleteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");

		MemberDao dao = MemberDao.getInstance();
		int ri = dao.DeleteMember(id);

		request.setAttribute("ri", ri);
		request.setAttribute("id", id);

		System.out.println(ri);
		System.out.println(id);

	}

}
