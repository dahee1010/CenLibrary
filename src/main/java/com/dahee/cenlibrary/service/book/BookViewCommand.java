package com.dahee.cenlibrary.service.book;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.dao.ReviewDao;
import com.dahee.cenlibrary.dto.BookDto;
import com.dahee.cenlibrary.dto.ReviewDto;
import com.dahee.cenlibrary.service.Service;

public class BookViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 책 상세정보 보여주기
		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		
		BookDao dao = new BookDao();
		BookDto dto = dao.contentView(bookNum);

		request.setAttribute("view", dto);
		
		// 해당 책에 있는 리뷰 보여주기
		ReviewDao review = new ReviewDao();
		ArrayList<ReviewDto> dtos = review.reviewList(bookNum);

		request.setAttribute("review", dtos);

	}

}
