package com.dahee.cenlibrary.service.book;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.dto.BookDto;
import com.dahee.cenlibrary.service.Service;

public class BookRandomListCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		BookDao dao = new BookDao();
		ArrayList<BookDto> dtos = dao.radomBook();
		
		request.setAttribute("randombook", dtos);
		
	}
	
}
