package com.dahee.cenlibrary.service.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BoardDao;
import com.dahee.cenlibrary.service.Service;

public class BoardModifyCommand implements Service {
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int wNum = Integer.parseInt(request.getParameter("wNum"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		content = content.replace("\r\n", "<br>");

		BoardDao dao = new BoardDao();
		int ri = dao.boardModify(wNum, title, content);

		request.setAttribute("ri", ri);

	}
}
