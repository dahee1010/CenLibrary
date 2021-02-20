package com.dahee.cenlibrary.service.que;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.QueDao;
import com.dahee.cenlibrary.dto.QueDto;
import com.dahee.cenlibrary.service.Service;

public class QueViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));

		QueDao dao = new QueDao();
		QueDto dto = dao.contentView(qNum);

		request.setAttribute("view", dto);

	}
}
