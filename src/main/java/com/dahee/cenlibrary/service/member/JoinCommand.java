package com.dahee.cenlibrary.service.member;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MemberDao;
import com.dahee.cenlibrary.dto.MemberDto;
import com.dahee.cenlibrary.service.Service;

public class JoinCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String eMail = request.getParameter("eMail");

		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();

		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setGender(gender);
		dto.seteMail(eMail);
		dto.setrDate(new Timestamp(System.currentTimeMillis()));

		int confirmId = dao.confirmId(id);
		int ri = dao.insertMember(dto);

		request.setAttribute("ri", ri);
		request.setAttribute("confirmId", confirmId);
		
	}

}
