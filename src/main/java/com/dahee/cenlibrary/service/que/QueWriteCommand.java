package com.dahee.cenlibrary.service.que;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.QueDao;
import com.dahee.cenlibrary.service.Service;

public class QueWriteCommand implements Service {
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String qId = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Timestamp qDate = new Timestamp(System.currentTimeMillis());
		String open = request.getParameter("open");

		content = content.replace("\r\n","<br>");
		
		QueDao dao = new QueDao();
		int ri = dao.queWrite(qId, title, content, qDate, open);

		request.setAttribute("ri", ri);
		
	}
}
