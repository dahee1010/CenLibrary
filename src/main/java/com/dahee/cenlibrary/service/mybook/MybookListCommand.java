package com.dahee.cenlibrary.service.mybook;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MybookDao;
import com.dahee.cenlibrary.dto.MybookDto;
import com.dahee.cenlibrary.service.Service;

public class MybookListCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		HttpSession session = request.getSession();
		String mbId = (String) session.getAttribute("id");

		MybookDao dao = new MybookDao();
		ArrayList<MybookDto> dtos = dao.mybookList(mbId);

		request.setAttribute("mbId", mbId);
		request.setAttribute("list", dtos);

	}
}
