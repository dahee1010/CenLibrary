package com.dahee.cenlibrary.service.que;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.QueDao;
import com.dahee.cenlibrary.service.Service;

public class QueModifyCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String open = request.getParameter("open");

		content = content.replace("\r\n", "<br>");

		QueDao dao = new QueDao();
		int ri = dao.queModify(qNum, title, content, open);

		request.setAttribute("qNum", qNum);
		request.setAttribute("ri", ri);

	}
}
