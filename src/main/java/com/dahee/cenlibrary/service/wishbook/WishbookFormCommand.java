package com.dahee.cenlibrary.service.wishbook;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.WishbookDao;
import com.dahee.cenlibrary.service.Service;

public class WishbookFormCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");


		String wbName = request.getParameter("wbName");
		String wbWriter = request.getParameter("wbWriter");
		String wbPublish = request.getParameter("wbPublish");
		int wbYear = Integer.parseInt(request.getParameter("wbYear"));

		WishbookDao dao = new WishbookDao();
		int ri = dao.wishbookAdd(wbName, wbWriter, wbPublish, wbYear);

		request.setAttribute("ri", ri);
		
	}
}
