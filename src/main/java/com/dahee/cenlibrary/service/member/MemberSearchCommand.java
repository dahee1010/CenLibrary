package com.dahee.cenlibrary.service.member;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.dto.MemberDto;
import com.dahee.cenlibrary.service.Service;

public class MemberSearchCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int index = 0;
		
		String req = null;
		String how = null;

		MemberDao dao = MemberDao.getInstance();
		req = (String) request.getParameter("obj");
		how = (String) request.getParameter("how");
		
		if (how.equals("아이디")) {
			index = 0;
		} else 
			index = 1;
		
		ArrayList<MemberDto> search =  dao.findInfo(req, index);
		
		request.setAttribute("search", search);
	}

}
