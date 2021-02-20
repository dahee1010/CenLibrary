package com.dahee.cenlibrary.service.board;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BoardDao;
import com.dahee.cenlibrary.service.Service;

public class BoardWriteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String wId = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Timestamp wDate = new Timestamp(System.currentTimeMillis());
		
		content = content.replace("\r\n","<br>");

		BoardDao dao = new BoardDao();
		int ri = dao.boardWrite(wId, title, content, wDate);

		model.addAttribute("ri", ri);
	}

}
