package com.dahee.cenlibrary.service.member;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.dto.MemberDto;
import com.dahee.cenlibrary.service.Service;

public class MemberListCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		MemberDao dao = MemberDao.getInstance();

		int pagenum = 1; // 페이지 번호
		if (request.getParameter("memberPage") != null) {
			pagenum = Integer.parseInt(request.getParameter("memberPage"));
		}

		int data = 10; // 보여줄 데이터 크기
		int tot; // 페이지수

		int cnt = dao.memberCount();

		tot = cnt / data;

		if (cnt % data != 0) {
			tot++;
		}

		int start = ((pagenum - 1) * data) + 1;
		int end = pagenum * data;

		ArrayList<MemberDto> dtos = dao.memberList(start, end);

		request.setAttribute("list", dtos);
		request.setAttribute("tot", tot);
		
	}
}
