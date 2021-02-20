package com.dahee.cenlibrary.service.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.service.Service;

public class BookDeleteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		
		BookDao dao = new BookDao();
		int ri = dao.bookDelete(bookNum);
		
		request.setAttribute("ri", ri);
	}

}
