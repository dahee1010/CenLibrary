package com.dahee.cenlibrary.service.review;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.ReviewDao;
import com.dahee.cenlibrary.dto.ReviewDto;
import com.dahee.cenlibrary.service.Service;

public class ReviewListCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int bNum = Integer.parseInt(request.getParameter("bookNum"));
		
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewDto> dtos = dao.reviewList(bNum);
		
		request.setAttribute("list", dtos);
		
	}
}
