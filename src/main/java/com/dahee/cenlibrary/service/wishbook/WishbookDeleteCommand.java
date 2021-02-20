package com.dahee.cenlibrary.service.wishbook;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.WishbookDao;
import com.dahee.cenlibrary.service.Service;

public class WishbookDeleteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String wbNum = request.getParameter("wbNum");

		WishbookDao dao = new WishbookDao();
		int ri = dao.wishbookDelete(wbNum);

		request.setAttribute("ri", ri);
	}
}
